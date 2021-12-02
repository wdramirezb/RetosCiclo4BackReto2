package com.ciclo4.catalogo.service;

import com.ciclo4.catalogo.model.User;
import com.ciclo4.catalogo.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }

    public User save(User user) {
        if (user.getId() == null) {
            return user;
        } else {
            Optional<User> userSave = userRepository.getUser(user.getId());
            if (userSave.isEmpty()) {
                if (emailExists(user.getEmail()) == false) {
                    return userRepository.save(user);
                } else {
                    return user;
                }
            } else {
                return user;
            }
        }
    }

    public User update(User user) {
        if (user.getId() != null) {
            Optional<User> userUpdate = userRepository.getUser(user.getId());
            if (!userUpdate.isEmpty()) {
                if (user.getIdentification() != null) {
                    userUpdate.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userUpdate.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userUpdate.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userUpdate.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userUpdate.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userUpdate.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userUpdate.get().setZone(user.getZone());
                }
                if (user.getType() != null) {
                    userUpdate.get().setType(user.getType());
                }
                userRepository.update(userUpdate.get());
                return userUpdate.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean delete(Integer id) {
        Optional<User> userDelete = userRepository.getUser(id);
        if (!userDelete.isEmpty()) {
            userRepository.delete(userDelete.get());
            return true;
        }
        return false;
    }

    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }

    public User authenticateUser(String email, String password) {
        Optional<User> usuario = userRepository.authenticateUser(email, password);
        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }
}
