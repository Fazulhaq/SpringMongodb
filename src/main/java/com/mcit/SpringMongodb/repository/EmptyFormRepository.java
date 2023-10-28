package com.mcit.SpringMongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mcit.SpringMongodb.model.EmptyForm;

@Repository
public interface EmptyFormRepository extends MongoRepository<EmptyForm, String> {

}
