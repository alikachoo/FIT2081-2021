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

import com.example.myapplication.provider.Car;

import java.util.ArrayList;
import java.util.List;

public class MyW6Adapter extends RecyclerView.Adapter<MyW6Adapter.ViewHolder>{
    List<Car> data = new ArrayList<Car>();
    String nameStr;
    String idStr;
    String priceStr;
    Context self;


    public MyW6Adapter(Context context) {
//        data = _data;
        self = context;
    }

    public void setData(List<Car> _data) {
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
        nameStr = String.valueOf(data.get(position).getName());
        idStr = String.valueOf(data.get(position).getCar_id());
        priceStr = String.valueOf(data.get(position).getCar_price());
        holder.name.setText(nameStr);
        holder.id.setText(idStr);
        holder.price.setText(priceStr);
        holder.car_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = "Car Name:" + nameStr;
                Toast toast = Toast.makeText(self, res, Toast.LENGTH_SHORT);
                toast.show();
//                RecyclerViewActivity.mCarViewModel.deleteModelCars(data.get(position).getModel());
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, id, price;
        ConstraintLayout car_card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // In itemView, find maker and model
            name = itemView.findViewById(R.id.carName);
            id = itemView.findViewById(R.id.carId);
            price = itemView.findViewById(R.id.carPrice);
            car_card = itemView.findViewById(R.id.car_card);


        }
    }
}
