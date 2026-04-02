package br.com.petz.clientepet.cliente.application.api;

import br.com.petz.clientepet.cliente.domain.Sexo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ClienteUpdateRequest {
    @NotBlank
    private String nomeCompleto;

    @NotBlank
    private String celular;

    private String telefone;

    private Sexo sexo;

    @NotNull
    private LocalDate dataNascimento;

}
