package br.com.sistemavendas.entity;

import jakarta.persistence.*;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public String nome;

    public Double preco;

    @ManyToMany
    @JoinColumn(name = "colaborador_id")
    public Colaborador colaborador;


}
