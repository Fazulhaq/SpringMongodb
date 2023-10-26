package com.mcit.SpringMongodb.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mcit.SpringMongodb.service.FilledFormService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class FilledFormController {

    private FilledFormService filledFormService;

}
