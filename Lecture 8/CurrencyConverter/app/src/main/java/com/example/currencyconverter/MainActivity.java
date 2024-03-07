package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.KeyEvent;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText euros = (EditText) findViewById(R.id.euros);
        final EditText bitcoin= (EditText) findViewById(R.id.bitcoin);
        euros.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent)
            {
                double euros = Double.parseDouble(textView.getText().toString());
                bitcoin.setText(Double.toString(euros*34672));
                return true;
            }
        });
        bitcoin.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent)
            {
                double bitcoin = Double.parseDouble(textView.getText().toString());
                euros.setText(Double.toString(bitcoin/34672));
                return true;
            }
        });
    }
}
