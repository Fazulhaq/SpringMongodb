package com.mcit.SpringMongodb.model;

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
@Document(collection = "user_data")
public class UserData {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String userType;
}