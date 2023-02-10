package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    TextView total, counter, tenDcounter, fiveDcounter, oneDcounter, twentyfiveCcounter, tenCcounter, fiveCcounter, oneCcounter;

    double temp = 0.0;
    double current = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        total = (TextView) findViewById(R.id.total);
        counter = (TextView) findViewById(R.id.counter);
        tenDcounter = (TextView) findViewById(R.id.tenDcounter);
        fiveDcounter = (TextView) findViewById(R.id.fiveDcounter);
        oneDcounter = (TextView) findViewById(R.id.oneDcounter);
        twentyfiveCcounter = (TextView) findViewById(R.id.twentyfiveCcounter);
        tenCcounter = (TextView) findViewById(R.id.tenCcounter);
        fiveCcounter = (TextView) findViewById(R.id.fiveCcounter);
        oneCcounter = (TextView) findViewById(R.id.oneCcounter);
    }

    public void clearButton(View view){
        total.setText("0.00");
        counter.setText("0");
        tenDcounter.setText("0");
        fiveDcounter.setText("0");
        oneDcounter.setText("0");
        twentyfiveCcounter.setText("0");
        tenCcounter.setText("0");
        fiveCcounter.setText("0");
        oneCcounter.setText("0");
    }

    public void numPad(View view){
        //Update the total count
        Button b = (Button) view;
        temp = Double.parseDouble(b.getText().toString())/100;
        current = Double.parseDouble(total.getText().toString());
        current = current * 10 + temp;
        //System.out.println(current);
        total.setText(String.valueOf(String.format("%.2f",current)));

        System.out.println(current);

        //Update the breakdown of coins
        double remaining = current*100;

        int count20 = (int) remaining/2000;
        remaining = remaining%2000;
        counter.setText(String.valueOf(count20));

        int count10 = (int) remaining/1000;
        remaining = remaining%1000;
        tenDcounter.setText(String.valueOf(count10));

        int count5 = (int) remaining/500;
        remaining = remaining%500;
        fiveDcounter.setText(String.valueOf(count5));

        int count1 = (int) remaining/100;
        remaining = remaining%100;
        oneDcounter.setText(String.valueOf(count1));

        int count25c = (int) remaining/25;
        remaining = remaining%25;
        twentyfiveCcounter.setText(String.valueOf(count25c));

        int count10c = (int) remaining/10;
        remaining = remaining%10;
        tenCcounter.setText(String.valueOf(count10c));

        int count5c = (int) remaining/5;
        remaining = remaining%5;
        fiveCcounter.setText(String.valueOf(count5c));

        int count1c = (int) remaining;
        oneCcounter.setText(String.valueOf(count1c));

    }
}