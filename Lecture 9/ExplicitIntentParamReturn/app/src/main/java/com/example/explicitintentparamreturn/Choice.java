package com.example.explicitintentparamreturn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Choice extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice);

        RadioGroup Choices = findViewById(R.id.Choices);
        Button btnReturnResult = findViewById(R.id.btnSubmit);

        btnReturnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedRadioButtonId = Choices.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);

                // Return the selected option to FirstActivity
                if (selectedRadioButton != null) {
                    String resultValue = selectedRadioButton.getText().toString();

                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("result", resultValue);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            }
        });
    }
}
