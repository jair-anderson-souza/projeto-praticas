/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.projeto.praticas.controlador;

import io.github.jass2125.projeto.praticas.entidades.Usuario;
import io.github.jass2125.projeto.praticas.facade.UsuarioFacadeImpl;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class UsuarioControlador {

    private List<Usuario> pessoas;
    private Usuario pessoa;

    @Inject
    private LoginControlador login;
    @Inject
    private UsuarioFacadeImpl facade;

    public UsuarioControlador() {
        this.pessoa = new Usuario();
        this.pessoas = new ArrayList<>();
    }

    public Usuario getPessoa() {
        return pessoa;
    }

    public List<Usuario> getPessoas() {
        return pessoas;
    }

    public String cadastrar() {
//        System.out.println(pessoa.getEmail());
        facade.cadastrar(pessoa);
        pessoa.setEmail(null);
        pessoa.setSenha(null);
        return "home.xhtml";
    }

    public List<Usuario> listar() {
        return facade.listar();
//        System.out.println(pessoa);
//        return "lista.xhtml";
    }

}
