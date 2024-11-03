package api.Bov_Corte.Repository.Fazenda;

import api.Bov_Corte.Model.Fazenda.Fazenda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FazendaRepository extends CrudRepository<Fazenda, Integer> {

    @Query("Select fz from Fazenda fz " +
           "inner join ColaboradorFazenda cl on cl.fkFazenda = fz.pkFazenda " +
            "where cl.isAtiva = true and cl.fkUsuario = ?1 order by fz.isAtiva desc, fz.txNome asc")
    List<Fazenda> getAllFazendasAtivaByColaborador(int usuNrId);

//====================================================================================================================//

    @Query("Select fz from Fazenda fz " +
            "inner join ColaboradorFazenda cl on cl.fkFazenda = fz.pkFazenda " +
            "inner join NivelAcesso na on na.pkNivelAcesso = cl.fkNivelAcesso " +
            "where cl.isAtiva = true and cl.fkFazenda = ?1 and cl.fkUsuario = ?2  and na.txNome = 'ADM'")
    Fazenda buscarFazendaSeUsuarioAdm(int pkFazenda, int fkUsuario);

//====================================================================================================================//

}