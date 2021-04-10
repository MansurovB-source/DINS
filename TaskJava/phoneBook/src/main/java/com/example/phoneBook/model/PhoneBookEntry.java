package com.example.phoneBook.model;

import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class PhoneBookEntry {
    private long phoneBookEntryId;
    private String name;
    private String surname;
    private String phoneNumber;
    private long userId;

    private static long id = 0;

    private static long generateId() {
        id++;
        return id;
    }

    public PhoneBookEntry() {
    }

    public PhoneBookEntry(long phoneBookEntryId, String name, String surname, String phoneNumber, long userId) {
        this.phoneBookEntryId = phoneBookEntryId;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
    }

    public PhoneBookEntry(String name, String surname, String phoneNumber, long userId) {
        this.phoneBookEntryId = generateId();
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
    }

    public long getPhoneBookEntryId() {
        return phoneBookEntryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public static long getId() {
        return id;
    }

    public static void setId(long id) {
        PhoneBookEntry.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBookEntry that = (PhoneBookEntry) o;
        return phoneBookEntryId == that.phoneBookEntryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneBookEntryId);
    }

    @Override
    public String toString() {
        return "PhoneBookEntry{" +
                "phoneBookEntryId=" + phoneBookEntryId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userId=" + userId +
                '}';
    }
}
