package com.mcit.SpringMongodb.service;

import org.springframework.stereotype.Service;

import com.mcit.SpringMongodb.repository.EmptyFormRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmptyFormService {

    private EmptyFormRepository emptyFormRepository;
}
