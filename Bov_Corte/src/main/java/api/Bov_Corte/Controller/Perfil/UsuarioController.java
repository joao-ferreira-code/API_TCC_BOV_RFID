package api.Bov_Corte.Controller.Perfil;

import api.Bov_Corte.Config.Security.Autenticacao.jwt.JwtRequest;
import api.Bov_Corte.Model.Perfil.Usuario;
import api.Bov_Corte.Model.Perfil.UsuarioCadastro;
import api.Bov_Corte.RequestResponseProtocol;
import api.Bov_Corte.Service.Perfil.UsuarioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("usuario")
@Tag(name = "PERFIL - Usuario", description = "Endpoints relacionados ao Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

//====================================================================================================================//
//============================= METODOS PUBLICOS - NAO REQUER AUTENTICACAO OU AUTORIZACAO ============================//
//====================================================================================================================//

    @GetMapping("/ola")
    public Object createUser(){

        return "Ola Porra";
    }

    @PostMapping("/create")
    public Object createUser(@RequestBody UsuarioCadastro usuario){
        RequestResponseProtocol<Boolean> resposta = new RequestResponseProtocol<Boolean>();
        try {
            resposta.setValue( usuarioService.createUser(usuario) );
        }catch (Exception e){
            resposta.setMessage(e.getMessage());
            resposta.setCode(RequestResponseProtocol.ERROR);
            resposta.setValue(false);
        }
        return resposta;
    }

//====================================================================================================================//

    @PostMapping("/autenticar")
    public Object autenticar(@RequestBody JwtRequest jwtRequest){
        RequestResponseProtocol<Usuario> resposta = new RequestResponseProtocol<Usuario>();
        try {
            resposta.setValue( usuarioService.autenticar(jwtRequest.getUsername(), jwtRequest.getPassword()) );
        }catch (Exception e){
            resposta.setMessage(e.getMessage());
            resposta.setCode(RequestResponseProtocol.ERROR);
        }
        return resposta;
    }

//====================================================================================================================//

    @GetMapping("/validarToken/{token}")
    public String autenticar(@PathVariable("token") String token) throws Exception {
        return usuarioService.validarRegistro(token) ;
    }

//====================================================================================================================//

    @GetMapping("/isEmailValido/{email}")
    public Object emailValido(@PathVariable("email") String email){
        RequestResponseProtocol<Boolean> resposta = new RequestResponseProtocol<Boolean>();
        try {
            resposta.setValue( usuarioService.isEmailValido(email) );
        }catch (Exception e){
            resposta.setMessage(e.getMessage());
            resposta.setCode(RequestResponseProtocol.ERROR);
        }
        return resposta;
    }

//====================================================================================================================//

    @GetMapping("/reiviarEmailValidacao/{email}")
    public Object reiviarEmailValidacao(@PathVariable("email") String email){
        RequestResponseProtocol<Boolean> resposta = new RequestResponseProtocol<Boolean>();
        try {
            resposta.setValue( usuarioService.reiviarEmailValidacao(email) );
        }catch (Exception e){
            resposta.setMessage(e.getMessage());
            resposta.setCode(RequestResponseProtocol.ERROR);
        }
        return resposta;
    }

//====================================================================================================================//

    @PostMapping("/buscarUsuario")
    public Object buscarUsuario(@RequestBody String email){
        RequestResponseProtocol<Usuario> resposta = new RequestResponseProtocol<Usuario>();
        try {
            resposta.setValue( usuarioService.buscarUsuario(email) );
        }catch (Exception e){
            resposta.setMessage(e.getMessage());
            resposta.setCode(RequestResponseProtocol.ERROR);
        }
        return resposta;
    }

//====================================================================================================================//
//============================== METODOS PRIVADOS - REQUER AUTENTICACAO E/OU AUTORIZACAO =============================//
//====================================================================================================================//

    @SecurityRequirement(name = "jwt-authentication")
    @PostMapping("/editarDadosUsuario")
    public Object editarDadosUsuario(@RequestBody List<String> dadosAcesso){
        RequestResponseProtocol<Boolean> resposta = new RequestResponseProtocol<Boolean>();
        try {
            resposta.setValue( usuarioService.editarDadosUsuario(dadosAcesso) );
        }catch (Exception e){
            resposta.setMessage(e.getMessage());
            resposta.setCode(RequestResponseProtocol.ERROR);
        }
        return resposta;
    }

//====================================================================================================================//

    @SecurityRequirement(name = "jwt-authentication")
    @PostMapping("/editarSenha")
    public Object editarSenha(@RequestBody List<String> dadosAcesso){
        RequestResponseProtocol<Boolean> resposta = new RequestResponseProtocol<Boolean>();
        try {
            resposta.setValue( usuarioService.editarSenha(dadosAcesso) );
        }catch (Exception e){
            resposta.setMessage(e.getMessage());
            resposta.setCode(RequestResponseProtocol.ERROR);
        }
        return resposta;
    }

//====================================================================================================================//

}
