package puj.as.ocr.negocio;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.json.JSONObject;

import puj.as.ocr.entities.Carro;
import puj.as.ocr.integracion.IntegradorBuscarCarro;  

/**
 *
 * @author Grupo 3
 */
@Stateless
public class NegocioBuscarCarro {

    @Inject
    private IntegradorBuscarCarro integradorBuscarCarro;

    public List<Carro> buscarCarros(JSONObject jsonFilters) {
        // Poner los filtros en un Map
        Map<String, Object> filtros = jsonFilters.toMap();

        return integradorBuscarCarro.buscarCarros(filtros);
    }

}
