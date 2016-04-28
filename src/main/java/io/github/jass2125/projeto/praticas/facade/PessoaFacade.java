/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.projeto.praticas.facade;

import io.github.jass2125.projeto.praticas.entidades.Pessoa;


/**
 *
 * @author Anderson Souza
 */
public interface PessoaFacade {

    public Pessoa buscarPorNomeESenha(String nome, String senha);
    public void cadastrar(Pessoa pessoa);
}
