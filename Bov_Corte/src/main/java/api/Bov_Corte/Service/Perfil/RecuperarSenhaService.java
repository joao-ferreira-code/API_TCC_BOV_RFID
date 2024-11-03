package api.Bov_Corte.Service.Perfil;

import api.Bov_Corte.Service._Notificacao.Notificacao_Service;
import api.Bov_Corte.GerarValoresAleatorios;
import api.Bov_Corte.Model.Perfil.RecuperarSenha;
import api.Bov_Corte.Model.Perfil.Usuario;
import api.Bov_Corte.Repository.Perfil.RecuperarSenhaRepository;
import api.Bov_Corte.Repository.Perfil.UsuarioRepository;
import api.Bov_Corte._PageView_HTML.ValidacaoCadastroUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

@Service
public class RecuperarSenhaService {

   @Autowired
   private RecuperarSenhaRepository recuperarSenhaRepository;

   @Autowired
   private UsuarioRepository usuarioRepository;

   @Autowired
   private Notificacao_Service notificacao_service;

   @Autowired
   private PasswordEncoder passwordEncoder;

   @Value("${validade-token-recuperacao-senha}")
   private int validadeToken;

//====================================================================================================================//

   @Transactional
   public boolean create(String email) throws Exception {
      Usuario usuario = usuarioRepository.findByTxLogin(email);
      if(usuario == null){
         throw new Exception("E-mail invalido e/ou não encontrado!");
      }

      RecuperarSenha recuperarSenha = new RecuperarSenha();
      recuperarSenha.setAtiva(true);
      recuperarSenha.setFkUsuario(usuario.getPkUsuario());
      recuperarSenha.setTxToken( new GerarValoresAleatorios().gerarToken() );
      recuperarSenha.setDtCadastro(new Date());
      recuperarSenhaRepository.save(recuperarSenha);

      notificacao_service.esqueciMinhaSenha(usuario, recuperarSenha.getTxToken());
      return true;
   }

//====================================================================================================================//

   @Transactional
   public String solicitarNovaSenha(String token) throws Exception {
      RecuperarSenha recuperarSenha = recuperarSenhaRepository.findByTxToken(token);

      if(!recuperarSenha.isAtiva() && !tokenIsDataAtivo(recuperarSenha)){
         throw new Exception("Token Invalido e/ou Inspirado!");
      }
      recuperarSenha.setAtiva(false);

      Optional<Usuario> usuario = usuarioRepository.findById( recuperarSenha.getFkUsuario() );

      String novaSenha = new GerarValoresAleatorios().gerarToken();

      if(usuario.isPresent()){
         usuario.get().setTxSenha( passwordEncoder.encode(novaSenha) );
         usuarioRepository.save(usuario.get());
         notificacao_service.novaSenha(usuario.get(), novaSenha);
         return new ValidacaoCadastroUsuario().gerarPagiaSenhaGerada();
      }
      return new ValidacaoCadastroUsuario().gerarPaginaError();
   }

//====================================================================================================================//

   public boolean tokenIsDataAtivo(RecuperarSenha recuperarSenha) {
      GregorianCalendar calendar = new GregorianCalendar();
      calendar.setTime(recuperarSenha.getDtCadastro());
      calendar.add(calendar.MINUTE, validadeToken);
      return calendar.getTime().after(new Date());
   }


}