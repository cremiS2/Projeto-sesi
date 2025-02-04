package com.sesi.projeto.service;

import com.sesi.projeto.entities.ItemDoPedido;
import com.sesi.projeto.repositories.ItemDoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceHttpItemPedido {

    @Autowired
    ItemDoPedidoRepository itemDoPedidoRepository;


}
