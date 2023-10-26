package com.mcit.SpringMongodb.service;

import org.springframework.stereotype.Service;

import com.mcit.SpringMongodb.repository.FilledFormRespository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FilledFormService {

    private FilledFormRespository filledFormRespository;
}
