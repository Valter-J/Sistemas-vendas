package br.com.sistemavendas.repository;

import br.com.sistemavendas.entity.Colaborador;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ColaboradorRepository implements PanacheRepository<Colaborador> {
}
