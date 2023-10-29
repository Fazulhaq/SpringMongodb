package com.mcit.SpringMongodb.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mcit.SpringMongodb.model.FilledForm;
import com.mcit.SpringMongodb.service.FilledFormService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class FilledFormController {

    private FilledFormService filledFormService;

    @GetMapping("/filledform/{filledformid}")
    public ResponseEntity<FilledForm> getFilledForm(@PathVariable String filledformid) {
        return new ResponseEntity<>(filledFormService.getFilledForm(filledformid), HttpStatus.OK);
    }

    @GetMapping("/filledform/all")
    public ResponseEntity<List<FilledForm>> getFilledForms() {
        return new ResponseEntity<>(filledFormService.getFilledForms(), HttpStatus.OK);
    }

    @PostMapping("/filledform/{userid}/{emptyformid}")
    public ResponseEntity<HttpStatus> saveFilledForm(@RequestBody FilledForm filledForm, @PathVariable String userid,
            @PathVariable String emptyformid) {
        filledFormService.saveFilledForm(filledForm, userid, emptyformid);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/filledform/{filledformid}")
    public ResponseEntity<FilledForm> updateFilledForm(@RequestBody FilledForm filledForm,
            @PathVariable String filledformid) {
        return new ResponseEntity<>(filledFormService.updateFilledForm(filledForm, filledformid), HttpStatus.OK);
    }

    @DeleteMapping("/filledform/{filledformid}")
    public ResponseEntity<HttpStatus> deleteFilledForm(@PathVariable String filledformid) {
        filledFormService.deleteFilledForm(filledformid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
