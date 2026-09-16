package br.com.sistemavendas.resource;


import br.com.sistemavendas.entity.Produto;
import br.com.sistemavendas.service.ProdutoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {


    @Inject
    ProdutoService produtoService;

    @GET
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @GET
    @Path("/{id}")
    public Produto buscarPorId(@PathParam("id") Long id){
        return produtoService.buscarPorId(id);
    }

    @POST
    public void salvar(Produto produto) {
        produtoService.salvar(produto);
    }
}
