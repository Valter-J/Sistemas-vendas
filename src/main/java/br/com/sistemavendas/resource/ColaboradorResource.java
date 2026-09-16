package br.com.sistemavendas.resource;


import br.com.sistemavendas.entity.Colaborador;
import br.com.sistemavendas.service.ColaboradorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/colaboradores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ColaboradorResource {


    @Inject
    ColaboradorService colaboradorService;

    @GET
    public List<Colaborador> listarTodos(){
        return colaboradorService.listarTodos();
    }

    @POST
    public void salvar(Colaborador colaborador) {
        colaboradorService.salvar(colaborador);
    }

}
