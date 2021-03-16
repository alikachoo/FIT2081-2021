package com.example.myapplication;

import androidx.annotation.NonNull;
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
    protected void onStart() {
        super.onStart();
        Log.d("WEEK3APP", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("WEEK3APP", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("WEEK3APP", "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("WEEK3APP", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("WEEK3APP", "onResume");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("WEEK3APP", "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("WEEK3APP", "onRestoreInstanceState");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("WEEK3APP", "onCreate");

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