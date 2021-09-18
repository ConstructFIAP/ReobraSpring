package br.com.reobra.controller;


import br.com.reobra.model.Loja;
import br.com.reobra.model.Produto;
import br.com.reobra.model.ProdutoEstoque;
import br.com.reobra.repository.LojaRepository;
import br.com.reobra.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reobra")
public class ProdutoController {

    private ProdutoRepository produtoRepository;
    private LojaRepository lojaRepository;

    public ProdutoController(ProdutoRepository produtoRepository, LojaRepository lojaRepository) {
        this.produtoRepository = produtoRepository;
        this.lojaRepository = lojaRepository;
    }

    @GetMapping("/produto")
    public ResponseEntity<List<Produto>> listarProdutos(){
        List<Produto> produtos = produtoRepository.findAll();
        return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<Produto> getProduto(@PathVariable("id") long id){
        Produto produto = produtoRepository.getById(id);
        return new ResponseEntity<Produto>(produto, HttpStatus.OK);
    }

    @PostMapping("/produto")
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
        Produto novoProduto = produtoRepository.save(produto);
        return new ResponseEntity<Produto>(novoProduto, HttpStatus.CREATED);
    }

    @DeleteMapping("/produto/{id}")
    public ResponseEntity<?> excluirProduto(@PathVariable("id") long id) {
        produtoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/produto/loja/{idLoja}")
    public ResponseEntity<List<ProdutoEstoque>> getProdutosDeLoja(@PathVariable("idLoja") long idLoja){
        Loja loja = lojaRepository.getById(idLoja);
        List<ProdutoEstoque> produtos = loja.getProdutosEstoque();
        return new ResponseEntity<List<ProdutoEstoque>>(produtos, HttpStatus.OK);
    }

}
