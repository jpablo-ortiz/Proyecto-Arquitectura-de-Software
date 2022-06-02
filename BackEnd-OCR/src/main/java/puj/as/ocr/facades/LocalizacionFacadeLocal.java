/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.as.ocr.facades;

import java.util.List;
import javax.ejb.Local;
import puj.as.ocr.entities.Localizacion;

/**
 *
 * @author Estudiante
 */
@Local
public interface LocalizacionFacadeLocal {

    void create(Localizacion localizacion);

    void edit(Localizacion localizacion);

    void remove(Localizacion localizacion);

    Localizacion find(Object id);

    List<Localizacion> findAll();

    List<Localizacion> findRange(int[] range);

    int count();
    
}
