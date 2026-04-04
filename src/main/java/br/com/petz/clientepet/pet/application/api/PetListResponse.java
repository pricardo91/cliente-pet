package br.com.petz.clientepet.pet.application.api;

import br.com.petz.clientepet.pet.domain.Porte;
import lombok.Value;

import java.util.UUID;

@Value
public class PetListResponse {
    private UUID idPet;
    private String nomePet;
    private Porte porte;
    private String raca;
}
