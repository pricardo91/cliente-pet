package br.com.petz.clientepet.cliente.application.service;

import br.com.petz.clientepet.cliente.application.api.*;
import br.com.petz.clientepet.cliente.domain.Cliente;
import br.com.petz.clientepet.cliente.infrastructure.ClienteInfraRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
        List<Cliente> clientes = clienteRepository.buscaTodosClientes();
        log.info("[end] {} - buscaTodosClientes", getClass().getSimpleName());
        return ClienteListResponse.converte(clientes);
    }

    @Override
    public ClienteDetalhadoResponse buscaCliente(UUID idCliente) {
        log.info("[start] {} - buscaCliente", getClass().getSimpleName());
        log.info("[idCliente] Service - {}", idCliente);
        Cliente cliente = clienteRepository.buscaClientePorId(idCliente);
        log.info("[end] {} - buscaCliente", getClass().getSimpleName());
        return new ClienteDetalhadoResponse(cliente);
    }

    @Override
    public void deletaClientePorId(UUID idCliente) {
        log.info("[start] {} - deletaClientePorId", getClass().getSimpleName());
        Cliente cliente = clienteRepository.buscaClientePorId(idCliente);
        clienteRepository.deletaCliente(cliente);
        log.info("[end] {} - deletaClientePorId", getClass().getSimpleName());
    }

    @Override
    public void patchAtualizaCliente(UUID idCliente, ClienteUpdateRequest clienteUpdateRequest) {
        log.info("[start] {} - patchAtualizaCliente", getClass().getSimpleName());
        Cliente cliente = clienteRepository.buscaClientePorId(idCliente);
        cliente.altera(clienteUpdateRequest);
        clienteRepository.salva(cliente);
        log.info("[cliente] - {}", cliente.getIdCliente());
        log.info("[end] {} - patchAtualizaCliente", getClass().getSimpleName());
    }
}
