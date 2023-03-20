package com.br.challengebrq.treinamentocaio.model.controllers;

import com.br.challengebrq.treinamentocaio.dataprovider.repository.RepositoryProduto;
import com.br.challengebrq.treinamentocaio.produto.Produto;
import com.br.challengebrq.treinamentocaio.produto.ProdutoAtualizacao;
import com.br.challengebrq.treinamentocaio.produto.ProdutoResumo;
import com.br.challengebrq.treinamentocaio.produto.produtoMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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
    @Transactional
    public Produto cadastrar(@RequestBody Produto produto) {
        if (produto.getPreco() < 0) {
            throw new RuntimeException("Preço do produto inválido.");
        }
        repositoryProduto.findByNome(produto.getNome()).ifPresent(prod -> {throw new RuntimeException("Nome do produto duplicado.");});
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

    @PutMapping("/{id}")
    @Transactional
    public Produto atualizar(@PathVariable String id, @RequestBody ProdutoAtualizacao produtoAtualizado){
        var produto = repositoryProduto.findById(id).orElseThrow(() -> new RuntimeException("Produto não existe!"));
        produto.atualizarInformacoes(produtoAtualizado);
        repositoryProduto.save(produto);
        return produto;
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable String id){
        var produto = repositoryProduto.findById(id).orElseThrow(() -> new RuntimeException("Produto não existe!"));
        if(produto.isAtivo()) {
            throw new RuntimeException("Produto está ativo.");
        }
        repositoryProduto.deleteById(id);
    }

}