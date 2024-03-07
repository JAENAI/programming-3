package com.example.numpad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText area=(EditText) findViewById(R.id.textarea);

        for(int i=1;i<=9;i++){
            int btnId=getResources().getIdentifier("btn"+i,"id",getPackageName());
            Button btn=findViewById(btnId);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String txt=area.getText().toString();
                    if(txt.equals("Enter")){
                        area.setText(btn.getText());
                    }
                    else{
                        area.setText(txt+btn.getText());
                    }
                }
            });
        }
    }
}