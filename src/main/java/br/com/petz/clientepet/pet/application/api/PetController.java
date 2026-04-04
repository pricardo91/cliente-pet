package br.com.petz.clientepet.pet.application.api;

import br.com.petz.clientepet.pet.application.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PetController implements PetAPI {
    private final PetService petService;

    @Override
    public PetResponse postPet(UUID idCliente, PetRequest petRequest) {
        log.info("[inicia] {} - postPet", getClass().getSimpleName());
        PetResponse petResponse = petService.criaPet(idCliente, petRequest);
        log.info("[finaliza] {} - postPet", getClass().getSimpleName());
        return petResponse;
    }

    @Override
    public List<PetListResponse> getTodosPets(UUID idCliente) {
        log.info("[inicia] {} - getTodosPets", getClass().getSimpleName());
        List<PetListResponse> pets =  petService.buscaTodosPets(idCliente);
        log.info("[finaliza] {} - getTodosPets", getClass().getSimpleName());
        return pets;
    }
}
