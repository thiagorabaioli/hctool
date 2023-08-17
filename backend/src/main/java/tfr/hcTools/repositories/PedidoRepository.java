package tfr.hcTools.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tfr.hcTools.entities.Pedido;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
