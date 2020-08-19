package com.desafio.desafio.dao;

import com.desafio.desafio.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAll() { return em.createQuery( "select u from users u", User.class ).getResultList(); }

    @Override
    public User getById( Long idUser ) { return em.find( User.class, idUser ); }

    @Override
    public void insert ( User user ) { em.persist( user ); }

    @Override
    public void update ( User user ) { em.merge( user ); }

    @Override
    public void delete( Long idUser ) { em.remove( em.getReference( User.class, idUser ) ); }

    @Override
    public User login(String username, String password) {

        Query query = em.createQuery("select count(1) from users u where username = :username and password = :password")
                        .setParameter("username", username)
                        .setParameter("password", password);

        if ( query.getSingleResult().toString().equals("1") ) {
            return em.createQuery( "select u from users u where username = :username and password = :password", User.class )
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        }

        return new User();
    }

    @Override
    public List<User> getAllFinalizadores() {
        return em.createQuery( "select u from users u where accesslevel = :acesslevel", User.class )
            .setParameter("acesslevel", "F")
            .getResultList(); }
}
