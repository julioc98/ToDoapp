package com.example.julioc98.todoapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import org.w3c.dom.Text;

public class loginActivity extends AppCompatActivity {

    private TextInputLayout tilUsuario;
    private TextInputLayout tilSenha;
    private CheckBox cbManterConectado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tilUsuario = (TextInputLayout) findViewById(R.id.tilUsuario);
        tilSenha = (TextInputLayout) findViewById(R.id.tilSenha);
        cbManterConectado = (CheckBox) findViewById(R.id.cbManterConectado);

        SharedPreferences settings  = getSharedPreferences("PREFERENCIAS",
                MODE_PRIVATE);
        if(settings.getBoolean("MANTERCONECTADO", false) == true){
            abrirTela();
        }
    }

    public void fazerLogin(View view){
        String usuario = tilUsuario.getEditText().getText().toString();
        String senha = tilSenha.getEditText().getText().toString();

        if (usuario.equals("admin") && senha.equals("1234")){

            if (cbManterConectado.isChecked()){
                SharedPreferences settings = getSharedPreferences("PREFERENCIAS",
                                                                    MODE_PRIVATE);

                SharedPreferences.Editor editor = settings.edit();
                editor.putString("USUARIO", usuario);
                editor.putBoolean("MANTERCONECTADO",
                        cbManterConectado.isChecked());
                editor.commit();

            }
            abrirTela();


        }else {
            tilSenha.setError("Usuario ou senha invalidos");
        }
    }

    private void abrirTela(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}
