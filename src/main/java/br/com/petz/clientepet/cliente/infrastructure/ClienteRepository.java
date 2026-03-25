package br.com.petz.clientepet.cliente.infrastructure;

import br.com.petz.clientepet.cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
}
