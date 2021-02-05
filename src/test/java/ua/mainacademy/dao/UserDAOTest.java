package ua.mainacademy.dao;

import org.junit.jupiter.api.Test;
import ua.mainacademy.model.User;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

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
    }

    @Test
    void findById() {
        User user = User.builder()
                .login("Fast.Tim")
                .password("12345")
                .firstName("Tim")
                .lastName("Razumeiko")
                .build();
        UserDAO userDAO = new UserDAO();
        User savedUser = userDAO.save(user);
        assertNotNull(savedUser.getId());

        User foundUser = userDAO.findById(savedUser.getId());
        assertNotNull(foundUser);
        System.out.println(foundUser);
    }


    @Test
    void update() {
        User user = User.builder()
                .login("Fast.Tim")
                .password("12345")
                .firstName("Tim")
                .lastName("Razumeiko")
                .build();
        UserDAO userDAO = new UserDAO();
        User savedUser = userDAO.save(user);
        assertNotNull(savedUser.getId());

        savedUser.setFirstName("Timofey");
        User updatedUser = userDAO.update(savedUser);
        User foundUser = userDAO.findById(updatedUser.getId());
        assertEquals("Timofey",foundUser.getFirstName());
    }

    @Test
    void delete() {
        User user = User.builder()
                .login("Fast.Tim")
                .password("12345")
                .firstName("Tim")
                .lastName("Razumeiko")
                .build();
        UserDAO userDAO = new UserDAO();
        User savedUser = userDAO.save(user);
        assertNotNull(savedUser.getId());

        userDAO.delete(savedUser);
        User foundUser = userDAO.findById(savedUser.getId());
        assertNull(foundUser);
    }
}