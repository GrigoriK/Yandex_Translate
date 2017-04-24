package com.example.grishany.yandex_mobilization2017;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;

/**
 * Created by Grishany on 24.04.2017.
 */

public class DataBase extends SQLiteOpenHelper {
    public static final String DB_NAME = "base1";
    public static final String Table_NAME = "Languages";
    public static final int version_BASE = 1;
    public static final String KEY_ID = "id";
    public static final String KEY_Code = "name";
    HashMap<String, String> map1 = new HashMap<String, String>();

    static final String KEY_Lang = "Language";

    DataBase(Context context) {
        super(context, DB_NAME, null, version_BASE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + Table_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_Code + " TEXT,"
                + KEY_Lang + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static void insertLang(SQLiteDatabase db, String code,
                                  String language) {
        ContentValues lang = new ContentValues();
        lang.put(KEY_Code, code);
        lang.put(KEY_Lang, language);
        db.insert(Table_NAME, null, lang);

    }

}
