package com.jonasmalik94.workhours.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.jonasmalik94.workhours.R;

import java.sql.SQLException;

/**
 * Created by jonas on 2016-10-24.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "calendar.db";
    private static final int DATABASE_Version = 1;

    private Dao<WorkDays,Integer> workDaysDao = null;
    private RuntimeExceptionDao<WorkDays,Integer> workDaysRuntimeDao = null;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_Version, R.raw.ormlite_config );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, WorkDays.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource, WorkDays.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Dao<WorkDays,Integer> getWorkDaysDao() throws SQLException {
        if (workDaysDao == null){
            workDaysDao = getDao(WorkDays.class);
        }
        return workDaysDao;
    }

    public RuntimeExceptionDao<WorkDays,Integer> getWorkDaysRuntimeDao() throws SQLException {
        if (workDaysRuntimeDao == null){
            workDaysRuntimeDao = getRuntimeExceptionDao(WorkDays.class);
        }
        return workDaysRuntimeDao;
    }

    public void createMyTable() throws SQLException {
        if (workDaysRuntimeDao == null){
            workDaysRuntimeDao = getRuntimeExceptionDao(WorkDays.class);
        }
        TableUtils.createTableIfNotExists(connectionSource, WorkDays.class);
    }



}
