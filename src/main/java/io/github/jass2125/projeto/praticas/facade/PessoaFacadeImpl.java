/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.projeto.praticas.facade;

import io.github.jass2125.projeto.praticas.Pessoa;
import io.github.jass2125.projeto.praticas.dao.PessoaDao;

/**
 *
 * @author Anderson Souza
 */
public class PessoaFacadeImpl implements PessoaFacade {
    private PessoaDao dao;

    public PessoaFacadeImpl() {
        dao = new PessoaDao();
    }
    
    
    @Override
    public Pessoa buscarPorNomeESenha(String nome, String senha) {
        return dao.buscarPorNomeESenha(nome, senha);
    }

    @Override
    public void cadastrar(Pessoa pessoa) {
        dao.save(pessoa);
    }

}
