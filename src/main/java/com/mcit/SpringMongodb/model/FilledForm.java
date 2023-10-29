package com.mcit.SpringMongodb.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
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

    @NotBlank(message = "Form title should not be null")
    private String formTitle;

    @NotBlank(message = "JSON text should not be null")
    private String jsonText;

    @PastOrPresent(message = "Filling date of form must be in the past or present!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate filledDate;

    @NotNull(message = "Status of form should not be null")
    private FormStatus formStatus;

    @DBRef
    private UserData userData;

    @DBRef
    private EmptyForm emptyForm;
}
