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
    
    // Método que trae un usuario activo dependiendo de su email
    User findByNombre(String email, Boolean activo);

    // Método que trae a mas de un usuario que estén activos
    List<User> findByActivo(Boolean activo);

    
    User findByEmailActivo(String email, Boolean activo);

}
