package br.com.petz.clientepet.pet.infrastructure;

import br.com.petz.clientepet.pet.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PetSpringJpaRepository extends JpaRepository<Pet, UUID> {
    List<Pet> findAllByIdClienteTutor(UUID idClienteTutor);
}
