package com.example.julioc98.todoapp.model;

/**
 * Created by julioc98 on 08/11/16.
 */

public class ToDo {
    private int id;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String descricao;

}
