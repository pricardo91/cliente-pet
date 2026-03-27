package br.com.petz.clientepet.cliente.application.service;

import br.com.petz.clientepet.cliente.application.api.ClienteListResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteResponse;
import br.com.petz.clientepet.cliente.domain.Cliente;
import br.com.petz.clientepet.cliente.infrastructure.ClienteInfraRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {
    private final ClienteInfraRepository clienteRepository;

    @Override
    public ClienteResponse criarCliente(ClienteRequest clienteRequest) {
        log.info("[start] {} - criarCliente", getClass().getSimpleName());

        Cliente cliente = clienteRepository.salva(new Cliente(clienteRequest));

        log.info("[end] {} - criarCliente", getClass().getSimpleName());
        return ClienteResponse.builder()
                .idCliente(cliente.getIdCliente())
                .build();
    }

    @Override
    public List<ClienteListResponse> buscaTodosClientes() {
        log.info("[start] {} - buscaTodosClientes", getClass().getSimpleName());
        List<ClienteListResponse> listaClientes = clienteRepository.buscaTodosCliente();
        log.info("[end] {} - buscaTodosClientes", getClass().getSimpleName());
        return listaClientes;
    }
}
