package com.example.api_usuarios.services;

/*--------------------------------------------------*/

// Importaciónes
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.api_usuarios.models.entities.User;
import com.example.api_usuarios.repositories.UserRepository;

/*--------------------------------------------------*/

@Service
public class UserServices {
    
    // Atributos
    @Autowired
    private UserRepository userRepo;

    /* findBy[insertar fila], es lo que se está obteniendo 
    con este código */

    // Devuelve todos los usuarios desde la base de datos
    public List<User> obtenerTodos() {
        return userRepo.findAll();
    }

    // Obtener todos los usuarios actvos 
    public List<User> obtenerActivos() {
        return userRepo.findByActivo(true);
    }

    // Obtener un usuario por su email
    public User obtenerUnoPorEmail(String email) {
        User usuario = userRepo.findByEmail(email);
        if(usuario==null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return usuario;
    }


}
