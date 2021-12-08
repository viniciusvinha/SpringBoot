package br.org.generation.famaciadobem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.famaciadobem.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	public List<Categoria>findAllByCategoriaContainingIgnoreCase (String categoria);
}
