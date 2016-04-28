/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.projeto.praticas.entidades;

import java.io.Serializable;

/**
 *
 * @author Anderson Souza
 */
public class Game implements Serializable {

    private int id;
    private String nome;
    private String genero;

    public Game() {
    }

    public Game(String nome, String genero) {
        this.nome = nome;
        this.genero = genero;
    }

    public Game(int id, String nome, String genero) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
