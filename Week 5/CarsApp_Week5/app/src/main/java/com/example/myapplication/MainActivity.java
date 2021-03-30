package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    // Lab extra tasks
    public static final String carMakerFile = "carMakerFile"; // File name
    public static final String LOAD_MAKER_KEY = "LOAD_MAKER_KEY"; // Key for

    public static final String WEEK_3_APP = "WEEK3APP";
    public static final String MAKER_KEY = "MAKER_KEY";
    public static final String MODEL_KEY = "MODEL_KEY";
    public static final String YEAR_KEY = "YEAR_KEY";
    public static final String COLOR_KEY = "COLOR_KEY";
    public static final String SEATS_KEY = "SEATS_KEY";
    public static final String PRICE_KEY = "PRICE_KEY";
    public static final String ADDRESS_KEY = "ADDRESS_KEY";
    Button button;
    Button buttonReset;
    Button buttonLoad;
    EditText maker;
    EditText model;
    EditText year;
    EditText color;
    EditText seats;
    EditText price;
    EditText address;

    // Week 5 Tasks
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    // List cars
    ListView listCars;
    ArrayList<String> cars;
    ArrayAdapter<String> adapter;

    Context self;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        self = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);

        cars = new ArrayList<>();

        listCars = findViewById(R.id.listCars);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cars);
        listCars.setAdapter(adapter);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);

        drawerLayout.addDrawerListener(toggle); // Links toolbar and drawerLayout together
        toggle.syncState();  // Since state between two elements
        navigationView=findViewById(R.id.nav_view);

        // FAB
        FloatingActionButton FAB_ADD = findViewById(R.id.FAB_ADD);

        FAB_ADD.setOnClickListener((view -> {
            String res = "";
            String makerInput = maker.getText().toString();
            String modelInput = model.getText().toString();
            res = makerInput + " | " + modelInput;
            cars.add(res);
            adapter.notifyDataSetChanged();
            Toast toast = Toast.makeText(self, "Added new car!", Toast.LENGTH_SHORT);
            toast.show();
            Snackbar.make(view, "replace with your own action"
                    ,Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }));

        FAB_ADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = "";
                String makerInput = maker.getText().toString();
                String modelInput = model.getText().toString();
                res = makerInput + " | " + modelInput;
                cars.add(res);
                adapter.notifyDataSetChanged();
                Toast toast = Toast.makeText(self, "Added new car!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.add_car:
                            String res = "";
                            String makerInput = maker.getText().toString();
                            String modelInput = model.getText().toString();
                            res = makerInput + " | " + modelInput;
                            cars.add(res);
                            adapter.notifyDataSetChanged();
                            Toast toast = Toast.makeText(self, "Added new car!", Toast.LENGTH_SHORT);
                            toast.show();
                        break;
                    case R.id.remove_last_car:
                        if (cars.size() > 0) {
                            cars.remove(cars.size()-1);
                            adapter.notifyDataSetChanged();
                            Toast toastLast = Toast.makeText(self, "Removed the last car!", Toast.LENGTH_SHORT);
                            toastLast.show();
                        }
                        break;
                    case R.id.remove_all_cars:
                        cars.clear();
                        adapter.notifyDataSetChanged();
                        Toast toastAll = Toast.makeText(self, "Removed all cars successfully!", Toast.LENGTH_SHORT);
                        toastAll.show();
                        break;
                }
                return false;
            }
        });

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS, Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS}, 0);
        MyBroadCastReceiver myBroadCastReceiver = new MyBroadCastReceiver();
        registerReceiver(myBroadCastReceiver, new IntentFilter(SMSReceiver.SMS_FILTER));


        maker = (EditText) findViewById(R.id.makerInput);
        model = (EditText) findViewById(R.id.modelInput);
        year = (EditText) findViewById(R.id.yearInput);
        color = (EditText) findViewById(R.id.colorInput);
        seats = (EditText) findViewById(R.id.seatsInput);
        price = (EditText) findViewById(R.id.priceInput);
        address = (EditText) findViewById(R.id.addressInput);

        Log.d(WEEK_3_APP, "onCreate");

        Context context = getApplicationContext();

        maker = (EditText) findViewById(R.id.makerInput);
