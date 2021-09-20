package br.com.reobra.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="reobra_simples_produto")
public class Produto {

    @Id
    @SequenceGenerator(name = "seqProduto", sequenceName = "seqProduto", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "seqProduto")
    @Column(name="id")
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(name="descricao")
    private String descricao;

    @Column(name="preco")
    private BigDecimal preco;

    @Column(name="caminho_imagem")
    private String caminho_imagem;

    @Column(name="estoque")
    private int estoque;

}
