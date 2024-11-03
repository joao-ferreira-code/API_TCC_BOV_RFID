package api.Bov_Corte.Controller.Bovino;

import api.Bov_Corte.Model.Bovino.DescarteBovino;
import api.Bov_Corte.Model.Bovino.VWDadosDescarte;
import api.Bov_Corte.RequestResponseProtocol;
import api.Bov_Corte.Service.Bovino.DescarteBovinoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("descarteBovino")
@SecurityRequirement(name = "jwt-authentication")
@Tag(name = "BOVINO - Descarte", description = "Endpoints relacionados ao Descarte")
public class DescarteBovinoController {

   @Autowired
   private DescarteBovinoService descarteBovinoService;

//====================================================================================================================//

   @PostMapping("/create") 
   public Object createDescarteBovino(@RequestBody DescarteBovino descarteBovino){
      RequestResponseProtocol<Boolean> resposta = new RequestResponseProtocol<Boolean>();
      try {
         descarteBovinoService.create(descarteBovino);
         resposta.setValue( true );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @PostMapping("/getAllByPkFazenda")
   public Object getAllByPkFazenda(@RequestBody int fkFazenda){
      RequestResponseProtocol<List<VWDadosDescarte>> resposta = new RequestResponseProtocol<>();
      try {
         resposta.setValue( descarteBovinoService.getAllByPkFazenda(fkFazenda) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @PostMapping("/getResumoBovinoFazendaByIntervalo")
   public Object getResumoBovinoFazendaByIntervalo( @RequestBody Integer [] value ){
      RequestResponseProtocol<Object> resposta = new RequestResponseProtocol<>();
      try {
         resposta.setValue( descarteBovinoService.getResumoBovinoFazendaByIntervalo( value[0], value[1] ) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @GetMapping({"/{id}"}) 
   public Object getDescarteBovinoById(@PathVariable("id") Integer id){
      return descarteBovinoService.getDescarteBovinoById(id);
   }

//====================================================================================================================//

   @PostMapping("/edit") 
   public Object editDescarteBovino(@RequestBody DescarteBovino descarteBovino){
      return descarteBovinoService.edit(descarteBovino);
   }

//====================================================================================================================//

    @DeleteMapping({"/{id}"})
    public boolean delete(@PathVariable("id") Integer id) {
       return descarteBovinoService.delete(id);
    }

//====================================================================================================================//

}