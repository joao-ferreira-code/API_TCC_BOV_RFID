package api.Bov_Corte.Service.Inventario;

import api.Bov_Corte.Model.Inventario.LoteTagRFID;
import api.Bov_Corte.Repository.Inventario.LoteTagRFIDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoteTagRFIDService {

   @Autowired
   private LoteTagRFIDRepository loteTagRFIDRepository;

//====================================================================================================================//

   public LoteTagRFID create(LoteTagRFID loteTagRFID){
      return loteTagRFIDRepository.save(loteTagRFID);
   }

//====================================================================================================================//

   public List<LoteTagRFID> getAllLoteTagRFID(int fkFazenda){
      return (List<LoteTagRFID>)loteTagRFIDRepository.findAllByFkFazenda(fkFazenda);
   }

//====================================================================================================================//

   public Optional<LoteTagRFID> getLoteTagRFIDById(int id){
      return loteTagRFIDRepository.findById(id);
   }

//====================================================================================================================//

   public LoteTagRFID edit(LoteTagRFID loteTagRFID){
      return loteTagRFIDRepository.save(loteTagRFID);
   }

//====================================================================================================================//

    public boolean delete(int id) {
       if (loteTagRFIDRepository.existsById(id)) {
           loteTagRFIDRepository.deleteById(id);
       }
       return true;
    }

//====================================================================================================================//

}