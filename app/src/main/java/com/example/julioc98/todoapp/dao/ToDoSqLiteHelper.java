package com.example.julioc98.todoapp.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by julioc98 on 08/11/16.
 */

public class ToDoSqLiteHelper extends SQLiteOpenHelper {

    public ToDoSqLiteHelper(Context context){
        super(context, "todo.db", null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE todos(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "descricao TEXT NOT NULL); ");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
