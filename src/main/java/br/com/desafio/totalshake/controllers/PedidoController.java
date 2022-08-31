package br.com.desafio.totalshake.controllers;

import br.com.desafio.totalshake.models.dtos.PedidoDTO;
import br.com.desafio.totalshake.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "pedidos")
public class PedidoController {


    @Autowired
    private PedidoService service;

    @GetMapping
    public ResponseEntity<Page<PedidoDTO>> getAllPedidos(Pageable pageable){
        Page<PedidoDTO> pedidoList = service.findAll(pageable);
        return ResponseEntity.ok().body(pedidoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> getPedidoById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> updatePedido(@PathVariable Long id, @RequestBody PedidoDTO dto){
        return ResponseEntity.ok().body(service.update(id, dto));
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> savePedido(@RequestBody PedidoDTO pedidoDTO){
        return ResponseEntity.status(200).body(service.insert(pedidoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PedidoDTO> deletePedido(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
