/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.projeto.praticas.dao;

import io.github.jass2125.projeto.praticas.entidades.Game;
import io.github.jass2125.projeto.praticas.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDaoImpl implements GameDao {

    private final ConnectionFactory connectionFactory;

    public GameDaoImpl() {
        connectionFactory = new ConnectionFactory();
    }

    @Override
    public List<Game> listarGames() throws SQLException, ClassNotFoundException {
        String sql = "select * from game;";
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        List<Game> list = new ArrayList<>();
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Long id = rs.getLong("id");
            String nome = rs.getString("nome");
            String genero = rs.getString("genero");
            Game game = new Game(id, nome, genero);
            list.add(game);
        }
        rs.close();
        ps.clearParameters();
        ps.close();
        con.close();
        return list;

    }

    public Game buscar(Long id) throws SQLException, ClassNotFoundException {
        String sql = "select * from game where id = ?;";
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String nome = rs.getString("nome");
            String genero = rs.getString("genero");
            return new Game(id, nome, genero);
        }
        rs.close();
        ps.clearParameters();
        ps.close();
        con.close();
        return null;

    }

    @Override
    public void salvar(Game game) throws SQLException, ClassNotFoundException {
        String sql = "insert into game(nome, genero) values(?, ?);";
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, game.getNome());
        ps.setString(2, game.getGenero());
        ps.execute();
        ps.close();
        con.close();
    }

    public void salvarDB(Game game) throws SQLException, ClassNotFoundException {
        String sql = "insert into game values(?, ?, ?);";
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, game.getId());
        ps.setString(2, game.getNome());
        ps.setString(3, game.getGenero());
        ps.execute();
        ps.close();
        con.close();
    }

    @Override
    public void delete(Long id) throws SQLException, ClassNotFoundException {
        String sql = "delete from game where id = ?;";
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        ps.execute();
        ps.close();
        con.close();
    }
}
