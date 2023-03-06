package com.br.challengebrq.treinamentocaio.model.controllers;

import com.br.challengebrq.treinamentocaio.dataprovider.repository.RepositoryProduto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challengebrq/v1/produtos")
public class controllerProdutos {

    private final RepositoryProduto repositoryProduto;

    public controllerProdutos(RepositoryProduto repositoryProduto) {
        this.repositoryProduto = repositoryProduto;
    }

    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto) {
        return repositoryProduto.save(produto);
    }

    @GetMapping
    public List<Produto> listar() {
        return repositoryProduto.findAll();
    }
}
