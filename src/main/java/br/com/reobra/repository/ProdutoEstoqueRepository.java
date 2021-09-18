package br.com.reobra.repository;

import br.com.reobra.model.Loja;
import br.com.reobra.model.Produto;
import br.com.reobra.model.ProdutoEstoque;
import br.com.reobra.model.ProdutoEstoqueId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoEstoqueRepository extends JpaRepository<ProdutoEstoque, ProdutoEstoqueId> {

    public ProdutoEstoque findByProdutoAndLoja(Produto produto, Loja loja);

}
