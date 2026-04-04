package br.com.petz.clientepet.pet.infrastructure;

import br.com.petz.clientepet.pet.application.api.PetResponse;
import br.com.petz.clientepet.pet.application.repository.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
public class PetInfraRepository implements PetRepository {

    private final PetSpringJpaRepository petSpringJpaRepository;

    @Override
    @Transactional
    public Pet salvaPet(Pet pet) {
        log.info("[inicia] - {} - salvaPet", getClass().getSimpleName());
        petSpringJpaRepository.save(pet);
        log.info("[finaliza] - {} - salvaPet", getClass().getSimpleName());
        return pet;
    }
}
