/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.projeto.praticas.facade;

import io.github.jass2125.projeto.praticas.dao.PessoaDao;
import io.github.jass2125.projeto.praticas.dao.PessoaDaoImpl;
import io.github.jass2125.projeto.praticas.entidades.Pessoa;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anderson Souza
 */
public class PessoaFacadeImpl implements PessoaFacade {
//    @Inject

    private PessoaDao dao;

    public PessoaFacadeImpl() {
        dao = new PessoaDaoImpl();
    }

    @Override
    public Pessoa buscarPorNomeESenha(String email, String senha) {
        try {
            return dao.buscar(email, senha);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void cadastrar(Pessoa pessoa) {
        try {
            dao.addPessoa(pessoa);
        } catch (SQLException ex) {
            Logger.getLogger(PessoaFacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PessoaFacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Pessoa> listar() {
        try {
            return dao.listar();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("NULL");
            return null;
        }
    }

}
