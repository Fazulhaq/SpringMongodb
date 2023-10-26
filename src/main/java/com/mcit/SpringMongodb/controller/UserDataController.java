package com.mcit.SpringMongodb.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mcit.SpringMongodb.model.UserData;
import com.mcit.SpringMongodb.service.UserDataService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserDataController {

    private UserDataService userDataService;

    @GetMapping("/allusers")
    public ResponseEntity<?> getAllUserData() {
        List<UserData> users = userDataService.getAllUsers();
        if (users.size() > 0) {
            return new ResponseEntity<>(userDataService.getAllUsers(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("There is no user on the list", HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/userdata")
    public ResponseEntity<?> saveUserData(@RequestBody UserData userData) {

        try {

            return new ResponseEntity<UserData>(userDataService.saveUserData(userData), HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
