package com.ciclo4.catalogo.repository;

import com.ciclo4.catalogo.model.Fragance;
import com.ciclo4.catalogo.repository.crud.FraganceCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FraganceRepository {

    @Autowired
    private FraganceCrudRepository fraganceCrudRepository;

    public List<Fragance> getAll() {
        return (List<Fragance>) fraganceCrudRepository.findAll();
    }

    public Optional<Fragance> getFragance(String reference) {
        return fraganceCrudRepository.findById(reference);
    }

    public Fragance save(Fragance fragance) {
        return fraganceCrudRepository.save(fragance);
    }
    
    public Fragance update(Fragance fragance) {
        return fraganceCrudRepository.save(fragance);
    }

    public void delete(Fragance fragance) {
        fraganceCrudRepository.delete(fragance);
    }

}
