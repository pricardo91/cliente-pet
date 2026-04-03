package br.com.petz.clientepet.pet.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/v1/clientes/{idCliente}/pets")
public interface PetAPI {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PetResponse postPet(@PathVariable UUID idCliente,
                        @RequestBody @Valid PetRequest petRequest);
}
