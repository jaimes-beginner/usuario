package com.example.api_usuarios.services;

import java.util.Date;

/*--------------------------------------------------*/

// Importaciónes
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.api_usuarios.models.entities.User;
import com.example.api_usuarios.repositories.UserRepository;
import com.example.api_usuarios.requests.UserCrear;

/*--------------------------------------------------*/

// findBy[insertar fila], es lo que se está obteniendo con este código 
@Service
public class UserServices {
    
    // Atributos
    @Autowired
    private UserRepository userRepo;

    // Devuelve todos los usuarios desde la base de datos (método de repository)
    public List<User> obtenerTodos() {
        return userRepo.findAll();
    }

    // Obtener todos los usuarios actvos (método de repository)
    public List<User> obtenerActivos() {
        return userRepo.findByActivo(true);
    }

    // Obtener un usuario por su email (método de repository)
    public User obtenerUnoPorEmail(String email) {
        User usuario = userRepo.findByEmail(email);
        if(usuario==null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return usuario;
    }

    // Registrar a un nuevo usuario
    public User registrarUsuario(UserCrear usuario) {
        User nuevoUser = new User();    
        // campos de negocio
        nuevoUser.setActivo(true);
        nuevoUser.setFechaCreacion(new Date());
        // campos de vienen de la solicitud
        nuevoUser.setPassword(usuario.getPassword());
        nuevoUser.setEmail(usuario.getEmail());
        nuevoUser.setTelefono(usuario.getTelefono());
        nuevoUser.setNombre(usuario.getNombre());
        return userRepo.save(nuevoUser);
    }

}
