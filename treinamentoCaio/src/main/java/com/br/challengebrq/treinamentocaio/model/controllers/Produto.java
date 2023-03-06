package com.br.challengebrq.treinamentocaio.model.controllers;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private LocalDateTime dataCadastro = LocalDateTime.parse(LocalDateTime.now().toString());

    private String dataAtualizacao;

    @Column(nullable = false)
    private boolean ativo = true;

    @Column(nullable = false)
    private boolean ofertado;

    @Column(nullable = false)
    private Integer porcentagemOferta = 0;
}
