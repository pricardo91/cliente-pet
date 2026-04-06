package br.com.petz.clientepet.pet.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/v1/clientes/{idCliente}/pets")
public interface PetAPI {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PetResponse postPet(@PathVariable UUID idCliente,
                        @RequestBody @Valid PetRequest petRequest);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<PetListResponse> getTodosPets(@PathVariable UUID idCliente);

    @GetMapping("/{idPet}")
    @ResponseStatus(HttpStatus.OK)
    PetResponseDetalhado getPetsPorId(@PathVariable UUID idCliente,
                                      @PathVariable UUID idPet);

    @DeleteMapping("/{idPet}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePetsPorId(@PathVariable UUID idCliente,
                         @PathVariable UUID idPet);

    @PatchMapping("/{idPet}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    PetResponse patchPetsPorId(@PathVariable UUID idCliente,
                        @PathVariable UUID idPet,
                        @RequestBody @Valid PetUpdateRequest petRequest);
}
