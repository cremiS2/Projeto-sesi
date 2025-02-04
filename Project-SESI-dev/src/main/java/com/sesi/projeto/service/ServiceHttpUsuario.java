package com.sesi.projeto.service;

import com.sesi.projeto.dto.UsuarioDTO;
import com.sesi.projeto.entities.Usuario;
import com.sesi.projeto.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceHttpUsuario {

    @Autowired
    UsuarioRepository usuarioRepository;


    public List<Usuario> BuscarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> BuscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario NovoUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarPorId(Long id, UsuarioDTO dto) {
        return usuarioRepository.findById(id).map(usuario -> {
            if (dto.name() != null) usuario.setName(dto.name());
            if (dto.email() != null) usuario.setEmail(dto.email());
            if (dto.senha() != null) usuario.setSenha(dto.senha());
            if (dto.telefone() != null) usuario.setTelefone(dto.telefone());
            if (dto.role() != null) usuario.setRole(dto.role());
            return usuarioRepository.save(usuario);
        }).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public void  DeleteUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

}
