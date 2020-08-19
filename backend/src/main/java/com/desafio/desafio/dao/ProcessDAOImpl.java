package com.desafio.desafio.dao;

import com.desafio.desafio.domain.Process;
import com.desafio.desafio.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProcessDAOImpl implements ProcessDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Process> getAll() { return em.createQuery( "select p from process p", Process.class ).getResultList(); }

    @Override
    public Process getById( Long idProcess ) { return em.find( Process.class, idProcess ); }

    @Override
    public Long insert(Process process) {
        em.persist( process );
        em.flush();

        return process.getIdprocess();
    }
}