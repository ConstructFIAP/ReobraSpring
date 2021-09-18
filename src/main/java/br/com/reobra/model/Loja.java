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
@Table(name="reobra_loja")
public class Loja {
    @Id
    @SequenceGenerator(name = "seqLoja", sequenceName = "seqLoja", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "seqLoja")
    @Column(name="id")
    private Long id;

    @Column(name="contato_id")
    private int razao_social;

    @Column(name = "endereco_id")
    private int endereco_id;

    @Column(name="nome")
    private String nome;



}
