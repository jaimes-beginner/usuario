package com.example.api_usuarios.repositories;

/*--------------------------------------------------*/

// Importaciónes
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.api_usuarios.models.entities.User;
import java.util.List;


/*--------------------------------------------------*/

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    // Método para buscar un usuario por su correo electrónico.
    User findByEmail(String email);
    
    // aca la cagé, poner bien los finds asgdagsag


}
