package com.sesi.projeto.controllers;

import java.util.List;

import com.sesi.projeto.service.ServiceHttpProduto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sesi.projeto.dto.ProdutoDTO;
import com.sesi.projeto.entities.Produto;
import com.sesi.projeto.repositories.ProdutoRepository;

@RestController
@RequestMapping("produto")
public class ProdutoController {

	@Autowired
	ProdutoRepository repo;

	@Autowired
	ServiceHttpProduto serviceHttpProduto;

	@GetMapping
	public ResponseEntity<List<Produto>> mostrarTodos() {
		return ResponseEntity.ok(serviceHttpProduto.BuscarTodosProdutos());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> mostrarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(serviceHttpProduto.BuscarProdutoId(id));
	}
	
	@PostMapping("/new")
	public ResponseEntity<Produto> criar(@RequestBody @Valid ProdutoDTO dto){
		Produto prod = new Produto(dto);
		return ResponseEntity.ok(serviceHttpProduto.NovoProduto(prod));
	}

	@PutMapping("/updt/{id}")
	public ResponseEntity<Produto> AtlzProduto(@PathVariable Long id, @RequestBody @Valid ProdutoDTO dto){
		try {
		return ResponseEntity.ok(serviceHttpProduto.atualizarPorId(id, dto));
		} catch (RuntimeException e){
			return  ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/dell/{id}")
	public ResponseEntity DeletarProduto(@PathVariable Long id){
		try {
			serviceHttpProduto.DeleteProduto(id);
			return ResponseEntity.ok().build();
		} catch (RuntimeException e){
			return  ResponseEntity.notFound().build();
		}
	}

}
