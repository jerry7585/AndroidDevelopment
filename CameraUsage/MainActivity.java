package com.example.assignment6_camera;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.Manifest;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.*;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int VIDEO_REQUEST_CODE = 2;
    private static final int OPEN_PHOTO_ALBUM = 3;
    private Uri videoUri;
    String currentPhotoPath, currentVideoPath;
    Uri photoURI;

    VideoView videoView;
    ImageView Folder;

    ActivityResultLauncher<Intent> ImageCaptureActivityResultLauncher;
    ActivityResultLauncher<Intent> videoCaptureActivityResultLauncher;

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JEPG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName,".jpg",storageDir);
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    private File createVideoFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String videoFileName = "VID_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_MOVIES);
        File videoFile = File.createTempFile(videoFileName,".mp4", storageDir);
        // Save a file: path for use with ACTION_VIEW intents
        currentVideoPath = videoFile.getAbsolutePath();
        return videoFile;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button newcamera = (Button) this.findViewById(R.id.button);
        newcamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });

        Folder = (ImageView) findViewById(R.id.Folder);
        Button openFolder = (Button) this.findViewById(R.id.openFolder);
        openFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                File[] files = storageDir.listFiles();
                if (files != null && files.length > 0) {
                    System.out.println("Not empty folder");
                } else {
                    System.out.println("Empty Folder");
                }
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("file://" + getExternalFilesDir(Environment.DIRECTORY_PICTURES));
                intent.setDataAndType(uri, "*/*");
                startActivityForResult(intent, 3);
            }
        });

        Button videoButton = (Button) this.findViewById(R.id.record);
        videoView = (VideoView) this.findViewById(R.id.videoView);
        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vid = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(vid, 2);
            }
        });

        ActivityResultLauncher<String[]> cameraPermissionRequest =
                registerForActivityResult(new ActivityResultContracts
                        .RequestMultiplePermissions(), result -> {});
        cameraPermissionRequest.launch(new String[]{Manifest.permission.CAMERA});

        ImageCaptureActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK){
                            Bitmap imageBitmap = null;
                            try{
                                ImageDecoder.Source source = null;
                                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
                                    source = ImageDecoder.createSource(getContentResolver(), photoURI);
                                }
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                                    imageBitmap = ImageDecoder.decodeBitmap(source);
                                }
                            }
                            catch (IOException e){
                                e.printStackTrace();
                            }
                            ImageView mImageView = (ImageView) findViewById(R.id.mimage);
                            mImageView.setImageBitmap(imageBitmap);
                        }
                    }
                }
        );

    }


    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File photoFile = null;
        try {
            photoFile = createImageFile();
        } catch(IOException ex){
            //error creating file
        }

        if (photoFile != null){
            photoURI = FileProvider.getUriForFile(this, "com.example.android.fileprovider2", photoFile);
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
            ImageCaptureActivityResultLauncher.launch(takePictureIntent);
            // Add the following lines to save the image to the photo album
            Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            File f = new File(currentPhotoPath);
            Uri contentUri = Uri.fromFile(f);
            mediaScanIntent.setData(contentUri);
            this.sendBroadcast(mediaScanIntent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_IMAGE_CAPTURE:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(photoURI));
                        ImageView mImageView = (ImageView) findViewById(R.id.mimage);
                        mImageView.setImageBitmap(bitmap);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            case VIDEO_REQUEST_CODE:
                Uri videoURI = data.getData();
                videoView.setVideoURI(videoURI);
                videoView.setMediaController(new MediaController(this));
                videoView.requestFocus();
                videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        mediaPlayer.setLooping(true);
                    }
                });
                videoView.start();
                break;
            case OPEN_PHOTO_ALBUM:
                Uri selectedImage = data.getData();
                System.out.println(selectedImage.toString());
                Folder.setImageURI(selectedImage);
                break;
            default:
                break;
        }
    }


}