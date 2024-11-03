package api.Bov_Corte.Controller.Bovino;

import api.Bov_Corte.Model.Bovino.BovinoFazenda;
import api.Bov_Corte.Model.Bovino.DTO.Bovino_Transferencia_DTO;
import api.Bov_Corte.Model.Bovino.DTO.CadastroBovino_DTO;
import api.Bov_Corte.Model.Bovino.VWBovinoFazenda;
import api.Bov_Corte.Model.Bovino.VWBovinoFazendaSimples;
import api.Bov_Corte.RequestResponseProtocol;
import api.Bov_Corte.Service.Bovino.BovinoFazendaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController 
@RequestMapping("bovinoFazenda")
@SecurityRequirement(name = "jwt-authentication")
@Tag(name = "BOVINO - Bovino Fazenda", description = "Endpoints relacionados ao Bovino na Fazenda")
public class BovinoFazendaController {

   @Autowired
   private BovinoFazendaService bovinoFazendaService;

//====================================================================================================================//

   @PostMapping("/createByNascimeto")
   public Object createBovinoFazendaByNascimeto(@RequestBody CadastroBovino_DTO cadastroBovino){
      RequestResponseProtocol<Boolean> resposta = new RequestResponseProtocol<Boolean>();
      try {
         bovinoFazendaService.createByNascimeto(cadastroBovino);
         resposta.setValue( true );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @PostMapping("/createByCompraCadAnimal")
   public Object createBovinoFazendaByCompraCadAnimal(@RequestBody CadastroBovino_DTO cadastroBovino){
      RequestResponseProtocol<Boolean> resposta = new RequestResponseProtocol<Boolean>();
      try {
         bovinoFazendaService.createByCompraCadAnimal(cadastroBovino);
         resposta.setValue( true );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @PostMapping("/createByCompraByTransferencia")
   public Object createBovinoFazendaByTransferencia(@RequestBody Bovino_Transferencia_DTO cadastroBovino){
      RequestResponseProtocol<Boolean> resposta = new RequestResponseProtocol<Boolean>();
      try {
         bovinoFazendaService.createByCompraByTransferencia(cadastroBovino);
         resposta.setValue( true );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @PostMapping("/getDadosCompletosByFazenda")
   public Object getDadosCompletosByFazenda(@RequestBody Integer [] value ){
      RequestResponseProtocol<List<VWBovinoFazenda>> resposta = new RequestResponseProtocol<>();
      try {
         resposta.setValue( bovinoFazendaService.getDadosCompletosByFazenda(value[0], value[1], value[2]) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @PostMapping("/getDadosSimplificadosByFazenda")
   public Object getDadosSimplificadosByFazenda( ){
      RequestResponseProtocol<VWBovinoFazendaSimples> resposta = new RequestResponseProtocol<>();
      try {
         resposta.setValue( bovinoFazendaService.getDadosSimplificadosByFazenda(15, 16, 0) );
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
         resposta.setValue( bovinoFazendaService.getResumoBovinoFazendaByIntervalo( value[0], value[1] ) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @PostMapping("/getAllBovinoByFazenda")
   public Object getAllBovinoByFazenda(@RequestBody Integer value){
      RequestResponseProtocol<List<VWBovinoFazenda>> resposta = new RequestResponseProtocol<>();
      try {
         resposta.setValue( bovinoFazendaService.getAllBovinoByFazenda(value) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @PostMapping("/edit") 
   public Object editBovinoFazenda(@RequestBody BovinoFazenda bovinoFazenda){
      return bovinoFazendaService.edit(bovinoFazenda);
   }

//====================================================================================================================//

    @DeleteMapping({"/{id}"})
    public boolean delete(@PathVariable("id") Integer id) {
       return bovinoFazendaService.delete(id);
    }

//====================================================================================================================//

}