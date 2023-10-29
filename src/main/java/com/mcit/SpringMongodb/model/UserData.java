package com.mcit.SpringMongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "First Name should not be null")
    private String firstName;

    @NotBlank(message = "Last Name should not be null")
    private String lastName;

    @Email(message = "Enter a valid email address")
    @NotBlank(message = "Email should not be null")
    @NotNull
    private String email;

    @NotBlank(message = "Password should not be null")
    @NotNull
    private String password;

    @NotNull(message = "User type should not be null")
    private UserType userType;
}
