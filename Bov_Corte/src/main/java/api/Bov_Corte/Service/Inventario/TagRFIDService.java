package api.Bov_Corte.Service.Inventario;

import api.Bov_Corte.Model.Inventario.TagRFID;
import api.Bov_Corte.Repository.Inventario.TagRFIDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagRFIDService {

   @Autowired
   private TagRFIDRepository tagRFIDRepository;

//====================================================================================================================//

   public TagRFID create(TagRFID tagRFID){
      return tagRFIDRepository.save(tagRFID);
   }

//====================================================================================================================//

   public List<TagRFID> getAllByFazendaAndLote(){
      return (List<TagRFID>)tagRFIDRepository.findAll();
   }

   public Optional<TagRFID> getTagRFIDById(int id){
      return tagRFIDRepository.findById(id);
   }

//====================================================================================================================//

   public TagRFID edit(TagRFID tagRFID){
      return tagRFIDRepository.save(tagRFID);
   }

//====================================================================================================================//

    public boolean delete(int id) {
       if (tagRFIDRepository.existsById(id)) {
           tagRFIDRepository.deleteById(id);
       }
       return true;
    }

//====================================================================================================================//

}