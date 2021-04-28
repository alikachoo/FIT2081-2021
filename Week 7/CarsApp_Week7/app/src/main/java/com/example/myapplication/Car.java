package com.example.myapplication;

import java.io.Serializable;

public class Car implements Serializable {
    private String maker;
    private String model;

    public Car(String maker, String model) {
        this.maker = maker;
        this.model = model;
    }

    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }
}
