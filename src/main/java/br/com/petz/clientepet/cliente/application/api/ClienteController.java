package br.com.petz.clientepet.cliente.application.api;

import br.com.petz.clientepet.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ClienteController implements ClienteAPI {

    private final ClienteService clienteService;

    @Override
    public ClienteResponse postCliente(ClienteRequest clienteRequest) {
        log.info("[inicia] {} - postCliente", getClass().getSimpleName());
        ClienteResponse clienteCriado = clienteService.criarCliente(clienteRequest);
        log.info("[finaliza] {} - postCliente", getClass().getSimpleName());
        return clienteCriado;
    }

    @Override
    public List<ClienteListResponse> getTodosClientes() {
        log.info("[inicia] {} - getTodosClientes", getClass().getSimpleName());
        List<ClienteListResponse> clientes = clienteService.buscaTodosClientes();
        log.info("[finaliza] {} - getTodosClientes", getClass().getSimpleName());
        return clientes;
    }

    @Override
    public ClienteDetalhadoResponse getClienteId(UUID idCliente) {
        log.info("[inicia] {} - getClienteId", getClass().getSimpleName());
        ClienteDetalhadoResponse clienteDetalhado = clienteService.buscaCliente(idCliente);
        log.info("[finaliza] {} - getClienteId", getClass().getSimpleName());
        return clienteDetalhado;
    }

    @Override
    public void deleteClienteId(UUID idCliente) {
        log.info("[inicia] {} - deleteClienteId", getClass().getSimpleName());
        clienteService.deletaClientePorId(idCliente);
        log.info("[finaliza] {} - deleteClienteId", getClass().getSimpleName());
    }

    @Override
    public void atualizaCliente(UUID idCliente, ClienteUpdateRequest clienteUpdateRequest) {
        log.info("[inicia] {} - atualizaCliente", getClass().getSimpleName());
        clienteService.patchAtualizaCliente(idCliente, clienteUpdateRequest);
        log.info("[finaliza] {} - atualizaCliente", getClass().getSimpleName());
    }


}
