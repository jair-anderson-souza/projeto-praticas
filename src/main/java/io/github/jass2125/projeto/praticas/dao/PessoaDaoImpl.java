/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.projeto.praticas.dao;

import io.github.jass2125.projeto.praticas.entidades.Usuario;
import io.github.jass2125.projeto.praticas.factory.ConnectionFactory;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDaoImpl implements PessoaDao, Serializable {

    private final ConnectionFactory connectionFactory;

    public PessoaDaoImpl() {
        connectionFactory = new ConnectionFactory();
    }

    @Override
    public void addPessoa(Usuario pessoa) throws SQLException, ClassNotFoundException {
        String sql = "insert into pessoa(email, senha) values(?, ?);";
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, pessoa.getEmail());
        ps.setString(2, pessoa.getSenha());
        ps.execute();
        ps.close();
        con.close();

    }

    @Override
    public Usuario buscar(String email, String senha) throws SQLException, ClassNotFoundException {
        String sql = "select * from pessoa where binary email = ? or binary senha = ?;";
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, email);
        ps.setString(2, senha);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Long idPessoa = rs.getLong("id");
            return new Usuario(idPessoa, email, senha);
        }
        rs.close();
        ps.clearParameters();
        ps.close();
        return null;
    }

    @Override
    public List<Usuario> listar() throws SQLException, ClassNotFoundException {
        String sql = "select * from pessoa;";
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        List<Usuario> list = new ArrayList<>();
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Long id = rs.getLong("id");
            String email = rs.getString("email");
            String senha = rs.getString("senha");
            Usuario pessoa = new Usuario(id, email, senha);
            list.add(pessoa);
        }
        rs.close();
        ps.clearParameters();
        ps.close();
        con.close();
        return list;
    }

}
