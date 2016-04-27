/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.projeto.praticas.dao;

import io.github.jass2125.projeto.praticas.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Anderson Souza
 */
public class PessoaDao {
    @PersistenceContext(unitName = "pp")
    private EntityManager em;
    
    public Pessoa buscarPorNomeESenha(String nome, String senha){
        Query query = em.createQuery("SELECT P FROM Pessoa P WHERE P.nome = :nome AND p.senha = :senha");
        query.setParameter("nome", nome);
        query.setParameter("senha", senha);
        List<Pessoa> lista = query.getResultList();
        return lista.get(0);
    }

    public void save(Pessoa pessoa) {
        em.persist(pessoa);
    }

}
