package api.Bov_Corte.Controller.Inventario;

import api.Bov_Corte.Model.Inventario.LoteVacina;
import api.Bov_Corte.RequestResponseProtocol;
import api.Bov_Corte.Service.Inventario.LoteVacinaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController 
@RequestMapping("vacina")
@SecurityRequirement(name = "jwt-authentication")
@Tag(name = "INVENTARIO - Lote Vacina", description = "Endpoints relacionados aos Lotes de Vacinas")
public class LoteVacinaController {

   @Autowired
   private LoteVacinaService loteVacinaService;

//====================================================================================================================//

   @PostMapping("/create") 
   public Object createVacina(@RequestBody LoteVacina loteVacina){
      RequestResponseProtocol<Boolean> resposta = new RequestResponseProtocol<Boolean>();
      try {
         loteVacinaService.create(loteVacina);
         resposta.setValue( true );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
         resposta.setValue(false);
      }
      return resposta;
   }

//====================================================================================================================//

   @GetMapping("/getAllLoteObrigatorioByFazenda/{id}")
   public Object getAllLoteObrigatorioByFazenda(@PathVariable("id") Integer fkFazenda){
      RequestResponseProtocol<List<LoteVacina>> resposta = new RequestResponseProtocol<List<LoteVacina>>();
      try {
         resposta.setValue( loteVacinaService.getAllLoteObrigatorioByFazenda(fkFazenda) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @GetMapping("/getAllLoteRotineiraByFazenda/{id}")
   public Object getAllLoteRotineiraByFazenda(@PathVariable("id") Integer fkFazenda){
      RequestResponseProtocol<List<LoteVacina>> resposta = new RequestResponseProtocol<List<LoteVacina>>();
      try {
         resposta.setValue( loteVacinaService.getAllLoteRotineiraByFazenda(fkFazenda) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @GetMapping("/getAllLoteAtivoByFazenda/{id}")
   public Object getAllLoteAtivoByFazenda(@PathVariable("id") Integer fkFazenda){
      RequestResponseProtocol<List<LoteVacina>> resposta = new RequestResponseProtocol<List<LoteVacina>>();
      try {
         resposta.setValue( loteVacinaService.getAllLoteAtivoByFazenda(fkFazenda) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @GetMapping({"/{id}"}) 
   public Object getVacinaById(@PathVariable("id") Integer id){
      RequestResponseProtocol<LoteVacina> resposta = new RequestResponseProtocol<LoteVacina>();
      try {
         resposta.setValue( loteVacinaService.getVacinaById(id).get() );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @PostMapping("/edit") 
   public Object editVacina(@RequestBody LoteVacina loteVacina){
      return loteVacinaService.edit(loteVacina);
   }

//====================================================================================================================//

    @DeleteMapping({"/{id}"})
    public boolean delete(@PathVariable("id") Integer id) {
       return loteVacinaService.delete(id);
    }

//====================================================================================================================//

}