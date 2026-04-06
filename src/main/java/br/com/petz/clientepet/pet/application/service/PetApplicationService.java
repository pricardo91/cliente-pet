package br.com.petz.clientepet.pet.application.service;

import br.com.petz.clientepet.cliente.application.service.ClienteService;
import br.com.petz.clientepet.pet.application.api.*;
import br.com.petz.clientepet.pet.application.repository.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PetApplicationService implements PetService {

    public final ClienteService clienteService;
    public final PetRepository petRepository;

    @Override
    public PetResponse criaPet(UUID idCliente, PetRequest petRequest) {
        log.info("[inicia] {} - criaPet", getClass().getSimpleName());

        clienteService.buscaCliente(idCliente);
        Pet pet = petRepository.salvaPet(new Pet(idCliente, petRequest));

        log.info("[finaliza] {} - criaPet", getClass().getSimpleName());
        return new PetResponse(pet.getIdPet());
    }

    @Override
    public List<PetListResponse> buscaTodosPets(UUID idCliente) {
        log.info("[inicia] {} - buscaTodosPets", getClass().getSimpleName());

        clienteService.buscaCliente(idCliente);
        List<Pet> listaPets = petRepository.buscaTodosPets(idCliente);

        log.info("[finaliza] {} - buscaTodosPets", getClass().getSimpleName());
        return PetListResponse.converte(listaPets);
    }

    @Override
    public PetResponseDetalhado buscaPetPorId(UUID idCliente, UUID idPet) {
        log.info("[inicia] {} - buscaPetPorId", getClass().getSimpleName());

        clienteService.buscaCliente(idCliente);
        Pet pet = petRepository.buscaPetPorId(idPet);

        log.info("[finaliza] {} - buscaPetPorId", getClass().getSimpleName());
        return new PetResponseDetalhado(pet);
    }

    @Override
    public void deletePetsPorId(UUID idCliente, UUID idPet) {
        log.info("[inicia] {} - deletePetsPorId", getClass().getSimpleName());

        clienteService.buscaCliente(idCliente);
        petRepository.deletePetsPorId(idPet);

        log.info("[finaliza] {} - deletePetsPorId", getClass().getSimpleName());
    }

    @Override
    public void alteraPetPorId(UUID idCliente, UUID idPet, PetUpdateRequest petUpdateRequest) {
        log.info("[inicia] {} - alteraPetPorId", getClass().getSimpleName());

        clienteService.buscaCliente(idCliente);
        Pet pet = petRepository.buscaPetPorId(idPet);

        pet.altera(petUpdateRequest);

        petRepository.salvaPet(pet);

        log.info("[finaliza] {} - alteraPetPorId", getClass().getSimpleName());
    }
}
