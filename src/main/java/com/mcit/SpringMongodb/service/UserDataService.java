package com.mcit.SpringMongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mcit.SpringMongodb.exception.EntityNotFoundException;
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

    public Optional<UserData> getSingleUser(String id) {
        return (Optional<UserData>) userDataRepository.findById(id);
    }

    public UserData updateUserData(UserData userData, String userId) {
        Optional<UserData> userData1 = userDataRepository.findById(userId);
        UserData userData2 = unwrapUserData(userData1, userId);
        userData2.setFirstName(userData.getFirstName());
        userData2.setLastName(userData.getLastName());
        userData2.setEmail(userData.getEmail());
        userData2.setPassword(userData.getPassword());
        userData2.setUserType(userData.getUserType());
        return userDataRepository.save(userData2);
    }

    public void deleteUserData(String userId) {
        Optional<UserData> userData = userDataRepository.findById(userId);
        unwrapUserData(userData, userId);
        userDataRepository.deleteById(userId);
    }

    static UserData unwrapUserData(Optional<UserData> entity, String userid) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new EntityNotFoundException(userid, UserData.class);
    }

}
