package com.mcit.SpringMongodb.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "empty_form")
public class EmptyForm {

    @Id
    private String id;

    @NotBlank(message = "Form title should not be Null")
    private String formTitle;

    @NotBlank(message = "JSON text should not be null")
    private String jsonText;

    @PastOrPresent(message = "Publish date must be in the past or present!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishDate;

    @DBRef
    private UserData userDataId;
}
