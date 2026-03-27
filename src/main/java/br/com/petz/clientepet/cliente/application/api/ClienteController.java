package br.com.petz.clientepet.cliente.application.api;

import br.com.petz.clientepet.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        log.info("[finaliza] {} - getTodosClientes", getClass().getSimpleName());
        return List.of();
    }


}
