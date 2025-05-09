package com.example.api_usuarios.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserCrear {

    @NotBlank
    @Email
    private String email;
    
    private String telefono;

    @NotBlank
    private String password;

    private String nombre;

}
