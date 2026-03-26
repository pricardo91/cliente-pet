package br.com.petz.clientepet.cliente.application.service;

import br.com.petz.clientepet.cliente.application.api.ClienteRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteResponse;
import br.com.petz.clientepet.cliente.application.repository.ClienteRepository;
import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {
    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse criarCliente(ClienteRequest clienteRequest) {
        log.info("[start] {} - criarCliente", getClass().getSimpleName());

        Cliente cliente = clienteRepository.save(new Cliente(clienteRequest));

        //ClienteResponse clienteResponse = new ClienteResponse(cliente.getIdCliente());
        log.info("[end] {} - criarCliente", getClass().getSimpleName());
        return ClienteResponse.builder()
                .idCliente(cliente.getIdCliente())
                .build();
    }
}
