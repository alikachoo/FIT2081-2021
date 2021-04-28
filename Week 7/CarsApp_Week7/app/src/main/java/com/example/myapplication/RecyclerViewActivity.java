package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    // Week 6 RecyclerView and CardView
    Button listBtn;
    FloatingActionButton fab_back;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    MyW6Adapter w6Adapter;
    ArrayList<Car> dataSource = new ArrayList<>();
    Context self;
    ConstraintLayout car_card;

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
        w6Adapter = new MyW6Adapter(self, dataSource);
        w6Adapter.setData(dataSource);

        recyclerView.setAdapter(w6Adapter);



        listBtn = findViewById(R.id.btn_list);
        listBtn.setOnClickListener(new View.OnClickListener() {
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

        fab_back = findViewById(R.id.fab_back);
        fab_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(self, MainActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("CARS", (Serializable) dataSource);
//                intent.putExtra("CARS_BUNDLE", bundle);
//                startActivity(intent);
                finish();
            }
        });
    }

}
