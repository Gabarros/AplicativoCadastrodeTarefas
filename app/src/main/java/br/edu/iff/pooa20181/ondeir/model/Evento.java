package br.edu.iff.pooa20181.ondeir.model;

import java.io.Serializable;
import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Evento extends RealmObject implements Serializable {

    @PrimaryKey
    private int id;
    private String nome;
    private Date  data;
    private String categoria;


    public Evento() {
    }



    public Evento(int id, String nome, String categoria, Date data) {
        this.setId(id);
        this.setNome(nome);
        this.setData(data);
        this.setCategoria(categoria);


    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
