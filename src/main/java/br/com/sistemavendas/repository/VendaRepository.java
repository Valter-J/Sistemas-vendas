package br.com.sistemavendas.repository;


import br.com.sistemavendas.entity.StatusVenda;
import br.com.sistemavendas.entity.Venda;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class VendaRepository implements PanacheRepository<Venda> {

    public List<Venda> listarPorPeriodo(
            LocalDate dataInicial,
            LocalDate dataFinal
    ) {
        return find(
                "data >= ?1 and data <= ?2",
                dataInicial,
                dataFinal
        ).list();
    }

    public List<Venda> listarAtivas() {
        return find(
                "status",
                StatusVenda.ATIVA
        ).list();
    }
}
