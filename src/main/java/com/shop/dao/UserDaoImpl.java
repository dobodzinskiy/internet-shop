package com.shop.dao;

import com.shop.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getUsers() {
        TypedQuery<User> getList = entityManager.createNamedQuery("User.getList", User.class);
        return getList.getResultList();
    }

    @Override
    public User getUser(int id) {
        Query getUser = entityManager.createNamedQuery("User.getUser");
        return (User) getUser.setParameter("id", id).getSingleResult();
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User findByUserLogin(String login) {
        TypedQuery<User> getUserByLogin = entityManager.createNamedQuery("User.getUserByLogin", User.class);
        User user;

        try {
            user = getUserByLogin.setParameter("login", login).getSingleResult();
        } catch (NoResultException ex) {
            LOGGER.warn("Login {} is not found", login, ex);
            return null;
        }

        return user;
    }

    @Override
    public List<User> getStaff() {
        TypedQuery<User> getStaff = entityManager.createNamedQuery("User.getStaff", User.class);
        return getStaff.getResultList();
    }

}
