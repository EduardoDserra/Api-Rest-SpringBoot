package apirest.rest.controller;

import apirest.rest.model.Produtos;
import apirest.rest.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import apirest.rest.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/Produto")
public class Controller {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produtos> criarProduto(@RequestBody Produtos produto) {
        Produtos novoProduto = produtoService.criarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produtos>> recuperarProduto(@PathVariable Long id) {
        Optional<Produtos> produto =  produtoService.recuperarProduto(id);
        return ResponseEntity.ok(produto);
    }

    @GetMapping
    public ResponseEntity<List<Produtos>> listarTodosProdutos() {
        List<Produtos> produtos = produtoService.listarTodosProdutos();
        return ResponseEntity.ok(produtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produtos> atualizarProduto(@PathVariable Long id, @RequestBody Produtos produtoAtualizado) {
        Produtos produto = produtoService.atualizarProduto(id, produtoAtualizado);
        return ResponseEntity.ok(produto);
    }

}
