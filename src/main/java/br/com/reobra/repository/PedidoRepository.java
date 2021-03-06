package br.com.reobra.repository;

import br.com.reobra.model.Cliente;
import br.com.reobra.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    public List<Pedido> findByCliente(Cliente cliente);

}

