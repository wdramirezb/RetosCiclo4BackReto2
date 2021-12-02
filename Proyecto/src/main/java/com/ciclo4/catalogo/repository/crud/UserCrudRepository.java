package com.ciclo4.catalogo.repository.crud;

import com.ciclo4.catalogo.model.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserCrudRepository extends MongoRepository<User, Integer> {

    /**
     * Consultar si email existe en base de datos (Si ya existe, no se puede
     * volver a utilizar)
     */
    Optional<User> findByEmail(String email);

    /**
     * Consultar si combinación de email y password existen en base de datos (si
     * ambos existen se permite acceso a aplicación
     */
    Optional<User> findByEmailAndPassword(String email, String password);
}
