package Mojodoo.KnifeEdge.co.controllers;

import Mojodoo.KnifeEdge.co.models.User;
import Mojodoo.KnifeEdge.co.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "api/user")

public class UserController {
    @Autowired
    UserService userService;
    @PostMapping()
    public User createUserModel(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/all")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping ("/{id}")
    public User getUserById(@PathVariable String id){
        try {
            return userService.getUserById(id);
        } catch (NoSuchElementException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }


}

