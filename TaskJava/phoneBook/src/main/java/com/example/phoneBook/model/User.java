package com.example.phoneBook.model;

import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */

public class User {
    private long userId;
    private String username;
    private String surname;

    private static long id = 0;

    private static long generateId() {
        id++;
        return id;
    }

    public User() {
    }

    public User(long userId, String username, String surname) {
        this.userId = userId;
        this.username = username;
        this.surname = surname;
    }

    public User(String username, String surname) {
        this.userId = generateId();
        this.username = username;
        this.surname = surname;
    }

    public long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
