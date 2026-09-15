package br.com.sistemavendas.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public BigDecimal valor;

    public LocalDate data;

    @Enumerated(EnumType.STRING)
    public StatusVenda status;


    @ManyToOne
    @JoinColumn(name = "produto_id")
    public Produto produto;


}
