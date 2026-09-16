package br.com.sistemavendas.resource;


import br.com.sistemavendas.dto.RegistrarVendaRequest;
import br.com.sistemavendas.entity.Venda;
import br.com.sistemavendas.service.VendaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/vendas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VendaResource {

    @Inject
    VendaService vendaService;

    @POST
    public Venda registrarVenda(RegistrarVendaRequest request) {

        return vendaService.registrarVenda(
                request.produtoId(),
                request.valor()
        );
    }

    @GET
    public List<Venda> listarTodas() {
        return vendaService.listarTodas();
    }

    @GET
    @Path("/{id}")
    public Venda buscarPorId(@PathParam("id") Long id) {
        return vendaService.buscarPorId(id);
    }

    @PATCH
    @Path("/{id}/cancelar")
    public Venda cancelarVenda(@PathParam("id") Long id) {
        return vendaService.cancelarVenda(id);
    }


}
