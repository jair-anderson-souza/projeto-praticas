/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.projeto.praticas.dao;

import io.github.jass2125.projeto.praticas.entidades.Game;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Anderson Souza
 */
public interface GameDao {

    public List<Game> listarGames() throws SQLException, ClassNotFoundException;

    public void salvar(Game game) throws SQLException, ClassNotFoundException;

    public void delete(int id) throws SQLException, ClassNotFoundException;
}
