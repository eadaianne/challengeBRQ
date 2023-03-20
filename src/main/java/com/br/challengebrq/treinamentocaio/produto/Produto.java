package com.br.challengebrq.treinamentocaio.produto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
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

    public void atualizarInformacoes(ProdutoAtualizacao produtoAtualizado) {

        if (produtoAtualizado.nome != null) {
            this.nome = produtoAtualizado.nome;
        }

        if (produtoAtualizado.descricao != null) {
            this.descricao = produtoAtualizado.descricao;
        }

        if (produtoAtualizado.marca != null) {
            this.marca = produtoAtualizado.marca;
        }

        if (produtoAtualizado.preco != null) {
            this.preco = produtoAtualizado.preco;
        }

        this.ativo = produtoAtualizado.ativo;

        this.ofertado = produtoAtualizado.ofertado;

        if (produtoAtualizado.porcentagemOferta != null) {
            this.porcentagemOferta = produtoAtualizado.porcentagemOferta;
        }

    }
}
