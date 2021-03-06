package br.com.reobra.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "reobra_loja")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Loja {

    @Id
    @SequenceGenerator(name = "seqLoja", sequenceName = "seqLoja", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "seqLoja")
    @Column(name = "id")
    private Long id;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "loja")
    @JsonIgnore
    private List<ProdutoEstoque> produtosEstoque;

}
