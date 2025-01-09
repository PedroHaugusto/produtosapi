package io.github.cursodsousa.produtosapi.controller;

import io.github.cursodsousa.produtosapi.model.Produto;
import io.github.cursodsousa.produtosapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public void salvar(@RequestBody Produto produto){
        produtoRepository.save(produto);
    }

    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable("id") UUID id){
        return produtoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable("id") UUID id,
                          @RequestBody Produto produto){

        produto.setId(id);
        produtoRepository.save(produto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") UUID id){
        produtoRepository.deleteById(id);
    }

    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome) {
        return produtoRepository.findByNome(nome);
    }
}
