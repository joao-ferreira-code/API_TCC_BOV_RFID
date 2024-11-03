package api.Bov_Corte.Controller.Inventario;

import api.Bov_Corte.Model.Inventario.TagRFID;
import api.Bov_Corte.RequestResponseProtocol;
import api.Bov_Corte.Service.Inventario.TagRFIDService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("tagRFID")
@SecurityRequirement(name = "jwt-authentication")
@Tag(name = "INVENTARIO - Tag RFID", description = "Endpoints relacionados as Tags RFID")
public class TagRFIDController {

   @Autowired
   private TagRFIDService tagRFIDService;

//====================================================================================================================//

   @PostMapping("/create") 
   public Object createTagRFID(@RequestBody TagRFID tagRFID){
      RequestResponseProtocol<Boolean> resposta = new RequestResponseProtocol<Boolean>();
      try {
         tagRFIDService.create(tagRFID);
         resposta.setValue( true );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @GetMapping("/getAllByFazendaAndLote")
   public Object getAllByFazendaAndLote(){
      RequestResponseProtocol<List<TagRFID>> resposta = new RequestResponseProtocol<>();
      try {
         resposta.setValue( tagRFIDService.getAllByFazendaAndLote() );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @GetMapping({"/{id}"}) 
   public Object getTagRFIDById(@PathVariable("id") Integer id){
      return tagRFIDService.getTagRFIDById(id);
   }

//====================================================================================================================//

   @PostMapping("/edit") 
   public Object editTagRFID(@RequestBody TagRFID tagRFID){
      return tagRFIDService.edit(tagRFID);
   }

//====================================================================================================================//

    @DeleteMapping({"/{id}"})
    public boolean delete(@PathVariable("id") Integer id) {
       return tagRFIDService.delete(id);
    }

//====================================================================================================================//

}