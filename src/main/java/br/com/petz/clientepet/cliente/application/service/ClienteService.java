package br.com.petz.clientepet.cliente.application.service;

import br.com.petz.clientepet.cliente.application.api.*;

import java.util.List;
import java.util.UUID;

public interface ClienteService{

    ClienteResponse criarCliente(ClienteRequest clienteRequest);

    List<ClienteListResponse> buscaTodosClientes();

    ClienteDetalhadoResponse buscaCliente(UUID idCliente);

    void deletaClientePorId(UUID idCliente);

    void patchAtualizaCliente(UUID idCliente, ClienteUpdateRequest clienteUpdateRequest);
}
