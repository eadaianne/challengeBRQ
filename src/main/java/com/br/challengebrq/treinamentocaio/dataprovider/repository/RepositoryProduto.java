package com.br.challengebrq.treinamentocaio.dataprovider.repository;

import com.br.challengebrq.treinamentocaio.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryProduto extends JpaRepository<Produto, String>
{
    Optional<Produto> findByNome(String nome);
}
