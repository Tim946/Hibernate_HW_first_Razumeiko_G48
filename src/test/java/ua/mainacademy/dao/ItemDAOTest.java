package ua.mainacademy.dao;

import org.junit.jupiter.api.Test;
import ua.mainacademy.model.Item;

import static org.junit.jupiter.api.Assertions.*;

class ItemDAOTest {

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
    }

    @Test
    void findById() {
        Item item = Item.builder()
                .initPrice(18999)
                .itemCode("phone")
                .name("Samsung")
                .price(16999)
                .build();
        ItemDAO itemDAO = new ItemDAO();
        Item savedItem = itemDAO.save(item);
        assertNotNull(savedItem.getId());

        Item foundItem = itemDAO.findById(savedItem.getId());
        assertNotNull(foundItem);
        System.out.println(foundItem);
    }


    @Test
    void update() {
        Item item = Item.builder()
                .initPrice(18999)
                .itemCode("phone")
                .name("Samsung")
                .price(16999)
                .build();
        ItemDAO itemDAO = new ItemDAO();
        Item savedItem = itemDAO.save(item);
        assertNotNull(savedItem.getId());

        savedItem.setName("Iphone");
        Item updatedItem = itemDAO.update(savedItem);
        Item foundItem = itemDAO.findById(updatedItem.getId());
        assertEquals("Iphone",foundItem.getName());
    }

    @Test
    void delete() {
        Item item = Item.builder()
                .initPrice(18999)
                .itemCode("phone")
                .name("Samsung")
                .price(16999)
                .build();
        ItemDAO itemDAO = new ItemDAO();
        Item savedItem = itemDAO.save(item);
        assertNotNull(savedItem.getId());

        itemDAO.delete(savedItem);
        Item foundItem = itemDAO.findById(savedItem.getId());
        assertNull(foundItem);
    }
}