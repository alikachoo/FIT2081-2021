package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button buttonReset;
    EditText maker;

    // Testing github

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();

        button = findViewById(R.id.btn_addNewCar);
        buttonReset = findViewById(R.id.btn_reset);
        maker = (EditText) findViewById(R.id.makerInput);


        button.setOnClickListener(new View.OnClickListener() {
            // Test
            /* Test Test*/
            @Override
            public void onClick(View v) {
                String makerInput = maker.getText().toString();
                String result = "We added a new car (" + makerInput + ")";
                Toast toast = Toast.makeText(context, result, Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView maker = (TextView) findViewById(R.id.makerInput);
                TextView model = (TextView) findViewById(R.id.modelInput);
                TextView year = (TextView) findViewById(R.id.yearInput);
                TextView color = (TextView) findViewById(R.id.colorInput);
                TextView seats = (TextView) findViewById(R.id.seatsInput);
                TextView price = (TextView) findViewById(R.id.priceInput);
                TextView address = (TextView) findViewById(R.id.addressInput);

                maker.setText("");
                model.setText("");
                year.setText("");
                color.setText("");
                seats.setText("");
                price.setText("");
                address.setText("");

                Toast toast = Toast.makeText(context, "Reset successful!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}