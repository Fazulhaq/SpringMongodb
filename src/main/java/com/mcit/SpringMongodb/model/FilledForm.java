package com.mcit.SpringMongodb.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "filled_form")
public class FilledForm {

    @Id
    private String id;
    private String formTitle;
    private String jsonText;
    private LocalDate filledDate;

    @DBRef
    private UserData userData;

    @DBRef
    private EmptyForm emptyForm;
}
