package br.org.generation.lojadegames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.lojadegames.model.CategoriaModel;

@Repository
public interface CategoriaRepository extends JpaRepository <CategoriaModel, Long> {

	public List<CategoriaModel> findAllByTipoContainingIgnoreCase (String tipo);
}
