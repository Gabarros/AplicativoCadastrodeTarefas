package br.edu.iff.pooa20181.ondeir.model;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Local extends RealmObject implements Serializable {

    @PrimaryKey
    private int id;

    private String nome;
    private Double latitude;
    private Double longitude;
    private String localevento;

    public Local(){

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


    public String getLocalevento() {
        return localevento;
    }

    public void setLocalevento(String localevento) {
        this.localevento = localevento;
    }

    public Double getLatitute(){
        return latitude;
    }

    public Double getLongitude(){
        return longitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
