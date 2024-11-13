package com.example.ejemplosqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSqlite extends SQLiteOpenHelper {
    private String sqlCreate="CREATE TABLE alumno(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,name TEXT)";
    private AdminSqlite adminSqliteHelper;
    private SQLiteDatabase db;
    public AdminSqlite(Context context,String name,SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS alumno");
        sqLiteDatabase.execSQL(sqlCreate);
    }
}
