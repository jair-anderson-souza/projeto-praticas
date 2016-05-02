/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.projeto.praticas.facade;

import io.github.jass2125.projeto.praticas.dao.GameDao;
import io.github.jass2125.projeto.praticas.dao.GameDaoImpl;
import io.github.jass2125.projeto.praticas.entidades.Game;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class GameFacadeImpl implements Serializable {

    private GameDao dao;

    public GameFacadeImpl() {
        this.dao = new GameDaoImpl();
    }

    public List<Game> listarGames() {
        try {
            return dao.listarGames();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean salvar(Game game) {
        try {
            dao.salvar(game);
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletar(Long id) {
        try {
            dao.delete(id);
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

}
