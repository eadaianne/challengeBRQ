package com.br.challengebrq.treinamentocaio.produto;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProdutoResumo {

    private String id;

    private String nome;

    private String marca;

    private Double preco;

}
