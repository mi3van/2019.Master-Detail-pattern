package com.mi3van.master_detail.data;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Ivan Kuzmin on 26.10.2019;
 * 3van@mail.ru;
 * Copyright © 2019 Example. All rights reserved.
 */

public class DbOpenHelper extends SQLiteAssetHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "androids_about.db";
    private static final String TABLE_ABOUT = "androids_about.db";

    public static final String KEY_ID = "id";
    public static final String KEY_VERSION = "version";
    public static final String KEY_NAME = "name";
    public static final String KEY_RELEASED = "released";
    public static final String KEY_API = "api";
    public static final String KEY_DISTRIBUTION = "distribution";
    public static final String KEY_FAVOURITE = "favourites";
    public static final String KEY_DESCRIPTION = "description";

    public DbOpenHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

}
