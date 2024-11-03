package api.Bov_Corte.Controller.Bovino;

import api.Bov_Corte.Model.Bovino.PesagemBovino;
import api.Bov_Corte.RequestResponseProtocol;
import api.Bov_Corte.Service.Bovino.PesagemBovinoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController 
@RequestMapping("pesagemBovino")
@SecurityRequirement(name = "jwt-authentication")
@Tag(name = "BOVINO - Pesagem", description = "Endpoints relacionados a Pesagem do Bovino")
public class PesagemBovinoController {

   @Autowired
   private PesagemBovinoService pesagemBovinoService;

//====================================================================================================================//

   @PostMapping("/create") 
   public Object createPesagemBovino(@RequestBody PesagemBovino pesagemBovino){
      RequestResponseProtocol<Boolean> resposta = new RequestResponseProtocol<Boolean>();
      try {
         pesagemBovinoService.create(pesagemBovino);
         resposta.setValue( true );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @PostMapping("/getAllPesagemByBovinoAndFazeda")
   public Object getAllPesagemByBovinoAndFazeda(@RequestBody Integer [] value){
      RequestResponseProtocol<List<PesagemBovino>> resposta = new RequestResponseProtocol<List<PesagemBovino>>();
      try {
         resposta.setValue( pesagemBovinoService.getAllPesagemByBovinoAndFazeda( value[0], value[1]) );
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
         resposta.setValue( pesagemBovinoService.getResumoBovinoFazendaByIntervalo( value[0], value[1] ) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @GetMapping({"/{id}"}) 
   public Object getPesagemBovinoById(@PathVariable("id") Integer id){
      return pesagemBovinoService.getPesagemBovinoById(id);
   }

//====================================================================================================================//

   @PostMapping("/edit") 
   public Object editPesagemBovino(@RequestBody PesagemBovino pesagemBovino){
      return pesagemBovinoService.edit(pesagemBovino);
   }

//====================================================================================================================//

    @DeleteMapping({"/{id}"})
    public boolean delete(@PathVariable("id") Integer id) {
       return pesagemBovinoService.delete(id);
    }

//====================================================================================================================//

}