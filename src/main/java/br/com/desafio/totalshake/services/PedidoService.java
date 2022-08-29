package br.com.desafio.totalshake.services;

import br.com.desafio.totalshake.models.ItemPedido;
import br.com.desafio.totalshake.models.Pedido;
import br.com.desafio.totalshake.models.dtos.ItemPedidoDTO;
import br.com.desafio.totalshake.models.dtos.PedidoDTO;
import br.com.desafio.totalshake.models.enuns.Status;
import br.com.desafio.totalshake.repositories.ItemPedidoRepository;
import br.com.desafio.totalshake.repositories.PedidoRepository;
import br.com.desafio.totalshake.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Transactional
    public Page<PedidoDTO> findAll(Pageable pageable){
        Page<Pedido> list = pedidoRepository.findAll(pageable);
        return list.map(pedido -> new PedidoDTO(pedido, pedido.getItensPedidoList()));
    }

    @Transactional
    public PedidoDTO findById(Long id){
        Optional<Pedido> obj = pedidoRepository.findById(id);
        Pedido entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new PedidoDTO(entity, entity.getItensPedidoList());
    }

    @Transactional
    public PedidoDTO insert(PedidoDTO dto){
        Pedido pedido = new Pedido();
        List<ItemPedido> list = convertDtoToEntity(pedido, dto);
        list.forEach(itemPedido -> itemPedidoRepository.save(itemPedido));
        pedido.setItensPedidoList(list);
        pedido = pedidoRepository.save(pedido);
        return new PedidoDTO(pedido, pedido.getItensPedidoList());
    }

    private List<ItemPedido> convertDtoToEntity(Pedido entity, PedidoDTO pedidoDTO){
        List<ItemPedido> itemPedidos = new ArrayList<>();
        for (ItemPedidoDTO itemPedidoDTO : pedidoDTO.getItensPedidoList()){
            itemPedidos.add(new ItemPedido(
                    itemPedidoDTO.getId(),
                    itemPedidoDTO.getQuantidade(),
                    itemPedidoDTO.getDescricao(),
                    entity
            ));
        }
        return itemPedidos;
    }

}
