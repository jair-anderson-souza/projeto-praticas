/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.projeto.praticas.dao;

import io.github.jass2125.projeto.praticas.entidades.Usuario;
import java.sql.SQLException;
import java.util.List;

public interface PessoaDao {

    public void addPessoa(Usuario pessoa) throws SQLException, ClassNotFoundException;

    public Usuario buscar(String username, String email) throws SQLException, ClassNotFoundException;

    public List<Usuario> listar() throws SQLException, ClassNotFoundException;

}
