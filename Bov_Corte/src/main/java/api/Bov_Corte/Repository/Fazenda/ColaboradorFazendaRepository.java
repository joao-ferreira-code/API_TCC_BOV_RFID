package api.Bov_Corte.Repository.Fazenda;

import api.Bov_Corte.Model.Fazenda.ColaboradorFazenda;
import api.Bov_Corte.Model.Perfil.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColaboradorFazendaRepository extends CrudRepository<ColaboradorFazenda, Integer> {

    @Query("Select us from ColaboradorFazenda cf " +
            "inner join Usuario us on us.pkUsuario = cf.fkUsuario " +
            "where cf.fkFazenda = ?1 order by us.txNome")
    List<Usuario> getAllColaboradorByFazenda(int fkFazenda);

    ColaboradorFazenda findByFkFazendaAndFkUsuario(int fkFazenda, int fkUsuario);

}