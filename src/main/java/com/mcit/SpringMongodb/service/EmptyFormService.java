package com.mcit.SpringMongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mcit.SpringMongodb.exception.EntityNotFoundException;
import com.mcit.SpringMongodb.model.EmptyForm;
import com.mcit.SpringMongodb.model.UserData;
import com.mcit.SpringMongodb.repository.EmptyFormRepository;
import com.mcit.SpringMongodb.repository.UserDataRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmptyFormService {

    private EmptyFormRepository emptyFormRepository;
    private UserDataRepository userDataRepository;

    public EmptyForm getEmptyForm(String emptyFormId) {
        Optional<EmptyForm> emptyForm = emptyFormRepository.findById(emptyFormId);
        return unwrappedEmptyForm(emptyForm, emptyFormId);
    }

    public List<EmptyForm> getAllEmptyForm() {
        return (List<EmptyForm>) emptyFormRepository.findAll();
    }

    public EmptyForm saveEmptyForm(EmptyForm emptyForm, String userId) {
        UserData userData = UserDataService.unwrapUserData(userDataRepository.findById(userId), userId);
        emptyForm.setUserDataId(userData);
        return emptyFormRepository.save(emptyForm);
    }

    public EmptyForm updateEmptyForm(EmptyForm newEmptyForm, String emptyFormId) {
        Optional<EmptyForm> emptyForm = emptyFormRepository.findById(emptyFormId);
        EmptyForm unwrappedEmptyForm = unwrappedEmptyForm(emptyForm, emptyFormId);
        unwrappedEmptyForm.setFormTitle(newEmptyForm.getFormTitle());
        unwrappedEmptyForm.setJsonText(newEmptyForm.getJsonText());
        unwrappedEmptyForm.setPublishDate(newEmptyForm.getPublishDate());
        return emptyFormRepository.save(unwrappedEmptyForm);
    }

    public void deleteEmptyForm(String emptyformid) {
        Optional<EmptyForm> emptyForm = emptyFormRepository.findById(emptyformid);
        EmptyForm unwrappedEmptyForm = unwrappedEmptyForm(emptyForm, emptyformid);
        emptyFormRepository.delete(unwrappedEmptyForm);
    }

    static EmptyForm unwrappedEmptyForm(Optional<EmptyForm> entity, String emptyFormId) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new EntityNotFoundException(emptyFormId, EmptyForm.class);
    }
}
