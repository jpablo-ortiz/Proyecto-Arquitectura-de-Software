/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.as.ocr.integracion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import puj.as.ocr.entities.Carro;
import puj.as.ocr.facades.CarroFacadeLocal;

/**
 *
 * @author Grupo 3
 */
@Stateless
public class IntegradorBuscarCarro {

    @Context
    private UriInfo context;

    @Inject
    private CarroFacadeLocal carroFacade;

    public List<Carro> buscarCarros(Map<String, Object> jsonFilters) {
        return carroFacade.findByFilters(jsonFilters);
    }

    public List<Carro> buscarCarros1(Map<String, Object> jsonFilters) {
        // Filtrar por tipo
        // Filtrar por rango de precios
        // Filtrar por localización
        List<Carro> carrosTipo = new ArrayList<>();
        List<Carro> carrosPrecio = new ArrayList<>();
        List<Carro> carrosCiudad = new ArrayList<>();
        List<Carro> carrosDireccion = new ArrayList<>();

        if (jsonFilters.containsKey("tipo")) {
            String tipo = jsonFilters.get("tipo").toString();
            carrosTipo = carroFacade.findByTipo(tipo);
        }

        if (jsonFilters.containsKey("min") && jsonFilters.containsKey("max")) {
            Double min = Double.parseDouble(jsonFilters.get("min").toString());
            Double max = Double.parseDouble(jsonFilters.get("max").toString());
            carrosPrecio = carroFacade.findByRangoPrecios(min, max);
        }

        if (jsonFilters.containsKey("localizacion")) {
            Map<String, Object> localizacion = (Map<String, Object>) jsonFilters.get("localizacion");
            if (localizacion.containsKey("ciudad")) {
                String ciudad = localizacion.get("ciudad").toString();
                carrosCiudad = carroFacade.findByLocalizacionCiudad(ciudad);
            }
            if (localizacion.containsKey("direccion")) {
                String direccion = localizacion.get("direccion").toString();
                carrosDireccion = carroFacade.findByLocalizacionDireccion(direccion);
            }
        }

        if(carrosTipo.isEmpty() && carrosPrecio.isEmpty() && carrosCiudad.isEmpty() && carrosDireccion.isEmpty()) {
            return carroFacade.findAll();
        } else {
            List<Carro> carros = new ArrayList<>();
        }

        return null;
    }
    
    // ================= Funciones Auxiliares =================
    public List<Carro> interseccionListasCarros(List<Carro> lista1, List<Carro> lista2) {

        if (lista1.size() == 0) {
            return lista2;
        }

        if (lista2.size() == 0) {
            return lista1;
        }

        List<Carro> listaInterseccion = new ArrayList<>();

        for (Carro carro : lista1) {
            for (Carro carro2 : lista2) {
                if (carro.getIdCarro() == carro2.getIdCarro()) {
                    listaInterseccion.add(carro);
                }
            }
        }

        return listaInterseccion;
    }
}
