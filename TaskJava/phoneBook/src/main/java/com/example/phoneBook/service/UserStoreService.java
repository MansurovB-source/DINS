package com.example.phoneBook.service;

import com.example.phoneBook.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */

@Service
public class UserStoreService implements StoreService<User> {
    private final Map<Long, User> userMap = new HashMap<>();

    public int size() {
        return userMap.size();
    }

    /**
     * returns a list of all users
     *
     * @return list of user
     */
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        for (Map.Entry<Long, User> entry : userMap.entrySet()) {
            users.add(entry.getValue());
        }
        return users;
    }

    /**
     * user id for which the search will be performed
     * Create a new user
     *
     * @param user - which will be save
     * @return created user
     */
    public synchronized User create(User user) {
        return userMap.put(user.getUserId(), user);
    }

    /**
     * Get a user by id
     *
     * @param id - user id
     * @return null if there is no such user with this id, or user by this id
     */
    public User getById(long id) {
        return userMap.get(id);
    }

    /**
     * Attempt to remove a user
     *
     * @param id - user id which will be removed
     * @return null if there is no such user with this id, or removed user
     */
    public synchronized User removeById(long id) {
        return userMap.remove(id);
    }

    /**
     * Attempt to update User with id
     *
     * @param user - contains id of the user being modified and specified fields
     * @return null if there is no such user with this id, or updated user
     */
    public synchronized User updateById(long id, User user) {
        if (userMap.containsKey(id)) {
            User n_user = userMap.get(id);
            n_user.setUsername(user.getUsername());
            n_user.setSurname(user.getSurname());
            return n_user;
        } else {
            return null;
        }
    }

    /**
     * Get list of user by name or part of name
     *
     * @param name - name or part name for searching
     * @return a list of founded users, list may be empty
     */
    public List<User> getByNameOrSubName(String name) {
        List<User> users = new ArrayList<>();
        String patternString = ".*?" + name;
        Pattern pattern = Pattern.compile(patternString);
        for (User user : userMap.values()) {
            Matcher matcher = pattern.matcher(user.getUsername());
            if (matcher.find()) {
                users.add(user);
            }
        }
        return users;
    }
}
