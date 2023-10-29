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

import com.mcit.SpringMongodb.model.EmptyForm;
import com.mcit.SpringMongodb.service.EmptyFormService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class EmptyFormController {

    private EmptyFormService emptyFormService;

    @GetMapping("/emptyform/{emptyformid}")
    public ResponseEntity<EmptyForm> getEmptyForm(@PathVariable("emptyformid") String emptyformid) {
        return new ResponseEntity<>(emptyFormService.getEmptyForm(emptyformid), HttpStatus.OK);
    }

    @GetMapping("/emptyform/all")
    public ResponseEntity<List<EmptyForm>> getAllEmptyForm() {
        return new ResponseEntity<>(emptyFormService.getAllEmptyForm(), HttpStatus.OK);
    }

    @PostMapping("/emptyform/{userid}")
    public ResponseEntity<HttpStatus> saveEmptyForm(@Valid @RequestBody EmptyForm emptyform,
            @PathVariable String userid) {
        emptyFormService.saveEmptyForm(emptyform, userid);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/emptyform/{emptyformid}")
    public ResponseEntity<EmptyForm> updateEmptyForm(@Valid @RequestBody EmptyForm emptyForm,
            @PathVariable String emptyformid) {
        return new ResponseEntity<>(emptyFormService.updateEmptyForm(emptyForm, emptyformid), HttpStatus.OK);
    }

    @DeleteMapping("/emptyform/{emptyformid}")
    public ResponseEntity<HttpStatus> deleteEmptyForm(@PathVariable String emptyformid) {
        emptyFormService.deleteEmptyForm(emptyformid);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
