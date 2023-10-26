package com.mcit.SpringMongodb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mcit.SpringMongodb.model.UserData;
import com.mcit.SpringMongodb.repository.UserDataRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDataService {

    private UserDataRepository userDataRepository;

    public List<UserData> getAllUsers() {
        return userDataRepository.findAll();
    }

    public UserData saveUserData(UserData userData) {

        return userDataRepository.save(userData);
    }

}
