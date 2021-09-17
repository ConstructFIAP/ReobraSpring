package br.com.reobra.controller;


import br.com.reobra.model.Loja;
import br.com.reobra.repository.LojaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reobra")
public class LojaController {
    private LojaRepository lojaRepository;

    public LojaController(LojaRepository lojaRepository) {
        this.lojaRepository = lojaRepository;
    }

    @GetMapping("/loja")
    public ResponseEntity<List<Loja>> listarLojas(){
        List<Loja> lojas = lojaRepository.findAll();
        return new ResponseEntity<List<Loja>>(lojas, HttpStatus.OK);
    }

    @PostMapping("/loja")
    public ResponseEntity<Loja> salvarLoja(@RequestBody Loja loja) {
        Loja novaLoja = lojaRepository.save(loja);
        return new ResponseEntity<Loja>(novaLoja, HttpStatus.CREATED);
    }

    @DeleteMapping("/loja/{id}")
    public ResponseEntity<?> excluirLojas(@PathVariable("id") long id) {
        lojaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
