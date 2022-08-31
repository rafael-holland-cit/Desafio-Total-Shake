package br.com.desafio.totalshake.models;

import br.com.desafio.totalshake.models.enuns.Status;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itensPedidoList;

    public Pedido(){
        this.dataHora = LocalDateTime.now();
        this.status = Status.REALIZADO;
    }

    public Pedido(LocalDateTime dataHora, Status status, List<ItemPedido> itensPedidoList) {
        this.dataHora = dataHora;
        this.status = status;
        this.itensPedidoList = itensPedidoList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<ItemPedido> getItensPedidoList() {
        return itensPedidoList;
    }

    public void setItensPedidoList(List<ItemPedido> itensPedidoList) {
        this.itensPedidoList = itensPedidoList;
    }
}
