package com.ciclo4.catalogo.service;

import com.ciclo4.catalogo.model.Fragance;
import com.ciclo4.catalogo.repository.FraganceRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraganceService {

    @Autowired
    private FraganceRepository fraganceRepository;

    public List<Fragance> getAll() {
        return fraganceRepository.getAll();
    }

    public Optional<Fragance> getFragance(String reference) {
        return fraganceRepository.getFragance(reference);
    }

    public Fragance save(Fragance fragance) {
        if (fragance.getReference() == null) {
            return fraganceRepository.save(fragance);
        } else {
            Optional<Fragance> consulta = fraganceRepository.getFragance(fragance.getReference());
            if (consulta.isEmpty()) {
                return fraganceRepository.save(fragance);
            } else {
                return fragance;
            }
        }
    }

    public boolean delete(String reference) {
        Optional<Fragance> consulta = fraganceRepository.getFragance(reference);
        if (!consulta.isEmpty()) {
            fraganceRepository.delete(consulta.get());
            return true;
        }
        return false;
    }

    public Fragance update(Fragance fragance) {
        if (fragance.getReference() != null) {
            Optional<Fragance> consulta = fraganceRepository.getFragance(fragance.getReference());
            if (!consulta.isEmpty()) {
                if (fragance.getBrand() != null) {
                    consulta.get().setBrand(fragance.getBrand());
                }
                if (fragance.getCategory() != null) {
                    consulta.get().setCategory(fragance.getCategory());
                }
                if (fragance.getPresentation() != null) {
                    consulta.get().setPresentation(fragance.getPresentation());
                }
                if (fragance.getDescription() != null) {
                    consulta.get().setDescription(fragance.getDescription());
                }
                if (fragance.getAvailability() != null) {
                    consulta.get().setAvailability(fragance.getAvailability());
                }
                if (fragance.getPrice() != null) {
                    consulta.get().setPrice(fragance.getPrice());
                }
                if (fragance.getQuantity() != null) {
                    consulta.get().setQuantity(fragance.getQuantity());
                }
                return fraganceRepository.save(consulta.get());
            }
        }
        return fragance;
    }

}

