package com.br.challengebrq.treinamentocaio.produto;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Data
public class ProdutoAtualizacao {

    @NotNull
    public String id;

    public String nome;

    public String descricao;

    public String marca;

    public Double preco;

    public LocalDateTime dataAtualizacao = LocalDateTime.parse(LocalDateTime.now().toString());

    @NotNull
    public boolean ativo = true;

    @NotNull
    public boolean ofertado;

    public Integer porcentagemOferta = 0;

}
