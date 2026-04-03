package br.com.petz.clientepet.pet.application.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
public class PetController implements PetAPI {
    @Override
    public PetResponse postPet(UUID idCliente, PetRequest petRequest) {
        log.info("[inicia] {} - postPet", getClass().getSimpleName());
        log.info("[finaliza] {} - postPet", getClass().getSimpleName());
        return null;
    }
}
