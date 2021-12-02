package com.ciclo4.catalogo.webcontroller;

import com.ciclo4.catalogo.model.User;
import com.ciclo4.catalogo.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase que define la API para captura, consulta, actualización, eliminación y
 * validación de datos. La define como controlador REST y establece la URL base
 * com0 '/api/user'.
 *
 * @author William David Ramírez Blauvelt
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    /**
     * Indica que los servicios se deben conectan automaticamente sin necesidad
     * de definierlos. "Inyecta" unas dependencias con otras dentro de Spring.
     */
    @Autowired
    private UserService userService;

    /**
     * Establece URL para consultar (GET) todos los datos de todos los usuarios
     * creados.
     *
     * @return: id, número de identificación, nombre, día de cumpleaños, mes de
     * cumpleaños, dirección, número celular, correo electrónico, contraseña,
     * zona y tipo de usuario.
     */
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    /**
     * Establece URL para consultar (GET) todos los datos de un usuario en
     * particular.
     *
     * @param: id de usuario.
     * @return: id, número de identificación, nombre, día de cumpleaños, mes de
     * cumpleaños, dirección, número celular, correo electrónico, contraseña,
     * zona y tipo de usuario del usuario consultado.
     */
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    /**
     * Establece URL para guardar (POST) nuevos usuarios
     *
     * @param: número de identificación, nombre, día de cumpleaños, mes de
     * cumpleaños, dirección, número celular, correo electrónico, contraseña,
     * zona y tipo de usuario.
     * @return: id, número de identificación, nombre, día de cumpleaños, mes de
     * cumpleaños, dirección, número celular, correo electrónico, contraseña,
     * zona y tipo de usuario del usuario creado.
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    /**
     * Establece URL para actualizar (PUT) información de un usuario.
     *
     * @param: número de identificación, nombre, día de cumpleaños, mes de
     * cumpleaños, dirección, número celular, correo electrónico, contraseña,
     * zona y tipo de usuario.
     * @return: id, número de identificación, nombre, día de cumpleaños, mes de
     * cumpleaños, dirección, número celular, correo electrónico, contraseña,
     * zona y tipo de usuario del usuario actualizado.
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    /**
     * Establece URL para eliminar (DELETE) todos los datos de un usuario en
     * particular.
     *
     * @param: id de usuario.
     * @return: @return: true o false.
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }

    /**
     * Establece URL para validar existencia de combinación correo y contraseña
     * para decidir si se permite autenticación de usuario en aplicación).
     *
     * @param: correo y contraseña.
     * @return correo y contraseña del usuario consultado.
     */
    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }

    /**
     * Establece URL para consulta de correos electrónicos existentes para
     * evitar evitar la creación de usuarios con el mismo correo (duplicados).
     *
     * @param: correo.
     * @return: true o false.
     */
    @GetMapping("/emailexist/{email}")
    public boolean emailExists(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }

}
