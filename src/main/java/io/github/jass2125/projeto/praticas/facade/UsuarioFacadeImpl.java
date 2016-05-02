/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.projeto.praticas.facade;

import io.github.jass2125.projeto.praticas.dao.PessoaDao;
import io.github.jass2125.projeto.praticas.dao.PessoaDaoImpl;
import io.github.jass2125.projeto.praticas.entidades.Usuario;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioFacadeImpl implements Serializable {

    private PessoaDao dao;

    public UsuarioFacadeImpl() {
        dao = new PessoaDaoImpl();
    }

    public Usuario buscarPorNomeESenha(String email, String senha) {
        try {
            return dao.buscar(email, senha);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void cadastrar(Usuario pessoa) {
        try {
            dao.addPessoa(pessoa);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioFacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioFacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Usuario> listar() {
        try {
            return dao.listar();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
