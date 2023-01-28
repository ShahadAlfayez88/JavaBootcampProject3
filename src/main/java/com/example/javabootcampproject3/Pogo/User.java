package com.example.javabootcampproject3.Pogo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @NotEmpty(message = "Id field is required!")
    @Size(min= 3 , max = 3 , message = "the length of the id must equal 3 ")
    private String id;

    @NotEmpty(message = "Username field is required!")
    @Size(min= 5 , max = 5  , message = "the username must equal 5 ")
    private String  username;
    @NotEmpty(message = "Password field is required!")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,}$", message = "Please enter a valid password")
    private String password;
    @NotEmpty(message = "Email field is required!")
    @Email(message = "Please Enter a valid email")
    private String  email;

    @NotEmpty(message = "Role field is required!")
    @Pattern( regexp = "^Admin|Customer$" ,message = "Role field only allow input: Customer or Admin" )
    private String  role;

    @NotNull(message = "Role field is required!")
    @Positive ( message = "Balance must be positive")
    private int balance;



}
