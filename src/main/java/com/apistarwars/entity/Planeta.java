package com.apistarwars.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;

@Document(collection = "planeta")
public class Planeta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String nome;
    private String clima;
    private String terreno;
    private Integer quantidadeFilmes;


    public Planeta(){
    }

    public Planeta(String id, String nome, String clima, String terreno, Integer quantidadeFilmes){
        super();
        this.id = id;
        this.nome = nome;
        this.clima = clima;
        this.terreno = terreno;
        this.quantidadeFilmes = quantidadeFilmes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    public Integer getQuantidadeFilmes() {
        return quantidadeFilmes;
    }

    public void setQuantidadeFilmes(Integer quantidadeFilmes) {
        this.quantidadeFilmes = quantidadeFilmes;
    }

}
