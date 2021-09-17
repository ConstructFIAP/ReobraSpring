package br.com.reobra.controller;


import br.com.reobra.model.Pedido;
import br.com.reobra.repository.PedidoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reobra")
public class PedidoController {
    private PedidoRepository pedidoRepository;

    public PedidoController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping("/pedido")
    public ResponseEntity<List<Pedido>> listarLojas(){
        List<Pedido> pedidos = pedidoRepository.findAll();
        return new ResponseEntity<List<Pedido>>(pedidos, HttpStatus.OK);
    }

    @PostMapping("/pedido")
    public ResponseEntity<Pedido> salvarLoja(@RequestBody Pedido pedido) {
        Pedido novoPedido = pedidoRepository.save(pedido);
        return new ResponseEntity<Pedido>(novoPedido, HttpStatus.CREATED);
    }

}
