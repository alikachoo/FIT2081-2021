package com.example.myapplication.provider;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "car")
public class Car implements Serializable {

    @PrimaryKey(autoGenerate=true)
    @NonNull
    @ColumnInfo(name="carId")
    private int car_id;

    @ColumnInfo(name="carName")
    private String name;

    @ColumnInfo(name="car_price")
    private int car_price;

    private String maker;
    private String model;


    public Car(String name, String model, int car_id, int car_price) {
        this.maker = name;
        this.model = model;
        this.car_id = car_id;
        this.name = name;
        this.car_price = car_price;
    }

    public int getCar_id() {
        return car_id;
    }

    public String getName() {
        return name;
    }

    public int getCar_price() {
        return car_price;
    }

    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }

    public void setCar_id(@NonNull int car_id) {
        this.car_id = car_id;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCar_price(int car_price) {
        this.car_price = car_price;
    }
}
