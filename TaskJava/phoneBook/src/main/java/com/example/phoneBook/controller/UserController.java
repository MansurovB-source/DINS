package com.example.phoneBook.controller;

import com.example.phoneBook.model.User;
import com.example.phoneBook.service.UserStoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */

@RestController
@Api(tags = "user resource:")
public class UserController {
    private final UserStoreService userStoreService;

    @Autowired
    public UserController(UserStoreService userStoreService) {
        this.userStoreService = userStoreService;
    }

    @GetMapping("/users")
    @ApiOperation(value = "To get list of all users")
    public List<User> getAllUsers() {
        return userStoreService.getAll();
    }

    @PostMapping("/user")
    @ApiOperation(value = "Create a new user")
    public User createUser(@RequestBody User user) {
        return userStoreService.create(new User(user.getUsername(), user.getSurname()));
    }

    @GetMapping("/user/{id}")
    @ApiOperation(value = "To get user by id")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        User user;
        if ((user = userStoreService.getById(id)) == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @DeleteMapping("/user/{id}")
    @ApiOperation(value = "To remove user by id")
    public ResponseEntity<User> removeById(@PathVariable("id") long id) {
        User user;
        if ((user = userStoreService.removeById(id)) == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    @ApiOperation(value = "To update user by id")
    public ResponseEntity<User> updateById(@PathVariable("id") long id, @RequestBody User user) {
        User n_user;
        if ((n_user = userStoreService.updateById(id, user)) == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(n_user, HttpStatus.OK);
    }

    @GetMapping("/user")
    @ApiOperation(value = "To get list of users by name or subName")
    public List<User> getByNameOrSubName(@RequestParam("name") String name) {
        return userStoreService.getByNameOrSubName(name);
    }
}
