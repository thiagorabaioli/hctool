package tfr.hcTools.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tfr.hcTools.entities.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
