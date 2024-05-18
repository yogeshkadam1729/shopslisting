package com.roboelectric.shopslisting.controller;

import com.roboelectric.shopslisting.dto.ShopsDTO;
import com.roboelectric.shopslisting.dto.UserDTO;
import com.roboelectric.shopslisting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers()
    {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserDTO> getShop(@PathVariable int id)
    {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserDTO> createShop(@RequestBody UserDTO userDTO)
    {
        return new ResponseEntity<>(userService.addUser(userDTO),HttpStatus.CREATED);
    }

}
