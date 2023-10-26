package com.mcit.SpringMongodb.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mcit.SpringMongodb.service.EmptyFormService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class EmptyFormController {

    private EmptyFormService emptyFormService;
}
