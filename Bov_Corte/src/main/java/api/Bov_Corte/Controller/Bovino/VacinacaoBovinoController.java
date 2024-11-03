package api.Bov_Corte.Controller.Bovino;

import api.Bov_Corte.Model.Bovino.PesagemBovino;
import api.Bov_Corte.Model.Bovino.VacinacaoBovino;
import api.Bov_Corte.RequestResponseProtocol;
import api.Bov_Corte.Service.Bovino.VacinacaoBovinoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController 
@RequestMapping("vacinacaoBovino")
@SecurityRequirement(name = "jwt-authentication")
@Tag(name = "BOVINO - Vacinação", description = "Endpoints relacionados a Vacinação do Bovino")
public class VacinacaoBovinoController {

   @Autowired
   private VacinacaoBovinoService vacinacaoBovinoService;

//====================================================================================================================//

   @PostMapping("/create") 
   public Object createVacinacaoBovino(@RequestBody VacinacaoBovino vacinacaoBovino){
      RequestResponseProtocol<Boolean> resposta = new RequestResponseProtocol<Boolean>();
      try {
         vacinacaoBovinoService.create(vacinacaoBovino);
         resposta.setValue( true );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @PostMapping("/getAllVacinacaoByBovinoAndFazeda")
   public Object getAllVacinacaoByBovinoAndFazeda( @RequestBody Integer [] value) {
      RequestResponseProtocol<List<VacinacaoBovino>> resposta = new RequestResponseProtocol<List<VacinacaoBovino>>();
      try {
         resposta.setValue(vacinacaoBovinoService.getAllVacinacaoByBovinoAndFazeda(value[0], value[1]));
      } catch (Exception e) {
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
         resposta.setValue( vacinacaoBovinoService.getResumoBovinoFazendaByIntervalo( value[0], value[1] ) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @GetMapping({"/{id}"}) 
   public Object getVacinacaoBovinoById(@PathVariable("id") Integer id){
      return vacinacaoBovinoService.getVacinacaoBovinoById(id);
   }

//====================================================================================================================//

   @PostMapping("/edit") 
   public Object editVacinacaoBovino(@RequestBody VacinacaoBovino vacinacaoBovino){
      return vacinacaoBovinoService.edit(vacinacaoBovino);
   }

//====================================================================================================================//

    @DeleteMapping({"/{id}"})
    public boolean delete(@PathVariable("id") Integer id) {
       return vacinacaoBovinoService.delete(id);
    }

//====================================================================================================================//

}