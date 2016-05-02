/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.projeto.praticas.dao;

import io.github.jass2125.projeto.praticas.entidades.Game;
import io.github.jass2125.projeto.praticas.infraestrutura.db.DBUnitHelper;
import java.sql.SQLException;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

public class GameDaoImplTest {

    private GameDaoImpl dao;
    private Game game;

    public GameDaoImplTest() {
    }

    @Before
    public void setUp() throws SQLException, ClassNotFoundException {
        //arquivos do banco
        new DBUnitHelper().cleanInsert("/tabelas/data.xml");
        game = new Game(50L, "DK", "aventura");
        dao = new GameDaoImpl();
}

    @Test
    public void testSalvar() throws SQLException, ClassNotFoundException {
        dao.salvarDB(game);
        Game g = dao.buscar(game.getId());
        assertNotNull(g);
    }

    @Test
    public void testBuscar() throws SQLException, ClassNotFoundException {
        Game g = dao.buscar(5L);
        assertNotNull(g);
        g = dao.buscar(10L);
        assertNull(g);
    }
    
    @Test
    public void testDelete() throws SQLException, ClassNotFoundException {
        dao.delete(5L);
        Game g = dao.buscar(5L);
        assertNull(g);
    }
}
