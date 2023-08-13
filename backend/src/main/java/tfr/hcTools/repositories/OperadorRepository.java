package tfr.hcTools.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tfr.hcTools.entities.Operador;


@Repository
public interface OperadorRepository extends JpaRepository<Operador, Long> {

}
