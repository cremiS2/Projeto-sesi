package com.sesi.projeto.repositories;

import com.sesi.projeto.entities.Pedido;
import com.sesi.projeto.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
