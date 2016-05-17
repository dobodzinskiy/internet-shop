package com.shop.dao;

import com.shop.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository("orderDao")
@Transactional
public class OrderDaoImpl implements OrderDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Order> getOrdersList() {
        TypedQuery<Order> getOrders = entityManager.createNamedQuery("getOrdersList", Order.class);
        return getOrders.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Order getOrder(int id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getOrders(String userLogin) {
        TypedQuery<Order> getOrders = entityManager.createNamedQuery("getOrdersByLogin", Order.class);
        return getOrders.setParameter("username", userLogin).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getOrders(int userId) {
        TypedQuery<Order> getOrders = entityManager.createNamedQuery("getOrdersById", Order.class);
        return getOrders.setParameter("id", userId).getResultList();
    }

    @Override
    public void confirmOrder(Order order) {
        entityManager.persist(order);
    }

    @Override
    public void updateOrder(Order order) {
        entityManager.merge(order);
    }
}
