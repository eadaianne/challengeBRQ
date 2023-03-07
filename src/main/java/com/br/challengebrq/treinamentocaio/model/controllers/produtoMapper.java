package com.br.challengebrq.treinamentocaio.model.controllers;
//
//import org.springframework.stereotype.Component;
//
import java.util.ArrayList;
import java.util.List;
//
//@Component
//public class produtoMapper {
//    public List<ProdutoResumo> toDtoResumo(List<Produto> produtos) {
//        List<ProdutoResumo> produtosResumo = new ArrayList<>();
//        for (Produto produto : produtos) {
//            ProdutoResumo produtoResumo = new ProdutoResumo();
//            produtoResumo.setId(produto.getId());
//            produtoResumo.setNome(produto.getNome());
//            produtoResumo.setMarca(produto.getMarca());
//            produtoResumo.setPreco(produto.getPreco());
//            produtosResumo.add(produtoResumo);
//        }
//        return produtosResumo;
//    }
//}

public class produtoMapper {
    private produtoMapper(){}
    public static List<ProdutoResumo> toDtoResumo(List<Produto> produtos) {
        List<ProdutoResumo> produtosResumo = new ArrayList<>();
        for (Produto produto : produtos) {
            ProdutoResumo produtoResumo = new ProdutoResumo();
            produtoResumo.setId(produto.getId());
            produtoResumo.setNome(produto.getNome());
            produtoResumo.setMarca(produto.getMarca());
            produtoResumo.setPreco(produto.getPreco());
            produtosResumo.add(produtoResumo);
        }
        return produtosResumo;
    }
}
