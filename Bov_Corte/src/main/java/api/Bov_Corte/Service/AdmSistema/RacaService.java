package api.Bov_Corte.Service.AdmSistema;

import api.Bov_Corte.Model.AdmSistema.Raca;
import api.Bov_Corte.Repository.AdmSistema.RacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RacaService {

   @Autowired
   private RacaRepository racaRepository;

//====================================================================================================================//

   public Raca create(Raca raca){
      return racaRepository.save(raca);
   }

//====================================================================================================================//

   public List<Raca> getAllRaca(){
      return (List<Raca>)racaRepository.getAllRacaOrderByTxNome();
   }

   public Optional<Raca> getRacaById(int id){
      return racaRepository.findById(id);
   }

//====================================================================================================================//

}