package com.example.phoneBook.service;

import com.example.phoneBook.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
class UserStoreServiceTest {

    @Test
    void getAllByUserId() {
    }

    @Test
    void create() {
        UserStoreService userStoreService = new UserStoreService();
        userStoreService.create(new User());
        int after = userStoreService.size();
        assertEquals(1, after);
    }

    @Test
    void getById() {
        UserStoreService userStoreService = new UserStoreService();
        User user = new User(1, "Behruz", "Mansurov");
        userStoreService.create(user);
        User n_user = userStoreService.getById(1);
        assertEquals(1, n_user.getUserId());
    }

    @Test
    void removeById() {
        UserStoreService userStoreService = new UserStoreService();
        User user = new User(1, "Behruz", "Mansurov");
        userStoreService.create(user);
        User n_user = userStoreService.removeById(1);
        assertEquals(0, userStoreService.size());
        assertEquals(1, n_user.getUserId());
    }

    @Test
    void updateById() {
        UserStoreService userStoreService = new UserStoreService();
        User user = new User(1, "Behruz", "Mansurov");
        userStoreService.create(user);
        userStoreService.updateById(1, new User("Foo", "Bar"));
        User n_user = userStoreService.getById(1);
        assertEquals("Foo", n_user.getUsername());
        assertEquals("Bar", n_user.getSurname());
    }

    @Test
    void getByNameOrSubName() {
        UserStoreService userStoreService = new UserStoreService();
        User user_1 = new User(1, "asdasdvasdfsBehruzadsfdasfdsa", "Mansurov");
        User user_2 = new User(2, "adsfasdfdasfadsBehruz", "Mansurov");
        User user_3 = new User(3, "Behruzadfadsfadsfdsa", "Mansurov");
        User user_4 = new User(4, "adfadsfadsfdsa", "Mansurov");
        userStoreService.create(user_1);
        userStoreService.create(user_2);
        userStoreService.create(user_3);
        userStoreService.create(user_4);
        List<User> users = userStoreService.getByNameOrSubName("Behruz");
        assertEquals(3, users.size());
    }
}