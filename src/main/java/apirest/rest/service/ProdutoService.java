package apirest.rest.service;

import apirest.rest.model.Produtos;
import apirest.rest.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public Produtos criarProduto(Produtos produtos) {
        return produtoRepository.save(produtos);
    }

    public List<Produtos> listarTodosProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produtos> recuperarProduto(long id) {
        return produtoRepository.findById(id);
    }

    public Produtos atualizarProduto(Long id, Produtos produtoAtualizado) {
        Optional<Produtos> produtoOptional = produtoRepository.findById(id);

        if (produtoOptional.isPresent()) {
            Produtos produtoExistente = produtoOptional.get();


            produtoExistente.setProduto(produtoAtualizado.getProduto());


            return produtoRepository.save(produtoExistente);
        }

        return null;
    }
}


