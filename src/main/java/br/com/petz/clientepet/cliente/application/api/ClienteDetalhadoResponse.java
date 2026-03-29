package br.com.petz.clientepet.cliente.application.api;

import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class ClienteDetalhadoResponse {
    private UUID idCliente;
    private String nomeCompleto;
    private String email;
    private String celular;
    private String cpf;
    private Boolean aceitaTermos;
    private LocalDateTime dataHoraDoCadastro;
}
