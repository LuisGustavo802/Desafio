package com.desafio.desafio.dao;

import com.desafio.desafio.domain.FeedbackProcess;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FeedbackProcessDAOImpl implements FeedbackProcessDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<FeedbackProcess> getByProcess(Long idProcess ) {
        return em.createQuery( "select pf from process_feedback pf where id = :idProcess", FeedbackProcess.class )
                .setParameter("idProcess", idProcess)
                .getResultList();
    }

    @Override
    public List<FeedbackProcess> getByIdUser(Long idUser ) {
        return em.createQuery( "select pf from process_feedback pf where iduser = :idUser", FeedbackProcess.class )
                .setParameter("idUser", idUser)
                .getResultList();
    }

    @Override
    public FeedbackProcess getByIdUserAndIdProcess(Long idUser, Long idProcess ) {
        return em.createQuery( "select pf from process_feedback pf where iduser = :idUser and idprocess = :idProcess", FeedbackProcess.class )
                .setParameter("idUser", idUser)
                .setParameter("idProcess", idProcess)
                .getSingleResult();
    }

    @Override
    public void insert( FeedbackProcess feedbackProcess) { em.persist(feedbackProcess);  }

    @Override
    public void update( FeedbackProcess feedbackProcess) { em.merge(feedbackProcess); }
}
