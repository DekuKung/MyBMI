package com.example.mybmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Cal;
        Cal = findViewById(R.id.calculate);
        Cal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                CalBMI();
            }
        });
    }

    private void CalBMI() {
        EditText hei;
        EditText wei;
        hei = findViewById(R.id.height);
        wei = findViewById(R.id.weight);

        double w = Double.parseDouble(wei.getText().toString());
        double h = Double.parseDouble(hei.getText().toString());

        h = h/100; // Meter
        double bmi = w / (h*h);

        DecimalFormat decformat  = new DecimalFormat("##.##");

        String msg = "Your BMI is "+ decformat.format(bmi) + "\n";
        msg += "Your Body is : ";
        if (bmi >= 30) {msg += "So Fat Please Diet";}
        else if (bmi >= 25) {msg += "Normal Fat";}
        else if (bmi >= 23) {msg += "Over Weight";}
        else if (bmi >= 18.5) {msg += "Normal Body";}
        else { msg += "So Skinny"; }

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
