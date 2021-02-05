package ua.mainacademy.dao;

import org.junit.jupiter.api.Test;
import ua.mainacademy.model.Item;
import ua.mainacademy.model.Order;
import ua.mainacademy.model.OrderItem;
import ua.mainacademy.model.User;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemDAOTest {

    @Test
    void save() {
        Item item = Item.builder()
                .initPrice(18999)
                .itemCode("phone")
                .name("Samsung")
                .price(16999)
                .build();
        Item savedItem = new ItemDAO().save(item);
        assertNotNull(savedItem.getId());
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
        OrderItem orderItem = OrderItem.builder()
                .item(item)
                .order(order)
                .amount(12)
                .build();
        OrderItem saveOrderItem = new OrderItemDAO().save(orderItem);
        assertNotNull(saveOrderItem.getId());
    }


    @Test
    void findById() {
        Item item = Item.builder()
                .initPrice(18999)
                .itemCode("phone")
                .name("Samsung")
                .price(16999)
                .build();
        Item savedItem = new ItemDAO().save(item);
        assertNotNull(savedItem.getId());
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
        OrderItem orderItem = OrderItem.builder()
                .item(item)
                .order(order)
                .amount(12)
                .build();
        OrderItemDAO orderItemDAO = new OrderItemDAO();
        OrderItem saveOrderItem = orderItemDAO.save(orderItem);
        assertNotNull(saveOrderItem.getId());

        OrderItem foundOrderItem = orderItemDAO.findById(saveOrderItem.getId());
        assertNotNull(foundOrderItem);
        System.out.println(foundOrderItem);
    }

    @Test
    void update() {
        Item item = Item.builder()
                .initPrice(18999)
                .itemCode("phone")
                .name("Samsung")
                .price(16999)
                .build();
        Item savedItem = new ItemDAO().save(item);
        assertNotNull(savedItem.getId());
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
        OrderItem orderItem = OrderItem.builder()
                .item(item)
                .order(order)
                .amount(12)
                .build();
        OrderItemDAO orderItemDAO = new OrderItemDAO();
        OrderItem saveOrderItem = orderItemDAO.save(orderItem);
        assertNotNull(saveOrderItem.getId());

        saveOrderItem.setAmount(44);
        OrderItem updateOrderItem = orderItemDAO.update(saveOrderItem);
        OrderItem foundOrderItem = orderItemDAO.findById(updateOrderItem.getId());
        assertEquals(44,foundOrderItem.getAmount());
    }

    @Test
    void delete() {
        Item item = Item.builder()
                .initPrice(18999)
                .itemCode("phone")
                .name("Samsung")
                .price(16999)
                .build();
        Item savedItem = new ItemDAO().save(item);
        assertNotNull(savedItem.getId());
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
        OrderItem orderItem = OrderItem.builder()
                .item(item)
                .order(order)
                .amount(12)
                .build();
        OrderItemDAO orderItemDAO = new OrderItemDAO();
        OrderItem saveOrderItem = orderItemDAO.save(orderItem);
        assertNotNull(saveOrderItem.getId());

        orderItemDAO.delete(saveOrderItem);
        OrderItem foundOrderItem = orderItemDAO.findById(saveOrderItem.getId());
        assertNull(foundOrderItem);
    }
}