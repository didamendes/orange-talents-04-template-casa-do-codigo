package br.com.zupacademy.diogo.casadocodigo.cliente;

import br.com.zupacademy.diogo.casadocodigo.pais_estado.EstadoRepository;
import br.com.zupacademy.diogo.casadocodigo.pais_estado.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<ClienteResponse> salvar(@RequestBody @Valid ClienteRequest clienteRequest) {
        Cliente cliente = clienteRequest.converter(paisRepository, estadoRepository);
        clienteRepository.save(cliente);

        return ResponseEntity.ok(new ClienteResponse(cliente));
    }

}
