package com.example.phoneBook.service;

import com.example.phoneBook.model.PhoneBookEntry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */

@Service
public class PhoneBookStoreService implements StoreService<PhoneBookEntry> {
    private final Map<Long, PhoneBookEntry> phoneBook = new HashMap<>();


    public int size() {
        return phoneBook.size();
    }

    /**
     * Get all phone phone book entries by user id
     *
     * @param userId - user id for searching
     * @return list of founded phone book entry, list may be empty
     */
    public List<PhoneBookEntry> getAllByUserId(long userId) {
        List<PhoneBookEntry> phoneBookByUserId = new ArrayList<>();
        for (PhoneBookEntry phoneBookEntry : phoneBook.values()) {
            if (phoneBookEntry.getUserId() == userId) {
                phoneBookByUserId.add(phoneBookEntry);
            }
        }
        return phoneBookByUserId;
    }

    /**
     * Create a new phone book entry
     *
     * @param phoneBookEntry - which will be save
     * @return created entry in phone book
     */
    public synchronized PhoneBookEntry create(PhoneBookEntry phoneBookEntry) {
        return phoneBook.put(phoneBookEntry.getPhoneBookEntryId(), phoneBookEntry);
    }

    /**
     * Get a phone book entry by id
     *
     * @param id - phone book entry id
     * @return null if there is no such phone book entry with this id, or phone book entry by this id
     */
    public PhoneBookEntry getById(long id) {
        return phoneBook.get(id);
    }

    /**
     * Attempt to remove a phone book entry
     *
     * @param id - phone book entry id which will be removed
     * @return null if there is no such phone book entry with this id, or removed phone book entry
     */
    public synchronized PhoneBookEntry removeById(long id) {
        return phoneBook.remove(id);

    }

    /**
     * Attempt to update phone book entry
     *
     * @param phoneBookEntry - contains id of the phone book entry being modified and specified fields
     * @return null if there is no such entry in phone book with this id, or updated entry
     */
    public synchronized PhoneBookEntry updateById(long id, PhoneBookEntry phoneBookEntry) {
        if (phoneBook.containsKey(id)) {
            PhoneBookEntry entry = phoneBook.get(id);
            entry.setName(phoneBookEntry.getName());
            entry.setSurname(phoneBookEntry.getSurname());
            entry.setPhoneNumber(phoneBookEntry.getPhoneNumber());
            return entry;
        }
        return null;
    }

    /**
     * Get list of phone book entry by phone number
     *
     * @param phoneNumber - phone number for searching
     * @return a list of founded phone book entry, list may be empty
     */
    public List<PhoneBookEntry> getByPhoneNumber(String phoneNumber) {
        List<PhoneBookEntry> phoneBookByPhoneNumber = new ArrayList<>();
        for (PhoneBookEntry phoneBookEntry : phoneBook.values()) {
            if (phoneBookEntry.getPhoneNumber().equals(phoneNumber)) {
                phoneBookByPhoneNumber.add(phoneBookEntry);
            }
        }
        return phoneBookByPhoneNumber;
    }

    @Override
    public List<PhoneBookEntry> getAll() {
        List<PhoneBookEntry> phoneBookEntries = new ArrayList<>();
        for (Map.Entry<Long, PhoneBookEntry> entry : phoneBook.entrySet()) {
            phoneBookEntries.add(entry.getValue());
        }
        return phoneBookEntries;
    }
}
