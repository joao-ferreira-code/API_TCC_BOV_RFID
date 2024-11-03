package api.Bov_Corte.Controller.AdmSistema;

import api.Bov_Corte.Model.AdmSistema.Cidade;
import api.Bov_Corte.RequestResponseProtocol;
import api.Bov_Corte.Service.AdmSistema.CidadeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("cidade")
@Tag(name = "ADMINISTRAÇÃO SISTEMA - Cidade", description = "Endpoints relacionados a Cidade")
public class CidadeController {

   @Autowired
   private CidadeService cidadeService;

//====================================================================================================================//

   @SecurityRequirement(name = "jwt-authentication")
   @PostMapping("/create")
   public Object createCidade(@RequestBody Cidade cidade){
      return cidadeService.create(cidade);
   }

//====================================================================================================================//

   @GetMapping("/getAllCidade")
   public Object getAllCidade(){
      RequestResponseProtocol<List<Cidade>> resposta = new RequestResponseProtocol<List<Cidade>>();
      try {
         resposta.setValue( cidadeService.getAllCidade() );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//
   @GetMapping("/getAllCidadeByEstadoId/{id}")
   public Object getAllCidadeByEstadoId(@PathVariable("id") Integer fkEstado){
      RequestResponseProtocol<List<Cidade>> resposta = new RequestResponseProtocol<List<Cidade>>();
      try {
         resposta.setValue( cidadeService.getAllCidadeByEstadoId( fkEstado ) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @GetMapping({"/{id}"})
   public Object getCidadeById(@PathVariable("id") Integer id){
      RequestResponseProtocol<Cidade> resposta = new RequestResponseProtocol<Cidade>();
      try {
         resposta.setValue( cidadeService.getCidadeById(id).get() );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

}