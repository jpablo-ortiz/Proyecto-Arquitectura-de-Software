package puj.as.ocr.negocio.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.json.JSONObject;

import puj.as.ocr.DTO.CarroDTO;
import puj.as.ocr.entities.Carro;
import puj.as.ocr.negocio.NegocioBuscarCarro;
import puj.as.ocr.negocio.NegocioRentarCarro;

@Path("carro")
@RequestScoped
public class ProxyJava {

    @Inject
    private NegocioRentarCarro negocioRentaCarro;

    @Inject
    private NegocioBuscarCarro negocioBuscarCarro;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProxyJava
     */
    public ProxyJava() {
    }

/**
     * Servicio Para Buscar Carros.
     *
     * @param jsonFilters: Recibe un JSON con todos los filtros
     * @return Response
     */
    @POST
    @Path("/buscar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarCarro(String jsonFilters) {
        /* 
        {
            "tipo": "",
            "min": "",
            "max": "",
            "localizacion": {
                "ciudad": "",
                "direccion": ""
            }
        }
        */

        //Hacer conversión de String a JSON
        JSONObject jsonFilter = new JSONObject(jsonFilters);
        
        List<Carro> carros = negocioBuscarCarro.buscarCarros(jsonFilter);
        // Mapear carros a CarroDTO
        List<CarroDTO> carrosDTO = new ArrayList<>();
        for (Carro carro : carros) {
            carrosDTO.add(new CarroDTO(carro));
        }
        return Response
                .ok(carrosDTO)
                .build();
    }

    //TODO: Implementar
    public Response rentarCarro(){
        return null;
    }
}
