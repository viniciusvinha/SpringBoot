package br.org.generation.lojadegames.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.lojadegames.model.ProdutoModel;
import br.org.generation.lojadegames.repository.CategoriaRepository;
import br.org.generation.lojadegames.repository.ProdutoRepository;

@RestController
@RequestMapping ("/produtos")
@CrossOrigin ("*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity <List<ProdutoModel>> getAll() {
		
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> getById (@PathVariable long id) {
		
		return repository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity <List<ProdutoModel>> getByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@GetMapping("/preco_maior/{preco}")
	public ResponseEntity<List<ProdutoModel>> getPrecoMaiorQue(@PathVariable BigDecimal preco){
		return ResponseEntity.ok(repository.findAllByPrecoGreaterThanOrderByPreco(preco));
	}
	
	@GetMapping("/preco_menor/{preco}")
	public ResponseEntity<List<ProdutoModel>> getPrecoMenorQue(@PathVariable BigDecimal preco){
		return ResponseEntity.ok(repository.findAllByPrecoLessThanOrderByPrecoDesc(preco));
	}
	
	@PostMapping
	public ResponseEntity<ProdutoModel> post (@Valid @RequestBody ProdutoModel produto) {
		return categoriaRepository.findById(produto.getCategoria().getId())
				.map(res -> ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping
	public ResponseEntity<ProdutoModel> put (@Valid @RequestBody ProdutoModel produto) {
		
		return repository.findById(produto.getId())
				.map(resposta -> {
					return ResponseEntity.ok().body(repository.save(produto));
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id})")
	public ResponseEntity<?> delete (@PathVariable Long id){
		return repository.findById(id)
				.map(res -> {
					repository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());	
}
	
}
