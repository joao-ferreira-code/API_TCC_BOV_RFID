package api.Bov_Corte.Service.Bovino;

import api.Bov_Corte.Model.Bovino.CompraBovino;
import api.Bov_Corte.Repository.Bovino.CompraBovinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraBovinoService {

   @Autowired
   private CompraBovinoRepository compraBovinoRepository;

//====================================================================================================================//

   public CompraBovino create(CompraBovino compraBovino){
      return compraBovinoRepository.save(compraBovino);
   }

//====================================================================================================================//

   public List<CompraBovino> getAllCompraBovino(){
      return (List<CompraBovino>)compraBovinoRepository.findAll();
   }

   public Optional<CompraBovino> getCompraBovinoById(int id){
      return compraBovinoRepository.findById(id);
   }

//====================================================================================================================//

   public CompraBovino edit(CompraBovino compraBovino){
      return compraBovinoRepository.save(compraBovino);
   }

//====================================================================================================================//

    public boolean delete(int id) {
       if (compraBovinoRepository.existsById(id)) {
           compraBovinoRepository.deleteById(id);
       }
       return true;
    }

//====================================================================================================================//

}