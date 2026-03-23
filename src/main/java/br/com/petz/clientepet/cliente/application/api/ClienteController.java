package br.com.petz.clientepet.cliente.application.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ClienteController implements ClienteAPI {

    @Override
    public ClienteResponse postCliente(ClienteRequest clienteRequest) {
        log.info("[inicia] {} - postCliente", getClass().getSimpleName());
        log.info("[finaliza] {} - postCliente", getClass().getSimpleName());
        return null;
    }
}
