/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.as.ocr.facades;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import puj.as.ocr.entities.Carro;

/**
 *
 * @author Estudiante
 */
@Local
public interface CarroFacadeLocal {

    void create(Carro carro);

    void edit(Carro carro);

    void remove(Carro carro);

    Carro find(Object id);

    List<Carro> findAll();

    List<Carro> findRange(int[] range);

    int count();

    public List<Carro> findByTipo(String tipo);

    public List<Carro> findByRangoPrecios(Double min, Double max);

    public List<Carro> findByLocalizacionCiudad(String ciudad);

    public List<Carro> findByLocalizacionDireccion(String direccion);

    public List<Carro> findByFilters(Map<String, Object> jsonFilters);
    
}
