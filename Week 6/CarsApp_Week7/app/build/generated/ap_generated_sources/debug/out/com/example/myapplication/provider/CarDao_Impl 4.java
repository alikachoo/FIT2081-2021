package com.example.myapplication.provider;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CarDao_Impl implements CarDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Car> __insertionAdapterOfCar;

  private final SharedSQLiteStatement __preparedStmtOfDeleteCar;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllCars;

  public CarDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCar = new EntityInsertionAdapter<Car>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `car` (`carId`,`carName`,`car_price`,`maker`,`model`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Car value) {
        stmt.bindLong(1, value.getCar_id());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        stmt.bindLong(3, value.getCar_price());
        if (value.getMaker() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getMaker());
        }
        if (value.getModel() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getModel());
        }
      }
    };
    this.__preparedStmtOfDeleteCar = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete from car where carName= ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllCars = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete FROM car";
        return _query;
      }
    };
  }

  @Override
  public void addCar(final Car car) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCar.insert(car);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteCar(final String name) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteCar.acquire();
    int _argIndex = 1;
    if (name == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, name);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteCar.release(_stmt);
    }
  }

  @Override
  public void deleteAllCars() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllCars.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllCars.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Car>> getAllCars() {
    final String _sql = "select * from car";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"car"}, false, new Callable<List<Car>>() {
      @Override
      public List<Car> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCarId = CursorUtil.getColumnIndexOrThrow(_cursor, "carId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "carName");
          final int _cursorIndexOfCarPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "car_price");
          final int _cursorIndexOfMaker = CursorUtil.getColumnIndexOrThrow(_cursor, "maker");
          final int _cursorIndexOfModel = CursorUtil.getColumnIndexOrThrow(_cursor, "model");
          final List<Car> _result = new ArrayList<Car>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Car _item;
            final int _tmpCar_id;
            _tmpCar_id = _cursor.getInt(_cursorIndexOfCarId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final int _tmpCar_price;
            _tmpCar_price = _cursor.getInt(_cursorIndexOfCarPrice);
            final String _tmpModel;
            _tmpModel = _cursor.getString(_cursorIndexOfModel);
            _item = new Car(_tmpName,_tmpModel,_tmpCar_id,_tmpCar_price);
            final String _tmpMaker;
            _tmpMaker = _cursor.getString(_cursorIndexOfMaker);
            _item.setMaker(_tmpMaker);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public List<Car> getCar(final String name) {
    final String _sql = "select * from car where carName=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfCarId = CursorUtil.getColumnIndexOrThrow(_cursor, "carId");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "carName");
      final int _cursorIndexOfCarPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "car_price");
      final int _cursorIndexOfMaker = CursorUtil.getColumnIndexOrThrow(_cursor, "maker");
      final int _cursorIndexOfModel = CursorUtil.getColumnIndexOrThrow(_cursor, "model");
      final List<Car> _result = new ArrayList<Car>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Car _item;
        final int _tmpCar_id;
        _tmpCar_id = _cursor.getInt(_cursorIndexOfCarId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final int _tmpCar_price;
        _tmpCar_price = _cursor.getInt(_cursorIndexOfCarPrice);
        final String _tmpModel;
        _tmpModel = _cursor.getString(_cursorIndexOfModel);
        _item = new Car(_tmpName,_tmpModel,_tmpCar_id,_tmpCar_price);
        final String _tmpMaker;
        _tmpMaker = _cursor.getString(_cursorIndexOfMaker);
        _item.setMaker(_tmpMaker);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
