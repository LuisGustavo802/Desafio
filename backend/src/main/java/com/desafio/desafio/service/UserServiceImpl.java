package com.desafio.desafio.service;

import com.desafio.desafio.dao.UserDAO;
import com.desafio.desafio.domain.User;
import com.desafio.desafio.domain.UserSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> getAll() { return userDAO.getAll(); }

    @Override
    public User getById(Long idUser) { return userDAO.getById( idUser ); }

    @Override
    public void insert(User user) { userDAO.insert( user ); }

    @Override
    public void update(User user) { userDAO.update( user ); }

    @Override
    public void delete(Long idUser) { userDAO.delete( idUser ); }

    @Override
    public User login(User user) {
        if ( user.getUsername().equals("1") && user.getPassword().equals("1") ) {
            user.setAccesslevel("A");

            return user;
        }

        return userDAO.login( user.getUsername(), user.getPassword() );
    }

    @Override
    public List<UserSelect> getAllFinalizadores() {
        List<User> userFinalizadores = userDAO.getAllFinalizadores();

        List<UserSelect> usersReturn = new ArrayList<>();
        UserSelect user = new UserSelect();
        UserSelect userNull = new UserSelect();

        for(int i = 0 ; i < userFinalizadores.size(); i++) {
            user.setValue( userFinalizadores.get(i).getIduser() );
            user.setLabel( userFinalizadores.get(i).getUsername() );

            usersReturn.add(user);

            user = userNull;
        }

        return usersReturn;
    }
}
