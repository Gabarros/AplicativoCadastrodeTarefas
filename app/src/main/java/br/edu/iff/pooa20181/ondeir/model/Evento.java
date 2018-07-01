package br.edu.iff.pooa20181.ondeir.model;

import java.io.Serializable;
import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Evento extends RealmObject implements Serializable {

    @PrimaryKey
    private int id;
    private String nome;
    private String duracao;
    private Date data;


    public Evento() {
    }


    public Evento(int id, String nome, Date data, String duracao) {
        this.setId(id);
        this.setNome(nome);
        this.setData(data);

    }

    public Evento(int id, String nome, String duracao, Date data) {
        this.setId(id);
        this.setNome(nome);
        this.setData(data);
        this.setDuracao(duracao);

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

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
