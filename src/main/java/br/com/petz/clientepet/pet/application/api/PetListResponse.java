package br.com.petz.clientepet.pet.application.api;

import br.com.petz.clientepet.cliente.application.api.ClienteListResponse;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Value
public class PetListResponse {
    private UUID idPet;
    private String nomePet;
    private String raca;
    private String pelagemCor;
    private LocalDate dataNascimento;

    public static List<PetListResponse> converte(List<Pet> listaPets) {
        return listaPets.stream()
                .map(PetListResponse::new)
                .toList();
    }

    public PetListResponse(Pet pet) {
        this.idPet = pet.getIdPet();
        this.nomePet = pet.getNomePet();
        this.raca = pet.getRaca();
        this.pelagemCor = pet.getPelagemCor();
        this.dataNascimento = pet.getDataNascimento();
    }
}
