package com.mcit.SpringMongodb.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private String formTitle;
    private String jsonText;
    private LocalDate publishDate;
}
