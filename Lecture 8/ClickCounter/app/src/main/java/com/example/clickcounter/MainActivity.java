package com.example.clickcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int c=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView count=(TextView) findViewById(R.id.count);
        Button btn=(Button) findViewById(R.id.btn);
        btn.setText("button");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c++;
                count.setText("Count:"+c);
            }
        });

    }
}