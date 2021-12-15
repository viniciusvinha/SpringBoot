package br.org.generation.lojadegames.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.lojadegames.model.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository <ProdutoModel, Long> {

	public List<ProdutoModel> findAllByTituloContainingIgnoreCase (String titulo);
	
	public List<ProdutoModel> findAllByPrecoGreaterThanOrderByPreco (BigDecimal preco);
	
	public List<ProdutoModel> findAllByPrecoLessThanOrderByPrecoDesc (BigDecimal preco);
}