package com.mi3van.master_detail.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mi3van.master_detail.domain.entitie.VersionModel;

import java.util.ArrayList;
import java.util.List;

import static com.mi3van.master_detail.data.DbOpenHelper.KEY_API;
import static com.mi3van.master_detail.data.DbOpenHelper.KEY_DESCRIPTION;
import static com.mi3van.master_detail.data.DbOpenHelper.KEY_DISTRIBUTION;
import static com.mi3van.master_detail.data.DbOpenHelper.KEY_FAVOURITE;
import static com.mi3van.master_detail.data.DbOpenHelper.KEY_ID;
import static com.mi3van.master_detail.data.DbOpenHelper.KEY_NAME;
import static com.mi3van.master_detail.data.DbOpenHelper.KEY_RELEASED;
import static com.mi3van.master_detail.data.DbOpenHelper.KEY_VERSION;

/**
 * Created by Ivan Kuzmin on 2019-10-30;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

public class DbAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;

    public DbAccess(DbOpenHelper openHelper) {
        this.openHelper = openHelper;
    }

    public void open() {
        db = openHelper.getWritableDatabase();
    }

    public void close() {
        if (db != null) {
            db.close();
        }
    }

    public List<VersionModel> getVersionsList() {
        open();
        Cursor dbCursor = db.rawQuery("select * from androids order by " + KEY_API + " asc", new String[]{});
        dbCursor.moveToFirst();
        List<VersionModel> androids = new ArrayList<>();
        androids.add(getVersionModel(dbCursor));
        while (dbCursor.moveToNext()) {
            androids.add(getVersionModel(dbCursor));
        }
        close();
        return androids;
    }

    private VersionModel getVersionModel(Cursor dbCursor) {
        int id = dbCursor.getInt(dbCursor.getColumnIndex(KEY_ID));
        float version = dbCursor.getFloat(dbCursor.getColumnIndex(KEY_VERSION));
        String name = dbCursor.getString(dbCursor.getColumnIndex(KEY_NAME));
        String released = dbCursor.getString(dbCursor.getColumnIndex(KEY_RELEASED));
        int api = dbCursor.getInt(dbCursor.getColumnIndex(KEY_API));
        float distribution = dbCursor.getFloat(dbCursor.getColumnIndex(KEY_DISTRIBUTION));
        boolean isFavourite = dbCursor.getInt(dbCursor.getColumnIndex(KEY_FAVOURITE)) == 1;
        String description = dbCursor.getString(dbCursor.getColumnIndex(KEY_DESCRIPTION));
        return new VersionModel(id, version, name, released, api, distribution, isFavourite, description);
    }
}
