package com.shop.dao;

import com.shop.entity.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Order> getOrdersList() {
        TypedQuery<Order> getOrders = entityManager.createNamedQuery("Order.getOrdersList", Order.class);
        return getOrders.getResultList();
    }

    @Override
    public Order getOrder(int id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public List<Order> getOrders(String userLogin) {
        TypedQuery<Order> getOrders = entityManager.createNamedQuery("Order.getOrdersByLogin", Order.class);
        return getOrders.setParameter("username", userLogin).getResultList();
    }

    @Override
    public List<Order> getOrders(int userId) {
        TypedQuery<Order> getOrders = entityManager.createNamedQuery("Order.getOrdersById", Order.class);
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
