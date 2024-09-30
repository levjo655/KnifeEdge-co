package Mojodoo.KnifeEdge.co.controllers;

import Mojodoo.KnifeEdge.co.services.UserService;
import Mojodoo.KnifeEdge.co.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/user")

public class UserController {
    @Autowired
    UserService userService;
    @PostMapping()
    public User createUserModel(@RequestBody User user){
        return userService.createUser(user);
    }

}

