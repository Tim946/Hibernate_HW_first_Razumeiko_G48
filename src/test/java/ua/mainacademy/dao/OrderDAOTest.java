package ua.mainacademy.dao;

import org.junit.jupiter.api.Test;
import ua.mainacademy.model.Order;
import ua.mainacademy.model.User;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OrderDAOTest {

    @Test
    void save() {
        User user = User.builder()
                .login("Tim")
                .password("123")
                .firstName("Timur")
                .lastName("Razumeiko")
                .build();
        User savedUser = new UserDAO().save(user);
        assertNotNull(savedUser.getId());
        Order order = Order.builder()
                .creationTime(213124124L)
                .status(Order.Status.OPEN)
                .user(user)
                .build();
        Order savedOrder = new OrderDAO().save(order);
        assertNotNull(savedOrder.getId());
    }


    @Test
    void findById() {
        User user = User.builder()
                .login("Tim")
                .password("123")
                .firstName("Timur")
                .lastName("Razumeiko")
                .build();
        User savedUser = new UserDAO().save(user);
        assertNotNull(savedUser.getId());
        Order order = Order.builder()
                .creationTime(213124124L)
                .status(Order.Status.OPEN)
                .user(user)
                .build();
        OrderDAO orderDAO= new OrderDAO();
        Order savedOrder = orderDAO.save(order);
        assertNotNull(savedOrder.getId());

        Order foundOrder = orderDAO.findById(savedOrder.getId());
        assertNotNull(foundOrder);
        System.out.println(foundOrder);
    }

    @Test
    void update() {
        User user = User.builder()
                .login("Tim")
                .password("123")
                .firstName("Timur")
                .lastName("Razumeiko")
                .build();
        User savedUser = new UserDAO().save(user);
        assertNotNull(savedUser.getId());
        Order order = Order.builder()
                .creationTime(213124124L)
                .status(Order.Status.OPEN)
                .user(user)
                .build();
        OrderDAO orderDAO= new OrderDAO();
        Order savedOrder = orderDAO.save(order);
        assertNotNull(savedOrder.getId());

        savedOrder.setStatus(Order.Status.CLOSED);
        Order updatedOrder = orderDAO.update(savedOrder);
        Order foundOrder = orderDAO.findById(updatedOrder.getId());
        assertEquals(Order.Status.CLOSED,foundOrder.getStatus());
    }

    @Test
    void delete() {
        User user = User.builder()
                .login("Tim")
                .password("123")
                .firstName("Timur")
                .lastName("Razumeiko")
                .build();
        User savedUser = new UserDAO().save(user);
        assertNotNull(savedUser.getId());
        Order order = Order.builder()
                .creationTime(213124124L)
                .status(Order.Status.OPEN)
                .user(user)
                .build();
        OrderDAO orderDAO= new OrderDAO();
        Order savedOrder = orderDAO.save(order);
        assertNotNull(savedOrder.getId());

        orderDAO.delete(savedOrder);
        Order foundOrder = orderDAO.findById(savedOrder.getId());
        assertNull(foundOrder);
    }
}