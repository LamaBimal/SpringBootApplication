package com.test.rest.controller;

import com.test.rest.domain.User;
import com.test.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;

/**
 * Created by bimal on 2/5/18.
 */

@Controller // This means this is a controller
@RequestMapping(path="/user") // This means URL's start with /user (after Application Path)
public class UserController {

    @Autowired // This means to get the bean called userRepository
                // which is auto-generated by spring, we will use it to handle the data.
    public UserRepository userRepository;

    @GetMapping(path="/add")
    public @ResponseBody String add(@RequestParam String name,@RequestParam String email){
            // @ResponseBody means the returned String is a response, not a view name.
            // @RequestParam means it is a parameter from the GET/POST request.
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAll(){
        return userRepository.findAll();
    }
}