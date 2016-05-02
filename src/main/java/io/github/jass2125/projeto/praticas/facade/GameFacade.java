/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.projeto.praticas.facade;

import io.github.jass2125.projeto.praticas.entidades.Game;
import java.util.List;

public interface GameFacade {

    public List<Game> listarGames();

    public boolean salvar(Game game);

    public boolean deletar(int id);

}
