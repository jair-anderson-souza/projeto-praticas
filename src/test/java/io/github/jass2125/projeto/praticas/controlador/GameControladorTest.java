/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.projeto.praticas.controlador;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anderson Souza
 */
public class GameControladorTest {
    private GameControlador control;

    public GameControladorTest() {
    }
    
    @Before
    public void init(){
        control = new GameControlador();
    }
    @Test
    public void testGetGame() {

    }

    @Test
    public void testCadastrar() {
        control.cadastrar();
        assertNotNull(control.getGame());
        assertNotNull(control.getGame().getGenero());
        assertNotNull(control.getGame().getNome());

    }

    @Test
    public void testListar() {

    }

}
