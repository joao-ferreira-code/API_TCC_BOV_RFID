package api.Bov_Corte.Controller.Perfil;

import api.Bov_Corte.RequestResponseProtocol;
import api.Bov_Corte.Service.Perfil.RecuperarSenhaService;
import api.Bov_Corte._PageView_HTML.ValidacaoCadastroUsuario;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("recuperarSenha")
@Tag(name = "PERFIL - Recuperar Senha", description = "Endpoints relacionados a Recuperação de Senha")
public class RecuperarSenhaController {

   @Autowired
   private RecuperarSenhaService recuperarSenhaService;

//====================================================================================================================//

   @PostMapping("/esqueciMinhaSenha")
   public Object esqueciMinhaSenha(@RequestBody String email){
      RequestResponseProtocol<Boolean> resposta = new RequestResponseProtocol<Boolean>();
      try {
         resposta.setValue( recuperarSenhaService.create(email) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @GetMapping("/solicitarNovaSenha/{token}")
   public String solicitarNovaSenha(@PathVariable("token") String token){
      try {
         return recuperarSenhaService.solicitarNovaSenha(token);
      }catch (Exception e){
         return new ValidacaoCadastroUsuario().gerarPaginaError();
      }

   }

//====================================================================================================================//

}