package com.example.explicitintentwithparameters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        Intent i=getIntent();
        String fn=i.getStringExtra("firstname");
        String n=i.getStringExtra("name");
        TextView tx=(TextView) findViewById(R.id.tx);
        String Hi="Hi ";
        String space=" ";
        String p="!";
        String fin=Hi+fn+space+n+p;
        tx.setText(fin);

    }
}
