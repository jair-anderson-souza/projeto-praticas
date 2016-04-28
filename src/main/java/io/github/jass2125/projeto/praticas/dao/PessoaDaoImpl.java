/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.projeto.praticas.dao;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import io.github.jass2125.projeto.praticas.entidades.Pessoa;
import io.github.jass2125.sistema.alocacao.core.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa os DAO's de usuario
 *
 * @author Anderson Souza
 * @since 2015
 */
public class PessoaDaoImpl implements PessoaDao {

    private final ConnectionFactory connectionFactory;

    public PessoaDaoImpl() {
        connectionFactory = new ConnectionFactory();
    }

    @Override
    public void addPessoa(Pessoa pessoa) throws SQLException, ClassNotFoundException {
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
    public Pessoa buscar(String email, String senha) throws SQLException, ClassNotFoundException {
        String sql = "select * from pessoa where binary email = ? or binary senha = ?;";
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, email);
        ps.setString(2, senha);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Long idPessoa = rs.getLong("id");
            return new Pessoa(idPessoa, email, senha);
        }
        rs.close();
        ps.clearParameters();
        ps.close();
        return null;
    }

    @Override
    public List<Pessoa> listar() throws SQLException, ClassNotFoundException {
        String sql = "select * from pessoa;";
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        List<Pessoa> list = new ArrayList<>();
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Long id = rs.getLong("id");
            String email = rs.getString("email");
            String senha = rs.getString("senha");
            Pessoa pessoa = new Pessoa(id, email, senha);
            list.add(pessoa);
        }
        rs.close();
        ps.clearParameters();
        ps.close();
        con.close();
        return list;
    }

}
