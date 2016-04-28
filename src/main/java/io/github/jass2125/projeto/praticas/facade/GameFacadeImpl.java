/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.projeto.praticas.facade;

import io.github.jass2125.projeto.praticas.dao.GameDao;
import io.github.jass2125.projeto.praticas.dao.GameDaoImpl;
import io.github.jass2125.projeto.praticas.entidades.Game;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anderson Souza
 */
public class GameFacadeImpl implements GameFacade {

    private GameDao dao;

    public GameFacadeImpl() {
        this.dao = new GameDaoImpl();
    }

    @Override
    public List<Game> listarGames() {
        try {
            return dao.listarGames();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void salvar(Game game) {
        try {
            dao.salvar(game);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        try {
            dao.delete(id);
        } catch (SQLException ex) {
            Logger.getLogger(GameFacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GameFacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
