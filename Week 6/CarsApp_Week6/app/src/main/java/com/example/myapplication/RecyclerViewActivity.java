package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    // Week 6 RecyclerView and CardView
    Button backBtn;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    MyW6Adapter w6Adapter;
    ArrayList<Car> dataSource = new ArrayList<>();
    Context self;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        self = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        // Week 6 RecyclerView and CardView
        recyclerView = findViewById(R.id.recycler_view_id);
        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // context to access the current activity
        recyclerView.setLayoutManager(layoutManager);
        w6Adapter = new MyW6Adapter();
        w6Adapter.setData(dataSource);

        recyclerView.setAdapter(w6Adapter);



        backBtn = findViewById(R.id.btn_back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getIntent().getBundleExtra("CARS_BUNDLE");
                dataSource = (ArrayList<Car>) bundle.getSerializable("CARS");
                w6Adapter.setData(dataSource);
                w6Adapter.notifyDataSetChanged();
                Log.d("WEEK3APP", "->" + String.valueOf(dataSource.size()));
                Toast toastLast = Toast.makeText(self, "Here's all the cars!", Toast.LENGTH_SHORT);
                toastLast.show();
            }
        });
    }

}
