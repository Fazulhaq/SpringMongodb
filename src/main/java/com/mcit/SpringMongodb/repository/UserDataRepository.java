package com.mcit.SpringMongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mcit.SpringMongodb.model.UserData;

@Repository
public interface UserDataRepository extends MongoRepository<UserData, String> {

}
