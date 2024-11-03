package api.Bov_Corte.Controller.Bovino;

import api.Bov_Corte.Model.AdmSistema.Cidade;
import api.Bov_Corte.Model.Bovino.Bovino;
import api.Bov_Corte.RequestResponseProtocol;
import api.Bov_Corte.Service.Bovino.BovinoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController 
@RequestMapping("bovino")
@SecurityRequirement(name = "jwt-authentication")
@Tag(name = "BOVINO - Bovino", description = "Endpoints relacionados ao Bovino")
public class BovinoController {

   @Autowired
   private BovinoService bovinoService;

//====================================================================================================================//

   @PostMapping("/create") 
   public Object createBovino(@RequestBody Bovino bovino){
      RequestResponseProtocol<Boolean> resposta = new RequestResponseProtocol<Boolean>();
      try {
         bovinoService.create(bovino);
         resposta.setValue( true );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   /*@GetMapping("/getAllBovino")
   public Object getAllBovino(@RequestBody int fkFazenda){
      return bovinoService.getAllBovinoByFazenda(fkFazenda);
   }*/

   @PutMapping({"/{id}"})
   public Object getBovinoById(@PathVariable("id") Integer id){
      return bovinoService.getBovinoById(id);
   }

//====================================================================================================================//

   @PostMapping("/edit") 
   public Object editBovino(@RequestBody Bovino bovino){
      return bovinoService.edit(bovino);
   }

//====================================================================================================================//

    @DeleteMapping({"/{id}"})
    public boolean delete(@PathVariable("id") Integer id) {
       return bovinoService.delete(id);
    }

//====================================================================================================================//

}