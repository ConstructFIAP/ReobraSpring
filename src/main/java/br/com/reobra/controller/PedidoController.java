package br.com.reobra.controller;


import br.com.reobra.model.Pedido;
import br.com.reobra.repository.PedidoRepository;
import br.com.reobra.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reobra")
public class PedidoController {
    private PedidoRepository pedidoRepository;

    public PedidoController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping("/pedido")
    public ResponseEntity<List<Pedido>> listarPedidos(){
        List<Pedido> pedidos = pedidoRepository.findAll();
        return new ResponseEntity<List<Pedido>>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/pedido/{id}")
    public ResponseEntity<Pedido> getPedido(@PathVariable("id") long id){
        Pedido pedido = pedidoRepository.getById(id);
        return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
    }

    @PostMapping("/pedido")
    public ResponseEntity<Pedido> salvarPedido(@RequestBody Pedido pedido) {
        Pedido novoPedido = pedidoRepository.save(pedido);
        return new ResponseEntity<Pedido>(novoPedido, HttpStatus.CREATED);
    }

    @GetMapping("/pedidoTeste")
    public void teste() {
        Pedido pedido = pedidoRepository.getById(1L);
        PedidoService pedidoService = new PedidoService();
        pedidoService.salvarPedido(pedido);
    }

}
