package com.desafio.desafio.service;

import com.desafio.desafio.domain.User;
import com.desafio.desafio.domain.UserSelect;

import java.util.List;

public interface UserService {

    public List<User> getAll();

    public User getById( Long idUser );

    public void insert ( User user );

    public void update ( User user );

    public void delete( Long idUser );

    public User login ( User user );

    public List<UserSelect> getAllFinalizadores();
}
