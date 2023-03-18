package com.br.challengebrq.treinamentocaio.model.controllers;

import com.br.challengebrq.treinamentocaio.dataprovider.repository.RepositoryProduto;
import com.br.challengebrq.treinamentocaio.produto.Produto;
import com.br.challengebrq.treinamentocaio.produto.ProdutoAtualizacao;
import com.br.challengebrq.treinamentocaio.produto.ProdutoResumo;
import com.br.challengebrq.treinamentocaio.produto.produtoMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @Transactional
    public Produto cadastrar(@RequestBody Produto produto) {
        return repositoryProduto.save(produto);
    }

    @GetMapping
    public List<ProdutoResumo> listar() {
        List<Produto> produtos = repositoryProduto.findAll();
        return produtoMapper.toDtoResumo(produtos);
    }

    @GetMapping("/{id}")
    public Produto detalharProduto(@PathVariable String id){
        return repositoryProduto.findById(id).orElseThrow(() -> new RuntimeException("Produto não existe!"));
        }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody ProdutoAtualizacao produtoAtualizado){
        var produto = repositoryProduto.getReferenceById(produtoAtualizado.id);
        produto.atualizarInformacoes(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable String id){
        repositoryProduto.findById(id);
        repositoryProduto.deleteById(id);
    }
}

