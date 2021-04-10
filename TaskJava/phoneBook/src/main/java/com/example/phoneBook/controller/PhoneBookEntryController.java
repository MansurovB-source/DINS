package com.example.phoneBook.controller;

import com.example.phoneBook.model.PhoneBookEntry;
import com.example.phoneBook.service.PhoneBookStoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */

@RestController
@Api(tags = "phone book resource:")
public class PhoneBookEntryController {
    private final PhoneBookStoreService phoneBookStoreService;

    @Autowired
    public PhoneBookEntryController(PhoneBookStoreService phoneBookStoreService) {
        this.phoneBookStoreService = phoneBookStoreService;
    }

    @GetMapping("/phonebook")
    @ApiOperation(value = "To get list of all entries by userId")
    public List<PhoneBookEntry> getAllEntries(@RequestParam("userId") long userId) {
        return phoneBookStoreService.getAllByUserId(userId);
    }

    @PostMapping("/phonebook")
    @ApiOperation(value = "To create phone book entry")
    public PhoneBookEntry create(@RequestBody PhoneBookEntry phoneBookEntry) {
        return phoneBookStoreService.create(new PhoneBookEntry(phoneBookEntry.getName(), phoneBookEntry.getSurname(),
                phoneBookEntry.getPhoneNumber(), phoneBookEntry.getUserId()));
    }

    @GetMapping("/phonebook/{id}")
    @ApiOperation(value = "To get entry by id")
    public ResponseEntity<PhoneBookEntry> getById(@PathVariable("id") long id) {
        PhoneBookEntry phoneBookEntry;
        if ((phoneBookEntry = phoneBookStoreService.getById(id)) == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(phoneBookEntry, HttpStatus.OK);
    }

    @DeleteMapping("/phonebook/{id}")
    @ApiOperation(value = "To remove entry by id")
    public ResponseEntity<PhoneBookEntry> removeById(@PathVariable("id") long id) {
        PhoneBookEntry phoneBookEntry;
        if ((phoneBookEntry = phoneBookStoreService.removeById(id)) == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(phoneBookEntry, HttpStatus.OK);
    }

    @PutMapping("/phonebook/{id}")
    @ApiOperation(value = "To update entry by id")
    public ResponseEntity<PhoneBookEntry> updateById(@PathVariable("id") long id, @RequestBody PhoneBookEntry phoneBookEntry) {
        PhoneBookEntry n_phoneBookEntry;
        if ((n_phoneBookEntry = phoneBookStoreService.updateById(id, phoneBookEntry)) == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(n_phoneBookEntry, HttpStatus.OK);
    }

    @GetMapping("/phonebook/phonenum")
    @ApiOperation(value = "To get list of entries by phone number")
    public List<PhoneBookEntry> getByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber) {
        return phoneBookStoreService.getByPhoneNumber(phoneNumber);
    }
}
