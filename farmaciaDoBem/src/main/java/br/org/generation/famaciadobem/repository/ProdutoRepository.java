package br.org.generation.famaciadobem.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.org.generation.famaciadobem.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	//para fazer uma busca de um valor maior que o que foi digitado em uma lista crescente
	
	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);
	
	public List<Produto> findByPrecoGreaterThanOrderByPreco(BigDecimal preco);
	
	//para fazer uma busca de um valor menor que o que foi digitado em uma lista decrescente
	
	public List<Produto> findByPrecoLessThanOrderbyPrecoDesc(BigDecimal preco);
	
	public List<Produto> findByNomeAndLaboratorio(String nome, String laboratorio);

	/**
	 *  Método Personalizado - Buscar por Nome do Produto ou pelo Nome do Laboratório
	 *  
	 *  MySQL: select * from tb_produtos where nome = "produto" or laboratorio = "laboratorio";
	 */
	
	public List <Produto> findByNomeOrLaboratorio(String nome, String laboratorio);
	
	@Query(value = "select * from tb_produtos where preco between :inicio and :fim", nativeQuery = true)
	public List <Produto> buscarProdutosEntre(@Param("inicio") BigDecimal inicio, @Param("fim") BigDecimal fim);
	
	//Para buscar um booleano positivo
	public List <Produto> findByEntregaTrue();
	
	//Para buscar um boolean negativo
	public List <Produto> findByEntregaFalse();
}
