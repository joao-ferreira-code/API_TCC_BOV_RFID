package api.Bov_Corte.Controller.AdmSistema;

import api.Bov_Corte.Model.AdmSistema.Raca;
import api.Bov_Corte.RequestResponseProtocol;
import api.Bov_Corte.Service.AdmSistema.RacaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("raca")
@Tag(name = "ADMINISTRAÇÃO SISTEMA - Raca Animal", description = "Endpoints relacionados a Raca dos Animais")
public class RacaController {

   @Autowired
   private RacaService racaService;

//====================================================================================================================//

   @PostMapping("/create")
   public Object createRaca(@RequestBody Raca raca){
      return racaService.create(raca);
   }

//====================================================================================================================//

   @GetMapping("/getAllRaca")
   public Object getAllRaca(){
      RequestResponseProtocol<List<Raca>> resposta = new RequestResponseProtocol<List<Raca>>();
      try {
         resposta.setValue( racaService.getAllRaca() );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @GetMapping({"/{id}"})
   public Object getRacaById(@PathVariable("id") Integer id){
      RequestResponseProtocol<Raca> resposta = new RequestResponseProtocol<Raca>();
      try {
         resposta.setValue( racaService.getRacaById(id).get() );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

}