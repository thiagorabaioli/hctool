package tfr.hcTools.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tfr.hcTools.entities.Endereco;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
