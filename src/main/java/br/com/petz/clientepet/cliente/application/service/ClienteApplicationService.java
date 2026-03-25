package br.com.petz.clientepet.cliente.application.service;

import br.com.petz.clientepet.cliente.application.api.ClienteRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteResponse;
import br.com.petz.clientepet.cliente.domain.Cliente;
import br.com.petz.clientepet.cliente.infrastructure.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClienteApplicationService implements ClienteService {
     private ClienteRepository clienteRepository;

    @Override
    public ClienteResponse criarCliente(ClienteRequest clienteRequest) {
        log.info("[start] {} - criarCliente", getClass().getSimpleName());
        Cliente cliente = clienteRepository.save(new Cliente(clienteRequest));
        log.info("[end] {} - criarCliente", getClass().getSimpleName());
        return null;
    }
}
