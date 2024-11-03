package api.Bov_Corte.Service.Fazenda;

import api.Bov_Corte.Model.Fazenda.ColaboradorFazenda;
import api.Bov_Corte.Model.Fazenda.VWColaboradorFazenda;
import api.Bov_Corte.Model.Perfil.Usuario;
import api.Bov_Corte.Repository.Fazenda.ColaboradorFazendaRepository;
import api.Bov_Corte.Repository.Fazenda.VWColaboradorFazendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorFazendaService {

   @Autowired
   private ColaboradorFazendaRepository colaboradorFazendaRepository;

   @Autowired
   private VWColaboradorFazendaRepository vwColaboradorFazendaRepository;

//====================================================================================================================//

   public ColaboradorFazenda create(ColaboradorFazenda colaboradorFazenda){
      colaboradorFazenda.setDtCadastro(new Date());
      colaboradorFazenda.setAtiva(true);
      return colaboradorFazendaRepository.save(colaboradorFazenda);
   }

//====================================================================================================================//

   public List<VWColaboradorFazenda> getAllColaboradorFazenda(int fkFazenda){
      return (List<VWColaboradorFazenda>)vwColaboradorFazendaRepository.getAllColaboradorByFazenda(fkFazenda);
   }

//====================================================================================================================//

   public Optional<ColaboradorFazenda> getColaboradorFazendaById(int id){
      return colaboradorFazendaRepository.findById(id);
   }

//====================================================================================================================//

   public ColaboradorFazenda edit(ColaboradorFazenda colaboradorFazenda){
      return colaboradorFazendaRepository.save(colaboradorFazenda);
   }

//====================================================================================================================//

    public boolean inativarColaboradorFazenda(ColaboradorFazenda colaboradorFazenda) {
      /*Optional<ColaboradorFazenda> colb = colaboradorFazendaRepository.findById(colaboradorFazenda.getPkColaboradorFazenda());
       if(colb.isPresent()){
          colb.get().setTxMotivoSaida(colaboradorFazenda.getTxMotivoSaida());
          colb.get().setDtRemocao(new Date());
          colaboradorFazendaRepository.save(colb.get());
       }
       return true;*/
       ColaboradorFazenda colb = colaboradorFazendaRepository.findByFkFazendaAndFkUsuario(colaboradorFazenda.getFkFazenda(), colaboradorFazenda.getFkUsuario());

       colb.setTxMotivoSaida(" >>> <<< ");
       colb.setDtRemocao(new Date());
       colb.setAtiva(false);
       return colaboradorFazendaRepository.save(colb) != null;
    }

//====================================================================================================================//

}