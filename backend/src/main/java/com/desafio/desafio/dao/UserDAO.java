package com.desafio.desafio.dao;

import com.desafio.desafio.domain.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAll();

    public User getById( Long idUser );

    public void insert ( User user );

    public void update ( User user );

    public void delete( Long idUser );

    public User login ( String username, String password );

    public List<User> getAllFinalizadores();
}
