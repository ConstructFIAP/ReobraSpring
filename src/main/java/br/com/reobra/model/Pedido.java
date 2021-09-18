package br.com.reobra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="reobra_pedido")
public class Pedido {

    @Id
    @SequenceGenerator(name = "seqPedido", sequenceName = "seqPedido", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "seqPedido")
    @Column(name="id")
    private Long id;

    @Column(name="data_pedido")
    private String data_pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_loja")
    private Loja loja;

    @OneToMany(mappedBy = "pedido")
    private List<DetalhePedido> detalhesPedido;

}
