package br.com.petz.clientepet.pet.application.service;

import br.com.petz.clientepet.pet.application.api.*;

import java.util.List;
import java.util.UUID;

public interface PetService {

    PetResponse criaPet(UUID idCliente, PetRequest petRequest);

    List<PetListResponse> buscaTodosPets(UUID idCliente);

    PetResponseDetalhado buscaPetPorId(UUID idCliente, UUID idPet);

    void deletePetsPorId(UUID idCliente, UUID idPet);

    void alteraPetPorId(UUID idCliente, UUID idPet, PetUpdateRequest petUpdateRequest);
}
