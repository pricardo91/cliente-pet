package br.com.petz.clientepet.cliente.application.service;

import br.com.petz.clientepet.cliente.application.api.ClienteDetalhadoResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteListResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteResponse;

import java.util.List;
import java.util.UUID;

public interface ClienteService{

    ClienteResponse criarCliente(ClienteRequest clienteRequest);

    List<ClienteListResponse> buscaTodosClientes();

    ClienteDetalhadoResponse buscaClientePorId(UUID idCliente);

    void deletaClientePorId(UUID idCliente);
}
