package com.example.myapplication.provider;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SimpleSQLiteQuery;

import java.util.List;

public class CarRepository {
    private CarDao mCarDao;
    private LiveData<List<Car>> mAllCars;
    CarRepository(Application application) {
        CarDatabase db = CarDatabase.getDatabase(application);

        mCarDao = db.carDao();
        mAllCars = mCarDao.getAllCars();
    }
    LiveData<List<Car>> getAllCars() {
        return mAllCars;
    }
    void insert(Car Car) {
        CarDatabase.databaseWriteExecutor.execute(() -> mCarDao.addCar(Car));
    }
    void deleteAll(){
        CarDatabase.databaseWriteExecutor.execute(()->{
            mCarDao.deleteAllCars();
        });
    }


}
