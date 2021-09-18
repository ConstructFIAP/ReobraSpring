package br.com.reobra.controller;


import br.com.reobra.model.Produto;
import br.com.reobra.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/reobra")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
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

    @RequestMapping(value = "/produto/imagem/{id}", method = RequestMethod.GET, produces = "image/jpg")
    public @ResponseBody byte[] getImagem(@PathVariable("id") long id)  {
        try {
            String nomeArquivo = produtoRepository.getById(id).getCaminho_imagem();
            InputStream is = this.getClass().getResourceAsStream("/" + nomeArquivo);
            BufferedImage img = ImageIO.read(is);
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", bao);
            return bao.toByteArray();
        } catch (IOException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
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

}
