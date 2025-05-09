package com.example.api_usuarios.controllers;

/*--------------------------------------------------*/

// Importaciónes
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.api_usuarios.models.entities.User;
import com.example.api_usuarios.requests.UserCrear;
import com.example.api_usuarios.services.UserServices;
import jakarta.validation.Valid;

/*--------------------------------------------------*/

@RestController
@RequestMapping("user")
public class UserController {

    // Atributos
    @Autowired
    private UserServices userServices;
    
    // Obtener todos los usuarios (método de service)
    @GetMapping("/")
    public List<User> obtenerTodos() {
        return userServices.obtenerTodos();
    }

    @PostMapping("")
    public User crear(@Valid @RequestBody UserCrear nuevo) {
        return userServices.registrarUsuario(nuevo);
    }
    


}
