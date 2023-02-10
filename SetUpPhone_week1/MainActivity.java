//Jerry Su ESE343 112620114
package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //"com.example.myfirstapp.MESSAGE"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* called when user clicks send*/
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public void sendMessage(View view){

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();

        //System.out.println(message);

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}