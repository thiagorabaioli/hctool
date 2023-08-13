package tfr.hcTools.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tfr.hcTools.entities.Localidade;


@Repository
public interface LocalidadeRepository extends JpaRepository<Localidade, Long> {

}
