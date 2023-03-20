package com.br.challengebrq.treinamentocaio.produto;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Data
public class ProdutoAtualizacao {

    public String nome;

    public String descricao;

    public String marca;

    public Double preco;

    public LocalDateTime dataAtualizacao = LocalDateTime.parse(LocalDateTime.now().toString());
    public boolean ativo = true;

    public boolean ofertado;

    public Integer porcentagemOferta = 0;

}
