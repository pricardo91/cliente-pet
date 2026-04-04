package br.com.petz.clientepet.pet.application.service;

import br.com.petz.clientepet.cliente.application.service.ClienteService;
import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.api.PetResponse;
import br.com.petz.clientepet.pet.application.repository.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PetApplicationService implements PetService{

    public final ClienteService clienteService;
    public final PetRepository petRepository;

    @Override
    public PetResponse criaPet(UUID idCliente, PetRequest petRequest) {
        log.info("[inicia] {} - criaPet", getClass().getSimpleName());
        clienteService.buscaCliente(idCliente);
        log.info("[clienteID] {} ", idCliente);
        Pet pet = petRepository.salvaPet(new Pet(idCliente, petRequest));
        log.info("[finaliza] {} - criaPet", getClass().getSimpleName());
        return new PetResponse(pet.getIdPet());
    }
}
