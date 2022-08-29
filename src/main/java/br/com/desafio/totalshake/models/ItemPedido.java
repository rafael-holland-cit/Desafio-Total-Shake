package br.com.desafio.totalshake.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer quantidade;

    @NotNull
    private String descricao;


    @ManyToOne
    @JoinColumn(name = "fk_pedido")
    private Pedido pedido;

    public ItemPedido(Long id, Integer quantidade, String descricao, Pedido pedido) {
        this.id = id;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.pedido = pedido;
    }

    public ItemPedido(){}
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
