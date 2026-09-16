package br.com.sistemavendas.service;


import br.com.sistemavendas.entity.Produto;
import br.com.sistemavendas.entity.StatusVenda;
import br.com.sistemavendas.entity.Venda;
import br.com.sistemavendas.repository.ProdutoRepository;
import br.com.sistemavendas.repository.VendaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.List;

@ApplicationScoped
public class VendaService {


    @Inject
    VendaRepository vendaRepository;

    @Inject
    ProdutoRepository produtoRepository;

    @Transactional
    public Venda registrarVenda(Long produtoId, BigDecimal valor){

        Produto produto = produtoRepository.findById(produtoId);

        if (produto == null){
            throw new IllegalArgumentException("Produto não encontrado");
        }

        if (valor == null || valor.compareTo(BigDecimal.ZERO)<= 0){
            throw new IllegalArgumentException("O valor da venda deve ser maior que zero.");


        }

        Venda venda = new Venda();

        venda.produto = produto;
        venda.valor = valor;
        venda.status = StatusVenda.ATIVA;
        venda.data = java.time.LocalDate.now();

        vendaRepository.persist(venda);

        return venda;
    }

    public List<Venda> listarTodas() {
        return vendaRepository.listAll();
    }

    public Venda buscarPorId(Long id) {
        return vendaRepository.findById(id);
    }

    @Transactional
    public Venda cancelarVenda(Long id) {

        Venda venda = vendaRepository.findById(id);

        if (venda == null) {
            throw new IllegalArgumentException("Venda não encontrada.");
        }

        if (venda.status == StatusVenda.CANCELADA) {
            throw new IllegalArgumentException("A venda já está cancelada.");
        }

        venda.status = StatusVenda.CANCELADA;

        return venda;
    }
}
