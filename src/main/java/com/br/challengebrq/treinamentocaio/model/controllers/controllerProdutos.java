package com.br.challengebrq.treinamentocaio.model.controllers;

import com.br.challengebrq.treinamentocaio.dataprovider.repository.RepositoryProduto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challengebrq/v1/produtos")
public class controllerProdutos {

    private final RepositoryProduto repositoryProduto;
    //  private final produtoMapper produtoMapper;

    public controllerProdutos(RepositoryProduto repositoryProduto) {
        this.repositoryProduto = repositoryProduto;
//        this.produtoMapper = produtoMapper;
    }

    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto) {
        return repositoryProduto.save(produto);
    }

    @GetMapping
    public List<ProdutoResumo> listar() {
        List<Produto> produtos = repositoryProduto.findAll();
        return produtoMapper.toDtoResumo(produtos);
    }
}
