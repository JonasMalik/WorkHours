package com.jonasmalik94.workhours.DB;

import android.support.annotation.RequiresPermission;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by jonas on 2016-10-24.
 */

public class DatabaseConfig extends OrmLiteConfigUtil{

    public static void main(String[] args) throws IOException, SQLException {
        writeConfigFile("ormlite_config.txt");
    }
}
