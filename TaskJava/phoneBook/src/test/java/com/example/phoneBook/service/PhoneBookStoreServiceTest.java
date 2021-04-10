package com.example.phoneBook.service;

import com.example.phoneBook.model.PhoneBookEntry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class PhoneBookStoreServiceTest {

    @Test
    void getAllByUserId() {
        PhoneBookStoreService phoneBookStoreService = new PhoneBookStoreService();
        PhoneBookEntry phoneBookEntry_1 = new PhoneBookEntry("Behruz_1", "Mansurov_1", "+99999999999", 1);
        PhoneBookEntry phoneBookEntry_2 = new PhoneBookEntry("Behruz_2", "Mansurov_2", "+99999999998", 1);
        PhoneBookEntry phoneBookEntry_3 = new PhoneBookEntry("Behruz_3", "Mansurov_3", "+99999999997", 1);
        PhoneBookEntry phoneBookEntry_4 = new PhoneBookEntry("Behruz_4", "Mansurov_4", "+99999999996", 2);

        phoneBookStoreService.create(phoneBookEntry_1);
        phoneBookStoreService.create(phoneBookEntry_2);
        phoneBookStoreService.create(phoneBookEntry_3);
        phoneBookStoreService.create(phoneBookEntry_4);

        List<PhoneBookEntry> phoneBookEntries = phoneBookStoreService.getAllByUserId(1);
        assertEquals(3, phoneBookEntries.size());

    }

    @Test
    void create() {
        PhoneBookStoreService phoneBookStoreService = new PhoneBookStoreService();
        PhoneBookEntry phoneBookEntry_1 = new PhoneBookEntry("Behruz_1", "Mansurov_1", "+99999999999", 1);
        PhoneBookEntry phoneBookEntry_2 = new PhoneBookEntry("Behruz_2", "Mansurov_2", "+99999999998", 1);
        PhoneBookEntry phoneBookEntry_3 = new PhoneBookEntry("Behruz_3", "Mansurov_3", "+99999999997", 1);
        PhoneBookEntry phoneBookEntry_4 = new PhoneBookEntry("Behruz_4", "Mansurov_4", "+99999999996", 2);

        phoneBookStoreService.create(phoneBookEntry_1);
        phoneBookStoreService.create(phoneBookEntry_2);
        phoneBookStoreService.create(phoneBookEntry_3);
        phoneBookStoreService.create(phoneBookEntry_4);

        assertEquals(4, phoneBookStoreService.size());
    }

    @Test
    void getById() {
        PhoneBookStoreService phoneBookStoreService = new PhoneBookStoreService();
        PhoneBookEntry phoneBookEntry_1 = new PhoneBookEntry(1,"Behruz_1", "Mansurov_1", "+99999999999", 1);
        PhoneBookEntry phoneBookEntry_2 = new PhoneBookEntry(2,"Behruz_2", "Mansurov_2", "+99999999998", 2);
        phoneBookStoreService.create(phoneBookEntry_1);
        phoneBookStoreService.create(phoneBookEntry_2);

        long id = phoneBookStoreService.getById(1).getPhoneBookEntryId();

        assertEquals(1, id);
    }

    @Test
    void removeById() {
        PhoneBookStoreService phoneBookStoreService = new PhoneBookStoreService();
        PhoneBookEntry phoneBookEntry_1 = new PhoneBookEntry(1,"Behruz_1", "Mansurov_1", "+99999999999", 1);
        PhoneBookEntry phoneBookEntry_2 = new PhoneBookEntry(2, "Behruz_2", "Mansurov_2", "+99999999998", 2);

        phoneBookStoreService.create(phoneBookEntry_1);
        phoneBookStoreService.create(phoneBookEntry_2);

        long id = phoneBookStoreService.removeById(1).getPhoneBookEntryId();
        assertEquals(1, phoneBookStoreService.size());
        assertEquals(1, id);
    }

    @Test
    void updateById() {
        PhoneBookStoreService phoneBookStoreService = new PhoneBookStoreService();
        PhoneBookEntry phoneBookEntry_1 = new PhoneBookEntry(1, "Behruz_1", "Mansurov_1", "+99999999999", 1);
        PhoneBookEntry phoneBookEntry_2 = new PhoneBookEntry(2, "Behruz_2", "Mansurov_2", "+99999999998", 2);
        phoneBookStoreService.create(phoneBookEntry_1);
        phoneBookStoreService.create(phoneBookEntry_2);

        phoneBookStoreService.updateById(1, new PhoneBookEntry(1,"Behruz", "Mansurov", "+11111111111", 1));
        PhoneBookEntry phoneBookEntry = phoneBookStoreService.getById(1);

        assertEquals("Behruz", phoneBookEntry.getName());
        assertEquals("Mansurov", phoneBookEntry.getSurname());
        assertEquals("+11111111111", phoneBookEntry.getPhoneNumber());
        assertEquals(1, phoneBookEntry.getUserId());

    }

    @Test
    void getByPhoneNumber() {
        PhoneBookStoreService phoneBookStoreService = new PhoneBookStoreService();
        PhoneBookEntry phoneBookEntry_1 = new PhoneBookEntry("Behruz_1", "Mansurov_1", "+99999999999", 1);
        PhoneBookEntry phoneBookEntry_2 = new PhoneBookEntry("Behruz_2", "Mansurov_2", "+99999999998", 2);
        phoneBookStoreService.create(phoneBookEntry_1);
        phoneBookStoreService.create(phoneBookEntry_2);

        List<PhoneBookEntry> phoneBookEntries = phoneBookStoreService.getByPhoneNumber("+99999999999");
        assertEquals(1, phoneBookEntries.size());
        assertEquals("+99999999999", phoneBookEntries.get(0).getPhoneNumber());

    }
}