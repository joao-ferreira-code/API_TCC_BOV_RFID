package api.Bov_Corte.Controller.AdmSistema;

import api.Bov_Corte.Model.AdmSistema.NivelAcesso;
import api.Bov_Corte.RequestResponseProtocol;
import api.Bov_Corte.Service.AdmSistema.NivelAcessoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("nivelAcesso")
@Tag(name = "ADMINISTRAÇÃO SISTEMA - Nivel Acesso", description = "Endpoints relacionados ao Nivel de Acesso")
public class NivelAcessoController {

   @Autowired
   private NivelAcessoService nivelAcessoService;

//====================================================================================================================//

   @SecurityRequirement(name = "jwt-authentication")
   @PostMapping("/create")
   public Object createNivelAcesso(@RequestBody NivelAcesso nivelAcesso){
      return nivelAcessoService.create(nivelAcesso);
   }

//====================================================================================================================//

   @GetMapping("/getAllNivelAcesso")
   public Object getAllNivelAcesso(){
      RequestResponseProtocol<List<NivelAcesso>> resposta = new RequestResponseProtocol<List<NivelAcesso>>();
      try {
         resposta.setValue( nivelAcessoService.getAllNivelAcesso() );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @GetMapping({"/{id}"})
   public Object getNivelAcessoById(@PathVariable("id") Integer id){
      RequestResponseProtocol<NivelAcesso> resposta = new RequestResponseProtocol<NivelAcesso>();
      try {
         resposta.setValue( nivelAcessoService.getNivelAcessoById(id).get() );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @SecurityRequirement(name = "jwt-authentication")
   @PostMapping("/edit")
   public Object editNivelAcesso(@RequestBody NivelAcesso nivelAcesso){
      return nivelAcessoService.edit(nivelAcesso);
   }

//====================================================================================================================//

}