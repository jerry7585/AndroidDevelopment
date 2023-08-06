package com.example.ese343finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.ese343finalproject.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner category = findViewById(R.id.category);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.Problems, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        category.setAdapter(adapter);

        ImageView imageView = findViewById(R.id.picture);
        imageView.setImageResource(R.drawable.seeclickfixlogo);

        TextView textView = findViewById(R.id.description);
        textView.setText("This app will give you an approximate time of how long your issue will need to be resolved. Additionally, there will be a given reason on why the approximate time is what it is.\n It is done using an open source API to gather real life requests in order to produce accurate predictions on the fairness of each request category.");

        TextView textViewPlace = findViewById(R.id.placeOfApp);
        textViewPlace.setText("Working for Newark, NJ");

    }

    public void getAverageTime(View view){
        Intent intent = new Intent(this, PageTwo.class);

        Spinner category = findViewById(R.id.category);
        String selectedCategory = (String) category.getSelectedItem();

        System.out.println(selectedCategory);
        intent.putExtra(EXTRA_MESSAGE, selectedCategory);
        startActivity(intent);
    }
}