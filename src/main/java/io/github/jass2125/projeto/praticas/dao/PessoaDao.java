/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.projeto.praticas.dao;

import io.github.jass2125.projeto.praticas.entidades.Pessoa;
import java.sql.SQLException;
import java.util.List;

/**
 * Interface do DAO de user
 *
 * @author Anderson Souza
 * @since 2015
 */
public interface PessoaDao {

    public void addPessoa(Pessoa pessoa) throws SQLException, ClassNotFoundException;

    public Pessoa buscar(String username, String email) throws SQLException, ClassNotFoundException;

    public List<Pessoa> listar() throws SQLException, ClassNotFoundException;

}
