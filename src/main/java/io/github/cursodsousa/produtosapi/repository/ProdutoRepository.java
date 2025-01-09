package io.github.cursodsousa.produtosapi.repository;

import io.github.cursodsousa.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

    List<Produto> findByNome(String nome);
}
