/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.projeto.praticas.dao;

import edu.ifpb.pp.infraestrutura.db.DBUnitHelper;
import io.github.jass2125.projeto.praticas.entidades.Game;
import java.sql.SQLException;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Anderson Souza
 */
public class GameDaoImplIT {

    private GameDaoImpl dao;
    private Game game;

    public GameDaoImplIT() {
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

//    @Test
//    public void testRemover() {
//        Pessoa p = new Pessoa(1L, null, img, cpf, end);
//        boolean v = repo.remover(pessoa);
//        assertTrue(v);
//    }
//
//    @Test
//    public void remover() {
//        boolean result = repo.remover(1L);
//        assertTrue(result);
//    }
//
//   @Test
//    public void localizar() {
//        Pessoa p =repo.localizar(1L);
//        assertNotNull(p);
//    }
}
