package br.com.petz.clientepet.cliente.application.service;

import br.com.petz.clientepet.cliente.application.api.ClienteListResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteResponse;

import java.util.List;

public interface ClienteService{

    ClienteResponse criarCliente(ClienteRequest clienteRequest);

    List<ClienteListResponse> buscaTodosClientes();
}
