/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.projeto.praticas;

import io.github.jass2125.projeto.praticas.facade.PessoaFacade;
import io.github.jass2125.projeto.praticas.facade.PessoaFacadeImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anderson Souza
 */
//@Named
//@SessionScoped
@WebServlet(urlPatterns = "/add")
public class LoginControlador extends HttpServlet {
    /* Injetar esse objeto */
    private Pessoa pessoa;
    private PessoaFacade facade;
    
    public LoginControlador() {
        pessoa = new Pessoa();
        facade = new PessoaFacadeImpl();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public String cadastrarPessoa(){
        facade.cadastrar(pessoa);
        //pagina de confirmação de cadastro
        return "";
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        pessoa = new Pessoa(req.getParameter("nome"), req.getParameter("email"), Integer.parseInt(req.getParameter("idade")));
        facade = new PessoaFacadeImpl();
        facade.cadastrar(pessoa);
        
        
    }
    
    
    public static void main(String[] args) {
        LoginControlador l = new LoginControlador();
        l.getPessoa().setNome("anderson");
        l.getPessoa().setSenha("123");
        l.cadastrarPessoa();
    }

}
