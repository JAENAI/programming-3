package com.example.explicitintentwithparameters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText fn=(EditText) findViewById(R.id.firstname);
        EditText n=(EditText) findViewById(R.id.name);
        Button btn=(Button) findViewById(R.id.btn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,ViewActivity.class);
                i.putExtra("firstname",fn.getText().toString());
                i.putExtra("name",n.getText().toString());
                startActivity(i);
            }
        });

    }
}