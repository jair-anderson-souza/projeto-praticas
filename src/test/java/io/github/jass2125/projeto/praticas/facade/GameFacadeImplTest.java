/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.projeto.praticas.facade;

import io.github.jass2125.projeto.praticas.entidades.Game;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 *
 * @author Anderson Souza
 */
public class GameFacadeImplTest {
//    @Mock

    private GameFacade facade;
    private Game game;

    public GameFacadeImplTest() {
    }

    @Before
    public void setUp() {
        facade = Mockito.mock(GameFacade.class);
        game = new Game();
    }

    @Test
    public void testListarGames() {
        when(facade.listarGames()).thenReturn(null);
        List<Game> games = facade.listarGames();
        assertNull(games);

    }

    @Test
    public void testSalvar() {
        when(facade.salvar(null)).thenReturn(false);
        boolean v = facade.salvar(null);
        assertFalse(v);
    }

    @Test
    public void testDeletar() {
        when(facade.deletar(20)).thenReturn(true);
        boolean v = facade.deletar(20);
        assertTrue(v);
    }

}
