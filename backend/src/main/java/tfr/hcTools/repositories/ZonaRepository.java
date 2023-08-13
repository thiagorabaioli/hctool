package tfr.hcTools.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tfr.hcTools.entities.Zona;


@Repository
public interface ZonaRepository extends JpaRepository<Zona, Long> {

}
