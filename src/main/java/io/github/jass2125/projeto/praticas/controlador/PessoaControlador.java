/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.projeto.praticas.controlador;

import io.github.jass2125.projeto.praticas.entidades.Pessoa;
import io.github.jass2125.projeto.praticas.facade.PessoaFacadeImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

/**
 *
 * @author Anderson Souza
 */
@ManagedBean
public class PessoaControlador {

    private List<Pessoa> pessoas;
    private Pessoa pessoa;
    @Inject
    private PessoaFacadeImpl facade;

    public PessoaControlador() {
        this.pessoa = new Pessoa();
        this.pessoas = new ArrayList<>();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public String cadastrar() {
//        System.out.println(pessoa.getEmail());
        facade.cadastrar(pessoa);
        pessoa.setEmail(null); 
        pessoa.setSenha(null);
        return "index.xhtml";
    }

    public List<Pessoa> listar() {
        return  facade.listar();
//        System.out.println(pessoa);
//        return "lista.xhtml";
    }

}
