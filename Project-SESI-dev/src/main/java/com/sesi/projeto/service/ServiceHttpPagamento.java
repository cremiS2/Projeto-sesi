package com.sesi.projeto.service;

import com.sesi.projeto.dto.PagamentoDTO;
import com.sesi.projeto.entities.Pagamento;
import com.sesi.projeto.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceHttpPagamento {

    @Autowired
    PagamentoRepository pagamentoRepository;



    public List<Pagamento> BuscarTodosPagamentos() {
        return pagamentoRepository.findAll();
    }

    public Optional<Pagamento> BuscarPagamentoPorId(Long id) {
        return pagamentoRepository.findById(id);
    }

    public Pagamento NovoPagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento atualizarPorId(Long id, PagamentoDTO dto) {
        return pagamentoRepository.findById(id).map(pagamento -> {
            if (dto.momento() != null) pagamento.setMomento(dto.momento());
            return pagamentoRepository.save(pagamento);
        }).orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
    }

    public void  DeletarPagamento(Long id){
        pagamentoRepository.deleteById(id);
    }

}
