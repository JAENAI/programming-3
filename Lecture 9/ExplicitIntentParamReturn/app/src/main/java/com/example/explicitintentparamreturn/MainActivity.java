package com.example.explicitintentparamreturn;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public final int REQUEST_CODE_CHOICE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button choose=(Button) findViewById(R.id.btnChoice);
        TextView txchoice=(TextView) findViewById(R.id.choice);

        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, Choice.class);
                startActivityForResult(i,REQUEST_CODE_CHOICE);
            }
        });

        Intent receivedIntent = getIntent();
        if (receivedIntent != null) {
            String resultValue = receivedIntent.getStringExtra("result");
            if (resultValue != null) {
                txchoice.setText("Your choice is :  " + resultValue);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_CHOICE && resultCode == RESULT_OK) {
            if (data != null) {
                String resultValue = data.getStringExtra("result");
                TextView textViewResult = findViewById(R.id.choice);
                textViewResult.setText("Your choice is : " + resultValue);
            }
        }
    }
}