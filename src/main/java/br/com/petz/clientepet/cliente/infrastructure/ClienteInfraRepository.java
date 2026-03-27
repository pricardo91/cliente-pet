package br.com.petz.clientepet.cliente.infrastructure;

import br.com.petz.clientepet.cliente.application.api.ClienteListResponse;
import br.com.petz.clientepet.cliente.application.repository.ClienteRepository;
import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {

    private final ClienteSpringDataJPARepository clienteSpringDataJPARepository;

    @Override
    public Cliente salva(Cliente cliente) {
        log.info("[start] {} - salva", getClass().getSimpleName());
        clienteSpringDataJPARepository.save(cliente);
        log.info("[end] {} - salva", getClass().getSimpleName());
        return cliente;
    }

    @Override
    public List<ClienteListResponse> buscaTodosCliente() {
        log.info("[start] {} - buscaTodosCliente", getClass().getSimpleName());
        log.info("[end] {} - buscaTodosCliente", getClass().getSimpleName());
        return List.of();
    }
}
