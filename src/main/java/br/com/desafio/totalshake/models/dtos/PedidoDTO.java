package br.com.desafio.totalshake.models.dtos;

import br.com.desafio.totalshake.models.ItemPedido;
import br.com.desafio.totalshake.models.Pedido;
import br.com.desafio.totalshake.models.enuns.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.bytebuddy.asm.Advice;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidoDTO {


    private Long id;
    private LocalDateTime dataHora;
    private Status status;
    @JsonProperty("itens")
    private List<ItemPedidoDTO> itensPedidoList = new ArrayList<>();

    public PedidoDTO(Long id, LocalDateTime dataHora, Status status, List<ItemPedidoDTO> itensPedidoList) {
        this.id = id;
        this.dataHora = dataHora;
        this.status = status;
        this.itensPedidoList = itensPedidoList;
    }

    public PedidoDTO(){}

    public PedidoDTO(Pedido pedido){
        this.id = pedido.getId();
        this.dataHora = pedido.getDataHora();
        this.status = pedido.getStatus();
    }

    public PedidoDTO(Pedido entity, List<ItemPedido> itemPedidos){
        this(entity);
        itemPedidos.forEach(itemPedido -> this.itensPedidoList.add(new ItemPedidoDTO(itemPedido)));
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

    public List<ItemPedidoDTO> getItensPedidoList() {
        return itensPedidoList;
    }

    public void setItensPedidoList(List<ItemPedidoDTO> itensPedidoList) {
        this.itensPedidoList = itensPedidoList;
    }
}
