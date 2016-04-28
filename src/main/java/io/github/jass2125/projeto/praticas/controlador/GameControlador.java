/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.projeto.praticas.controlador;

import io.github.jass2125.projeto.praticas.entidades.Game;
import io.github.jass2125.projeto.praticas.facade.GameFacadeImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

/**
 *
 * @author Anderson Souza
 */
@ManagedBean
public class GameControlador {

    private List<Game> games;
    private Game game;
    @Inject
    private GameFacadeImpl facade;

    public GameControlador() {
        this.games = new ArrayList<>();
        this.game = new Game();

    }

    public Game getGame() {
        return game;
    }

    public String cadastrar() {
        facade.salvar(game);
        game.setGenero(null);
        game.setNome(null);
        return "index.xhtml";
    }

    public List<Game> listar() {
        return facade.listarGames();
    }

}
