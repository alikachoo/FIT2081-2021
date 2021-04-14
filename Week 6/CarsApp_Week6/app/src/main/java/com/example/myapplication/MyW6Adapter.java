package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyW6Adapter extends RecyclerView.Adapter<MyW6Adapter.ViewHolder>{
    ArrayList<Car> data = new ArrayList<Car>();

//    public MyW6Adapter(ArrayList<Car> _data) {
//        data = _data;
//    }

    public void setData(ArrayList<Car> _data) {this.data = _data;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        ViewHolder holder = new ViewHolder(v);      // v reference Card view
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.maker.setText(String.valueOf(data.get(position).getMaker()));
        holder.model.setText(String.valueOf(data.get(position).getModel()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView maker;
        TextView model;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // In itemView, find maker and model
            maker = itemView.findViewById(R.id.makerCardId);
            model = itemView.findViewById(R.id.modelCardId);


        }
    }
}
