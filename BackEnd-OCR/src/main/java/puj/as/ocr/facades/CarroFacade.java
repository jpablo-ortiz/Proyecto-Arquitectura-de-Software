/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.as.ocr.facades;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import puj.as.ocr.entities.Carro;

/**
 *
 * @author Estudiante
 */
@Stateless
public class CarroFacade extends AbstractFacade<Carro> implements CarroFacadeLocal {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarroFacade() {
        super(Carro.class);
    }

    /**
     *
     * @param tipo
     * @return
     */
    @Override
    public List<Carro> findByTipo(String tipo) {
        // SELECT c FROM Carro c WHERE c.tipo = :tipo
        TypedQuery<Carro> query = em.createNamedQuery("Carro.findByTipo", Carro.class);
        query.setParameter("tipo", tipo);

        return query.getResultList();
    }

    /**
     *
     * @param min
     * @param max
     * @return
     */
    @Override
    public List<Carro> findByRangoPrecios(Double min, Double max) {
        TypedQuery<Carro> query = em.createNamedQuery("SELECT c FROM Carro c WHERE c.precio BETWEEN :min AND :max",
                Carro.class);
        query.setParameter("min", min);
        query.setParameter("max", max);

        return query.getResultList();
    }

    /**
     *
     * @param ciudad
     * @return
     */
    @Override
    public List<Carro> findByLocalizacionCiudad(String ciudad) {
        TypedQuery<Carro> query = em.createNamedQuery(
                "SELECT c FROM Carro c, Localizacion l WHERE c.idLocalizacion = l.idLocalizacion AND l.ciudad = :ciudad",
                Carro.class);
        query.setParameter("ciudad", ciudad);

        return query.getResultList();
    }

    /**
     *
     * @param direccion
     * @return
     */
    @Override
    public List<Carro> findByLocalizacionDireccion(String direccion) {
        TypedQuery<Carro> query = em.createNamedQuery(
                "SELECT c FROM Carro c, Localizacion l WHERE c.idLocalizacion = l.idLocalizacion AND l.direccion = :direccion",
                Carro.class);
        query.setParameter("direccion", direccion);

        return query.getResultList();
    }

    public List<Carro> findByFilters(Map<String, Object> jsonFilters) {
        String queryString = "SELECT c FROM Carro c WHERE ";

        if (jsonFilters.containsKey("tipo") && jsonFilters.get("tipo").toString().length() > 0) {
            String tipo = jsonFilters.get("tipo").toString();
            queryString += "c.tipo = '" + tipo + "'";
        }

        if (jsonFilters.containsKey("min") && jsonFilters.containsKey("max") && jsonFilters.get("min").toString().length() > 0
                && jsonFilters.get("max").toString().length() > 0) {
            Double min = Double.parseDouble(jsonFilters.get("min").toString());
            Double max = Double.parseDouble(jsonFilters.get("max").toString());
            if(queryString.endsWith("WHERE ")) {
                queryString += "c.precio BETWEEN " + min + " AND " + max;
            } else {
                queryString += " AND c.precio BETWEEN " + min + " AND " + max;
            }
        }

        if (jsonFilters.containsKey("localizacion")) {
            Map<String, Object> localizacion = (Map<String, Object>) jsonFilters.get("localizacion");
            if (localizacion.containsKey("ciudad") && localizacion.get("ciudad").toString().length() > 0) {
                String ciudad = localizacion.get("ciudad").toString();
                if (queryString.endsWith("WHERE ")) {
                    queryString += "c.idLocalizacion IN (SELECT l.idLocalizacion FROM Localizacion l WHERE l.ciudad = '"
                            + ciudad + "')";
                } else {
                    queryString += " AND c.idLocalizacion IN (SELECT l.idLocalizacion FROM Localizacion l WHERE l.ciudad = '"
                            + ciudad + "')";
                }
            }
            if (localizacion.containsKey("direccion") && localizacion.get("direccion").toString().length() > 0) {
                String direccion = localizacion.get("direccion").toString();
                if (queryString.endsWith("WHERE ")) {
                    queryString += "c.idLocalizacion IN (SELECT l.idLocalizacion FROM Localizacion l WHERE l.direccion = '"
                            + direccion + "')";
                } else {
                    queryString += " AND c.idLocalizacion IN (SELECT l.idLocalizacion FROM Localizacion l WHERE l.direccion = '"
                            + direccion + "')";
                }
            }
        }
        
        TypedQuery<Carro> query = em.createQuery(queryString, Carro.class);

        return query.getResultList();
    }

}
