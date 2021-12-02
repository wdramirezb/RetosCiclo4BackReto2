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
            Optional<Fragance> fraganceSave = fraganceRepository.getFragance(fragance.getReference());
            if (fraganceSave.isEmpty()) {
                return fraganceRepository.save(fragance);
            } else {
                return fragance;
            }
        }
    }


    public Fragance update(Fragance fragance) {
        if (fragance.getReference() != null) {
            Optional<Fragance> fraganceUpdate = fraganceRepository.getFragance(fragance.getReference());
            if (!fraganceUpdate.isEmpty()) {
                if (fragance.getBrand() != null) {
                    fraganceUpdate.get().setBrand(fragance.getBrand());
                }
                if (fragance.getCategory() != null) {
                    fraganceUpdate.get().setCategory(fragance.getCategory());
                }
                if (fragance.getPresentation() != null) {
                    fraganceUpdate.get().setPresentation(fragance.getPresentation());
                }
                if (fragance.getDescription() != null) {
                    fraganceUpdate.get().setDescription(fragance.getDescription());
                }
                if (fragance.getAvailability() != null) {
                    fraganceUpdate.get().setAvailability(fragance.getAvailability());
                }
                if (fragance.getPrice() != null) {
                    fraganceUpdate.get().setPrice(fragance.getPrice());
                }
                if (fragance.getQuantity() != null) {
                    fraganceUpdate.get().setQuantity(fragance.getQuantity());
                }
                if (fragance.getPhotography() != null) {
                    fraganceUpdate.get().setPhotography(fragance.getPhotography());
                }
                fraganceRepository.update(fraganceUpdate.get());
                return fraganceUpdate.get();
            } else {
                return fragance;
            }
        } else {
            return fragance;
        }
    }
    
    
    public boolean delete(String reference) {
        Optional<Fragance> fraganceDelete = fraganceRepository.getFragance(reference);
        if (!fraganceDelete.isEmpty()) {
            fraganceRepository.delete(fraganceDelete.get());
            return true;
        }
        return false;
    }

}

