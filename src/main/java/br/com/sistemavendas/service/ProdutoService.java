package br.com.sistemavendas.service;


import br.com.sistemavendas.entity.Produto;
import br.com.sistemavendas.repository.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ProdutoService {


    @Inject
    ProdutoRepository produtoRepository;


    public void salvar(Produto produto) {
        produtoRepository.persist(produto);
    }

    public List<Produto> listarTodos() {
        return produtoRepository.listAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }
}

