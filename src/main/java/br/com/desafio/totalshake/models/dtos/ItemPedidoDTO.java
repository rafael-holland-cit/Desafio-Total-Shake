package br.com.desafio.totalshake.models.dtos;

import br.com.desafio.totalshake.models.ItemPedido;
import br.com.desafio.totalshake.models.Pedido;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ItemPedidoDTO implements Serializable {

    private Long id;
    private Integer quantidade;
    private String descricao;


    public ItemPedidoDTO(Long id, Integer quantidade, String descricao) {
        this.id = id;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }

    public ItemPedidoDTO(ItemPedido entity){
        this.id = entity.getId();
        this.quantidade = entity.getQuantidade();
        this.descricao = entity.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }


    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
