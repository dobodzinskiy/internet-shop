package com.shop.dao;

import com.shop.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    protected EntityManager entityManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getUsers() {
        TypedQuery<User> getList = entityManager.createNamedQuery("getList", User.class);
        return getList.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(int id) {
        Query getUser = entityManager.createNamedQuery("getUser");
        return (User) getUser.setParameter("id", id).getSingleResult();
    }

    @Override
    public void deleteUser(int id) {
        User user = this.getUser(id);
        if(user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User findByUserLogin(String login) {
        TypedQuery<User> getUserByLogin = entityManager.createNamedQuery("getUserByLogin", User.class);
        User user;
        try {
            user = getUserByLogin.setParameter("login", login).getSingleResult();
        }
        catch (NoResultException ex) {
            LOGGER.info("login {} is not found", login, ex);
            return null;
        }
        return user;
    }

    @Override
    public List<User> getStaff() {
        TypedQuery<User> getStaff = entityManager.createNamedQuery("getStaff", User.class);
        return getStaff.getResultList();
    }
}
