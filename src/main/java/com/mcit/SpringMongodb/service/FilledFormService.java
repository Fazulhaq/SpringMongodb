package com.mcit.SpringMongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mcit.SpringMongodb.exception.EntityNotFoundException;
import com.mcit.SpringMongodb.model.EmptyForm;
import com.mcit.SpringMongodb.model.FilledForm;
import com.mcit.SpringMongodb.model.UserData;
import com.mcit.SpringMongodb.repository.EmptyFormRepository;
import com.mcit.SpringMongodb.repository.FilledFormRespository;
import com.mcit.SpringMongodb.repository.UserDataRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FilledFormService {

    FilledFormRespository filledFormRespository;
    UserDataRepository userDataRepository;
    EmptyFormRepository emptyFormRepository;

    public FilledForm getFilledForm(String filledFormId) {
        Optional<FilledForm> filledForm = filledFormRespository.findById(filledFormId);
        return testedFilledForm(filledForm, filledFormId);
    }

    public List<FilledForm> getFilledForms() {
        return (List<FilledForm>) filledFormRespository.findAll();
    }

    public FilledForm saveFilledForm(FilledForm filledForm, String userId, String emptyFormId) {
        UserData userData = UserDataService.unwrapUserData(userDataRepository.findById(userId), userId);
        EmptyForm emptyForm = EmptyFormService.unwrappedEmptyForm(emptyFormRepository.findById(emptyFormId),
                emptyFormId);
        filledForm.setUserData(userData);
        filledForm.setEmptyForm(emptyForm);
        return filledFormRespository.save(filledForm);
    }

    public FilledForm updateFilledForm(FilledForm newFilledForm, String filledFormId) {
        Optional<FilledForm> filledForm = filledFormRespository.findById(filledFormId);
        FilledForm testedFilledForm = testedFilledForm(filledForm, filledFormId);
        testedFilledForm.setFormTitle(newFilledForm.getFormTitle());
        testedFilledForm.setJsonText(newFilledForm.getJsonText());
        testedFilledForm.setFilledDate(newFilledForm.getFilledDate());
        testedFilledForm.setFormStatus(newFilledForm.getFormStatus());
        return filledFormRespository.save(testedFilledForm);
    }

    public void deleteFilledForm(String filledFormId) {
        Optional<FilledForm> filledForm = filledFormRespository.findById(filledFormId);
        FilledForm testedFilledForm = testedFilledForm(filledForm, filledFormId);
        filledFormRespository.delete(testedFilledForm);
    }

    static FilledForm testedFilledForm(Optional<FilledForm> filledForm, String formId) {
        if (filledForm.isPresent())
            return filledForm.get();
        else
            throw new EntityNotFoundException(formId, FilledForm.class);
    }
}
