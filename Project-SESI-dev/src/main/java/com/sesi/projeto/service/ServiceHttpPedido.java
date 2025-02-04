package com.sesi.projeto.service;

import com.sesi.projeto.dto.PedidoDTO;
import com.sesi.projeto.entities.Pedido;
import com.sesi.projeto.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceHttpPedido {

    @Autowired
    PedidoRepository pedidoRepository;



    public List<Pedido> BuscarTodosPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> BuscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedido NovoPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido atualizarPedidoPorId(Long id, PedidoDTO dto) {
        return pedidoRepository.findById(id).map(pedido -> {
            if (dto.momento() != null) pedido.setMomento(dto.momento());
            if (dto.status()!= null) pedido.setStatus(dto.status());
            return pedidoRepository.save(pedido);
        }).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public void  DeletePedido(Long id){
        pedidoRepository.deleteById(id);
    }

}
