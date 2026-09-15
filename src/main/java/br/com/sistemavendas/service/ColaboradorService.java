package br.com.sistemavendas.service;

import br.com.sistemavendas.entity.Colaborador;
import br.com.sistemavendas.repository.ColaboradorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ColaboradorService {


    @Inject
    ColaboradorRepository colaboradorRepository;

    public void salvar(Colaborador colaborador){
        colaboradorRepository.persist(colaborador);
    }

    public List<Colaborador> listarTodos(){
        return colaboradorRepository.listAll();
    }

}
