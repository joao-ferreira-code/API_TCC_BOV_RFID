package api.Bov_Corte.Controller.Perfil;

import api.Bov_Corte.Model.Perfil.FotoUsuario;
import api.Bov_Corte.RequestResponseProtocol;
import api.Bov_Corte.Service.Perfil.FotoUsuarioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("fotoUsuario")
@Tag(name = "PERFIL - Foto Usuario", description = "Endpoints relacionados a Fotografia do Usuario")
public class FotoUsuarioController {

   @Autowired
   private FotoUsuarioService fotoUsuarioService;

//====================================================================================================================//

   @PostMapping("/create")
   public Object createFotoUsuario(@RequestBody FotoUsuario fotoUsuario){
      RequestResponseProtocol<Boolean> resposta = new RequestResponseProtocol<Boolean>();
      try {
         resposta.setValue( fotoUsuarioService.create(fotoUsuario) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @SecurityRequirement(name = "jwt-authentication")
   @GetMapping("/getAllFotoUsuarioAtiva")
   public Object getAllFotoUsuarioAtiva(){
      RequestResponseProtocol<List<FotoUsuario>> resposta = new RequestResponseProtocol<List<FotoUsuario>>();
      try {
         resposta.setValue( fotoUsuarioService.getAllFotoUsuarIsAtiva(true) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @SecurityRequirement(name = "jwt-authentication")
   @PostMapping("/getFotoAtivaByUsuario")
   public Object getFotoAtivaByUsuario(@RequestBody Integer fkUsuario){
      RequestResponseProtocol<FotoUsuario> resposta = new RequestResponseProtocol<FotoUsuario>();
      try {
         resposta.setValue( fotoUsuarioService.getFotoAtivaByUsuario(fkUsuario) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @SecurityRequirement(name = "jwt-authentication")
   @GetMapping({"/{id}"})
   public Object getFotoUsuarioById(@PathVariable("id") Integer id){
      RequestResponseProtocol<FotoUsuario> resposta = new RequestResponseProtocol<FotoUsuario>();
      try {
         resposta.setValue( fotoUsuarioService.getFotoUsuarioById(id).get() );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

}