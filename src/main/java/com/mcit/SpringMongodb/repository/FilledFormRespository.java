package com.mcit.SpringMongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mcit.SpringMongodb.model.FilledForm;

@Repository
public interface FilledFormRespository extends MongoRepository<FilledForm, String> {
}
