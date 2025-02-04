package com.sesi.projeto.entities;

import com.sesi.projeto.dto.ItemPedidoDTO;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_item_pedido")
public class ItemDoPedido {

	@EmbeddedId
	private ItemDoPedidoPK id = new ItemDoPedidoPK();

	private Double preco;
	private int quantidade;

	public ItemDoPedido(int quantidade, Double preco, Pedido pedido, Produto produto) {
		this.quantidade = quantidade;
		this.preco = preco;
		id.setPedido(pedido);
		id.setProduto(produto);
	}

	public ItemDoPedido() {
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return id.getPedido();
	}

	public void setPedido(Pedido pedido) {

		id.setPedido(pedido);
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}

	public void setProduto(Produto produto) {

		id.setProduto(produto);
	}
	
}
