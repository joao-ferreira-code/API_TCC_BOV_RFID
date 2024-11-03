package api.Bov_Corte.Service.Bovino;
import api.Bov_Corte.Model.Bovino.FotoBovino;
import api.Bov_Corte.Repository.Bovino.FotoBovinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FotoBovinoService {

   @Autowired
   private FotoBovinoRepository fotoBovinoRepository;

//====================================================================================================================//

   public FotoBovino create(FotoBovino fotoBovino){
      fotoBovino.setDtCadastro(new Date());
      return fotoBovinoRepository.save(fotoBovino);
   }

//====================================================================================================================//

   public FotoBovino getFotoPerfilAnimal(int fkFazenda){
      return fotoBovinoRepository.getFotoPerfilAnimal(fkFazenda);
   }

//====================================================================================================================//

   public List<FotoBovino> getAllFotoByAtivaBovino(int fkBovino){
      return fotoBovinoRepository.getAllFotoByAtivaBovino(fkBovino);
   }

//====================================================================================================================//

   public Optional<FotoBovino> getFotoFazendaById(int id){
      return fotoBovinoRepository.findById(id);
   }

//====================================================================================================================//

}