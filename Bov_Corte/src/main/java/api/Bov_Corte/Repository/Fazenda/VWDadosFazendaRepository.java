package api.Bov_Corte.Repository.Fazenda;

import api.Bov_Corte.Model.Fazenda.VWDadosFazenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface VWDadosFazendaRepository extends JpaRepository<VWDadosFazenda, Integer> {

    VWDadosFazenda findByTxCodigoPublico(String codigoPublico);

}