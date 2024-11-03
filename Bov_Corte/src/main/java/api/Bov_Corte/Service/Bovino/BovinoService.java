package api.Bov_Corte.Service.Bovino;

import api.Bov_Corte.Model.Bovino.Bovino;
import api.Bov_Corte.Repository.Bovino.BovinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BovinoService {

   @Autowired
   private BovinoRepository bovinoRepository;

//====================================================================================================================//

   public Bovino create(Bovino bovino){
      bovino.setDtCadastro(new Date());
      return bovinoRepository.save(bovino);
   }

//====================================================================================================================//

   /*public List<Bovino> getAllBovinoByFazenda(int fkFazenda){
      return (List<Bovino>)bovinoRepository.findAllByFkBovinoAndIsAtiva(fkFazenda, true);
   }*/

//====================================================================================================================//

   public Optional<Bovino> getBovinoById(int id){
      return bovinoRepository.findById(id);
   }

//====================================================================================================================//

   public Bovino edit(Bovino bovino){
      return bovinoRepository.save(bovino);
   }

//====================================================================================================================//

    public boolean delete(int id) {
       if (bovinoRepository.existsById(id)) {
           bovinoRepository.deleteById(id);
       }
       return true;
    }

//====================================================================================================================//

}