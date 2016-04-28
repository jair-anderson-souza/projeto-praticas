/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.projeto.praticas.dao;

import io.github.jass2125.projeto.praticas.entidades.Game;
import io.github.jass2125.projeto.praticas.infraestrutura.db.DBUnitHelper;
import java.sql.SQLException;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author Anderson Souza
 */
public class GameDaoImplTest {

    private GameDaoImpl dao;
    private Game game;

    public GameDaoImplTest() {
    }

    @Before
    public void setUp() throws SQLException, ClassNotFoundException {
        //arquivos do banco
        new DBUnitHelper().cleanInsert("/tabelas/data.xml");

//        img = "imageqq".getBytes();
//        end = new Endereco(3L, "Rua Santa Terezinha", "Centro");
//        cpf = new CPF();
//        cpf.setValor("876.246.956-76");
        game = new Game(50, "DK", "aventura");
        dao = new GameDaoImpl();
//        dao.salvar(game);
    }

    @Test
    public void testSalvar() throws SQLException, ClassNotFoundException {
        dao.salvarDB(game);
        Game g = dao.buscar(game.getId());
        assertNotNull(g);
    }

    @Test
    public void testBuscar() throws SQLException, ClassNotFoundException {
        Game g = dao.buscar(5);
        assertNotNull(g);
        g = dao.buscar(10);
        assertNull(g);
    }
//

    @Test
    public void testListarGames() throws SQLException, ClassNotFoundException {
        List<Game> lista = dao.listarGames();
        int size = lista.size();
        assertEquals(size, 3);
        
    }
}
