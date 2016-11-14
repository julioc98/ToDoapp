package com.example.julioc98.todoapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.julioc98.todoapp.model.ToDo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by julioc98 on 08/11/16.
 */

public class ToDoDAO  {

    private ToDoSqLiteHelper dbHelper;

    public ToDoDAO(Context context){
        dbHelper = new ToDoSqLiteHelper(context);
    }

    public void criar(ToDo todo){
        ContentValues valores = new ContentValues();
        valores.put("descricao", todo.getDescricao());
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.insert("todos", null, valores);
        db.close();
    }

    public List<ToDo> listarTodos(){
        List<ToDo> todos = new ArrayList<>();
        //Nome das colunas que iremos selecionar
        String[] colunas = new  String[] {"_id", "descricao"};
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("todos", colunas, null, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            ToDo todo = new ToDo();
            todo.setId(cursor.getInt(cursor.getColumnIndex("_id")));
            todo.setDescricao(cursor.getString(
                    cursor.getColumnIndex("descricao")));
            todos.add(todo);

            cursor.moveToNext();
        }
        db.close();
        return todos;
    }
}