// Previous workshop buttons
//        button.setOnClickListener(new View.OnClickListener() {
//            // Test
//            /* Test Test*/
//            @Override
//            public void onClick(View v) {
//                String makerInput = maker.getText().toString();
//                String result = "We added a new car (" + makerInput + ")";
//                Toast toast = Toast.makeText(context, result, Toast.LENGTH_SHORT);
//                toast.show();
//
//                // Extra Lab Task Week 3 Question 2:
//                SharedPreferences spMaker = getSharedPreferences(carMakerFile, 0);
//                SharedPreferences.Editor ed = spMaker.edit();
//                ed.putString(LOAD_MAKER_KEY,makerInput);
//                ed.apply();
//            }
//        });
//
//        buttonReset.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                maker.setText("");
//                model.setText("");
//                year.setText("");
//                color.setText("");
//                seats.setText("");
//                price.setText("");
//                address.setText("");
//
//                Toast toast = Toast.makeText(self, "Reset successful!", Toast.LENGTH_SHORT);
//                toast.show();
//            }
//        });
//
//        buttonLoad.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SharedPreferences sP=getSharedPreferences(carMakerFile,0);
//                String makerData = sP.getString(LOAD_MAKER_KEY, "");
//                maker.setText(makerData);
//                Toast toast = Toast.makeText(context, "Load successful", Toast.LENGTH_SHORT);
//                toast.show();
//            }
//        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences sP = getPreferences(0);

        String makerData = sP.getString(MAKER_KEY, "");
        String modelData = sP.getString(MODEL_KEY, "");
        String yearData = sP.getString(YEAR_KEY, "");
        String colorData = sP.getString(COLOR_KEY, "");
        String seatsData = sP.getString(SEATS_KEY, "");
        String priceData = sP.getString(PRICE_KEY, "");
        String addressData = sP.getString(ADDRESS_KEY, "");

        maker.setText(makerData);
        model.setText(modelData);
        year.setText(yearData);
        color.setText(colorData);
        seats.setText(seatsData);
        price.setText(priceData);
        address.setText(addressData);

        Log.d(WEEK_3_APP, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sP = getPreferences(0);
        SharedPreferences.Editor editor = sP.edit();
        // Grab the data
        String makerData = maker.getText().toString();
        String modelData = model.getText().toString();
        String yearData = year.getText().toString();
        String colorData = color.getText().toString();
        String seatsData = seats.getText().toString();
        String priceData = price.getText().toString();
        String addressData = address.getText().toString();

        // Input the string
        editor.putString(MAKER_KEY, makerData);
        editor.putString(MODEL_KEY, modelData);
        editor.putString(YEAR_KEY, yearData);
        editor.putString(COLOR_KEY, colorData);
        editor.putString(SEATS_KEY, seatsData);
        editor.putString(PRICE_KEY, priceData);
        editor.putString(ADDRESS_KEY, addressData);
        editor.apply();

        Log.d(WEEK_3_APP, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(WEEK_3_APP, "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(WEEK_3_APP, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(WEEK_3_APP, "onResume");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(WEEK_3_APP, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(WEEK_3_APP, "onRestoreInstanceState");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.clear_fields:
                maker.setText("");
                model.setText("");
                year.setText("");
                color.setText("");
                seats.setText("");
                price.setText("");
                address.setText("");

                Toast toast = Toast.makeText(self, "Reset successful!", Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    class MyBroadCastReceiver extends BroadcastReceiver {

        /*
         * This method 'onReceive' will get executed every time class SMSReceive sends a broadcast
         * */
        @Override
        public void onReceive(Context context, Intent intent) {
            /*
             * Retrieve the message from the intent
             * */
            String msg = intent.getStringExtra(SMSReceiver.SMS_MSG_KEY);
            /*
             * String Tokenizer is used to parse the incoming message
             * The protocol is to have the account holder name and account number separate by a semicolon
             * */

            StringTokenizer sT = new StringTokenizer(msg, ";");
            String makerStr = sT.nextToken();
            String modelStr = sT.nextToken();
            String yearStr = sT.nextToken();
            String colorStr = sT.nextToken();
            String seatsStr = sT.nextToken();
            int numSeats = Integer.parseInt(seatsStr);
            if (numSeats < 4 || numSeats > 8) {
                seatsStr = "Error: Must be between 4-8";
            }
            String priceStr = sT.nextToken();
            String addressStr = sT.nextToken();
            /*
             * Now, its time to update the UI
             * */
            maker.setText(makerStr);
            model.setText(modelStr);
            year.setText(yearStr);
            color.setText(colorStr);
            seats.setText(seatsStr);
            price.setText(priceStr);
            address.setText(addressStr);
        }
    }


}