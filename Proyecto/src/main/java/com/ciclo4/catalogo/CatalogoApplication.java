package com.ciclo4.catalogo;

import com.ciclo4.catalogo.repository.crud.UserCrudRepository;
import com.ciclo4.catalogo.repository.crud.FraganceCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class CatalogoApplication implements CommandLineRunner {

    @Autowired
    private FraganceCrudRepository fraganceCrudRepository;
    @Autowired
    private UserCrudRepository userCrudRepository;

    public static void main(String[] args) {
        SpringApplication.run(CatalogoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        fraganceCrudRepository.deleteAll();
        userCrudRepository.deleteAll();
    }

}
