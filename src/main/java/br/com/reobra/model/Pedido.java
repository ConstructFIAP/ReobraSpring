package br.com.reobra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="reobra_simples_pedido")
public class Pedido {

    @Id
    @SequenceGenerator(name = "seqPedido", sequenceName = "seqPedido", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "seqPedido")
    @Column(name="id")
    private Long id;

    @Column(name="data_pedido")
    private String data_pedido;

}
