package com.example.julioc98.todoapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.julioc98.todoapp.dao.ToDoDAO;
import com.example.julioc98.todoapp.model.ToDo;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        txtView = (TextView) findViewById(R.id.txtView);

        testarBanco();


    }

    private void testarBanco(){
        ToDoDAO dao = new ToDoDAO(this);

        ToDo todo1 = new ToDo();
        todo1.setDescricao("Aprender Android");

        dao.criar(todo1);

        ToDo todo2 = new ToDo();
        todo2.setDescricao("Arrumar emprego");

        dao.criar(todo2);

        List<ToDo> todos = dao.listarTodos();

        StringBuilder sb = new StringBuilder();

        for (ToDo todo : todos){
            sb.append(todo.getDescricao());
            sb.append("\n");
        }

        txtView.setText(sb);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
