/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.projeto.praticas.controlador;

import io.github.jass2125.projeto.praticas.entidades.Usuario;
import io.github.jass2125.projeto.praticas.facade.UsuarioFacadeImpl;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class LoginControlador implements Serializable {
    @Inject
    private UsuarioFacadeImpl facade;
    
    private Usuario usuario;

    public LoginControlador() {
        this.usuario = new Usuario();
    }
    

    public Usuario getUsuario() {
        return usuario;
    }

    public String login() {
        Usuario user = facade.buscarPorNomeESenha(usuario.getEmail(), usuario.getSenha());
        if(user != null){
            
            return "home?faces-redirect=true";
        }else {
            return "index?faces-redirect=true";
        }
    }

}
