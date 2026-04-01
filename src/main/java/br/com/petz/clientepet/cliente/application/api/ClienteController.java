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
        log.info("[start] {} - getClienteId", getClass().getSimpleName());
        ClienteDetalhadoResponse clienteDetalhado = clienteService.buscaClientePorId(idCliente);
        log.info("[end] {} - getClienteId", getClass().getSimpleName());
        return clienteDetalhado;
    }

    @Override
    public void deleteClienteId(UUID idCliente) {
        log.info("[start] {} - deleteClienteId", getClass().getSimpleName());
        log.info("[end] {} - deleteClienteId", getClass().getSimpleName());
    }


}
