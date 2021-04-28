package com.example.myapplication.provider;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.provider.Car;

import java.util.List;
@Dao
public interface CarDao {
    @Query("select * from car")
    LiveData<List<Car>> getAllCars();

    @Query("select * from car where carName=:name")
    List<Car> getCar(String name);

    @Insert
    void addCar(Car car);

    @Query("delete from car where carName= :name")
    void deleteCar(String name);

    @Query("delete FROM car")
    void deleteAllCars();

//    @Query("delete FROM car where carModel =:model")
//    void deleteModelCars(String model);
}