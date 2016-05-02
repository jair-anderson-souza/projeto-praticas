/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.projeto.praticas.facade;

import io.github.jass2125.projeto.praticas.entidades.Usuario;

public interface UsuarioFacade {

    public Usuario buscarPorNomeESenha(String nome, String senha);

    public void cadastrar(Usuario usuario);

}
