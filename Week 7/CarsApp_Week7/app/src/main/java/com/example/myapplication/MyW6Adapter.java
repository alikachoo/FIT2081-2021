package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyW6Adapter extends RecyclerView.Adapter<MyW6Adapter.ViewHolder>{
    ArrayList<Car> data = new ArrayList<Car>();
    String makerStr;
    String modelStr;
    Context self;

    public MyW6Adapter(Context context, ArrayList<Car> _data) {
        data = _data;
        self = context;
    }

    public void setData(ArrayList<Car> _data) {
        this.data = _data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        ViewHolder holder = new ViewHolder(v);      // v reference Card view
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        makerStr = String.valueOf(data.get(position).getMaker());
        modelStr = String.valueOf(data.get(position).getModel());
        holder.maker.setText(makerStr);
        holder.model.setText(modelStr);
        holder.car_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = "Car No." + String.valueOf(position + 1) + " with name: " + makerStr + " and model: " + modelStr + " is selected";
                Toast toast = Toast.makeText(self, res, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView maker;
        TextView model;
        ConstraintLayout car_card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // In itemView, find maker and model
            maker = itemView.findViewById(R.id.makerCardId);
            model = itemView.findViewById(R.id.modelCardId);
            car_card = itemView.findViewById(R.id.car_card);


        }
    }
}
