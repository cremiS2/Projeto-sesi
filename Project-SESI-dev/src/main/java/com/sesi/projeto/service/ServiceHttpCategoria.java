package com.sesi.projeto.service;

import com.sesi.projeto.dto.CategoriaDTO;
import com.sesi.projeto.entities.Categoria;
import com.sesi.projeto.entities.Pagamento;
import com.sesi.projeto.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceHttpCategoria {

    @Autowired
    CategoriaRepository categoriaRepository;



    public List<Categoria> BuscarTodasCategorias() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> BuscarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria NovaCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria atualizarCategoriaPorId(Long id, CategoriaDTO dto) {
        return categoriaRepository.findById(id).map(categoria -> {
            if (dto.nome()!= null) categoria.setNome(dto.nome());
            return categoriaRepository.save(categoria);
        }).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    public void  DeletarCategoria(Long id){
        categoriaRepository.deleteById(id);
    }

}
