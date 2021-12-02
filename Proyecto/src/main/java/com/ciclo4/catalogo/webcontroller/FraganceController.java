package com.ciclo4.catalogo.webcontroller;

import com.ciclo4.catalogo.model.Fragance;
import com.ciclo4.catalogo.service.FraganceService;
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
 * como '/api/fragance'.
 *
 * @author William David Ramírez Blauvelt
 */
@RestController
@RequestMapping("/api/fragance")
@CrossOrigin("*")
public class FraganceController {

    /**
     * Indica que los servicios se deben conectan automaticamente sin necesidad
     * de definierlos. "Inyecta" unas dependencias con otras dentro de Spring.
     */
    @Autowired
    private FraganceService fraganceService;

    /**
     * Establece URL para consultar (GET) todos los datos de todas las fragancias
     * creadas.
     * @return: referencia, marca, categoría, presentación, descripción, 
     * disponibilidad, precio, cantidad y ubicación de foto de todas las 
     * fragancias existentes.
     */
    @GetMapping("/all")
    public List<Fragance> getAll() {
        return fraganceService.getAll();
    }

    /**
     * Establece URL para consultar (GET) todos los datos de una fragancia en
     * particular.
     * @param: referencia de fragancia.
     * @return: referencia, marca, categoría, presentación, descripción, 
     * disponibilidad, precio, cantidad y ubicación de foto de la fragancia consultada.
     */
    @GetMapping("/{id}")
    public Optional<Fragance> getFragance(@PathVariable("reference") String reference) {
        return fraganceService.getFragance(reference);
    }

    /**
     * Establece URL para guardar (POST) nuevas fragancias.
     *
     * @param: referencia, marca, categoría, presentación, descripción, 
     * disponibilidad, precio, cantidad y ubicación de foto.
     * @return: referencia, marca, categoría, presentación, descripción, 
     * disponibilidad, precio, cantidad y ubicación de foto de la fragancia creada.
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Fragance save(@RequestBody Fragance fragance) {
        return fraganceService.save(fragance);
    }

    /**
     * Establece URL para actualizar (PUT) información de una fragancia.
     *
     * @param: referencia, marca, categoría, presentación, descripción, 
     * disponibilidad, precio, cantidad y ubicación de foto.
     * @return: referencia, marca, categoría, presentación, descripción, 
     * disponibilidad, precio, cantidad y ubicación de foto de la fragancia actualizada.
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Fragance update(@RequestBody Fragance fragance) {
        return fraganceService.update(fragance);
    }

    /**
     * Establece URL para eliminar (DELETE) todos los datos de una fragancias en
     * particular.
     *
     * @param: referencia de fragancia.
     * @return: @return: true o false.
     */
    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return fraganceService.delete(reference);
    }
}
