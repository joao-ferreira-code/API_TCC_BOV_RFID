package api.Bov_Corte.Service.Perfil;

import api.Bov_Corte.Config.Security.Autenticacao.jwt.JwtTokenUtil;
import api.Bov_Corte.Config.Security.Autenticacao.jwt.JwtUserDetailsService;
import api.Bov_Corte.Model.Perfil.FotoUsuario;
import api.Bov_Corte.Model.Perfil.UsuarioCadastro;
import api.Bov_Corte.Service._Notificacao.Notificacao_Service;
import api.Bov_Corte.GerarValoresAleatorios;
import api.Bov_Corte.Model.Perfil.Usuario;
import api.Bov_Corte.Repository.Perfil.UsuarioRepository;
import api.Bov_Corte._PageView_HTML.ValidacaoCadastroUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UsuarioService {//implements UserDetailsService {

   @Autowired
   private UsuarioRepository usuarioRepository;

   @Autowired
   private FotoUsuarioService fotoUsuarioService;

   @Autowired
   private Notificacao_Service notificacao_service;

   @Autowired
   private PasswordEncoder passwordEncoder;

   @Autowired
   private AuthenticationManager authenticationManager;

   @Autowired
   private JwtUserDetailsService userDetailsService;

   @Autowired
   private JwtTokenUtil jwtTokenUtil;

//====================================================================================================================//


   /*@Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      try {
         Usuario usuario = usuarioRepository.findByTxLogin(username);

         //System.out.println("PERMISSOES CONCEDIDAS AO USUARIO"+usuario.getPermissaoUsuario().size());

         if (usuario != null) {
            return new User(usuario.getTxLogin(), usuario.getTxSenha(),
                    new ArrayList<>());
         } else {
            throw new UsernameNotFoundException("E-mail e/ou Senha Incorreta(s)!");
         }
      }catch (Exception e){
         e.printStackTrace();
      }
      return null;
   }*/


//====================================================================================================================//

   @Transactional
   public boolean createUser(UsuarioCadastro usuarioCad) throws Exception {

      Usuario usuario = usuarioCad.toUsuario();
      Usuario possuiRegistro = usuarioRepository.findByTxLogin(usuario.getTxLogin());
      if(possuiRegistro!=null){
         throw new Exception("Credenciais Invalidas!" +
                 "Tente novamente ou contate nosso time de suporte para solicitar ajuda.");
      }
    //----------------------------------------------------------------------------------------------//
      usuario.setTxToken( new GerarValoresAleatorios().gerarToken() );
      usuario.setTxSenha(passwordEncoder.encode(usuario.getTxSenha()));
      Usuario usuarioCadastrado = usuarioRepository.save(usuario);

      if(usuarioCadastrado==null){
         throw new Exception("Comportamento Insesperado!" +
                 "Tente novamente ou entre em contato com nosso time de suporte para solicitar ajuda.");
      }

      if(usuarioCad.getBtFotoUsuario() != null) {
         FotoUsuario fto = new FotoUsuario();
         fto.setFkUsuario(usuarioCadastrado.getPkUsuario());
         fto.setBtFotoUsuario(usuarioCad.getBtFotoUsuario());
         fto.setAtiva(true);
         fto.setDtCadastro(new Date());
         fotoUsuarioService.create(fto);
      }
    //---------------------------------------------------------------------------------------------//
      notificacao_service.notificarCadastro(usuarioCadastrado);
    //---------------------------------------------------------------------------------------------//
      return true;
   }

//====================================================================================================================//

   public Usuario autenticar(String login, String senha) throws Exception {
      authenticate(login, senha);

      final UserDetails userDetails = userDetailsService.loadUserByUsername(login);

      Usuario usuario = usuarioRepository.findByTxLogin(login);

      if(usuario != null && passwordEncoder.matches(senha, usuario.getTxSenha()) ) {
         if (!usuario.isAutenticado()) {
            throw new Exception("Usuario não autenticado!\n " +
                    "Na realização do seu cadastro, enviamos um email de autenticação que precisa ser validado. \n" +
                    "Caso não tenha recebido o referido email entre contato com nosso time de suporte para solicitar ajuda.");
         }
      }
      usuario.setTxToken_JWT( jwtTokenUtil.generateToken(userDetails) );

      return usuario;
   }

//--------------------------------------------------------------------------------------------------------------------//

   private void authenticate(String username, String password) throws Exception {
      try {
         authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
      } catch (DisabledException e) {
         throw new Exception("Usuário Desativado", e);
      } catch (BadCredentialsException e) {
         throw new Exception("Usuário e/ou Senha Invalido(s)", e);
      }
   }

//====================================================================================================================//

   public String validarRegistro(String token) throws Exception {
      Usuario usuarioCadstrado = usuarioRepository.findByTxToken(token);
      if(usuarioCadstrado==null){
         return new  ValidacaoCadastroUsuario().gerarPaginaAlerta();
      }

      if(!usuarioCadstrado.isAutenticado() ){
         usuarioCadstrado.setAutenticado(true);
         Usuario usuarioautenticado = usuarioRepository.save(usuarioCadstrado);

         if(usuarioautenticado==null){
            return new  ValidacaoCadastroUsuario().gerarPaginaError();
         }
      }
      return new  ValidacaoCadastroUsuario().gerarPaginaSucesso();
   }

//====================================================================================================================//

   public Object getAllUsuariosCadastrados() {
      return usuarioRepository.findAll();
   }

//====================================================================================================================//

   public Boolean isEmailValido(String email) {
      Usuario possuiRegistro = usuarioRepository.findByTxLogin(email);
      if(possuiRegistro!=null){
         return false;
      }
      return true;
   }

//====================================================================================================================//

   @Transactional
   public Boolean reiviarEmailValidacao(String email) {
      Usuario usuario = usuarioRepository.findByTxLogin(email);
      return notificacao_service.notificarCadastro(usuario);
   }

//====================================================================================================================//

   public Usuario buscarUsuario(String email) {
      Usuario usuario = usuarioRepository.findByTxLogin(email);
      if(usuario != null){
         Usuario ub = new Usuario();
         ub.setPkUsuario(usuario.getPkUsuario());
         ub.setTxNome(usuario.getTxNome());
         ub.setTxLogin(usuario.getTxLogin());
         return ub;
      }
      return null;
   }

//====================================================================================================================//
//============================== METODOS PRIVADOS - REQUER AUTENTICACAO E/OU AUTORIZACAO =============================//
//====================================================================================================================//

   public Boolean editarDadosUsuario(List<String> dadosUsuario) throws ParseException {
      Usuario usuario = usuarioRepository.findByPkUsuarioAndTxLogin( Integer.parseInt( dadosUsuario.get(0) ), dadosUsuario.get(1));
      if(usuario != null){
         usuario.setTxNome( dadosUsuario.get(2) );

         SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
         Date data = formato.parse(dadosUsuario.get(3));
         usuario.setDtNascimento( data );

         usuario.setTxTelefone( dadosUsuario.get(4) );
         usuario.setFkCidade( Integer.parseInt(dadosUsuario.get(5)) );

         usuarioRepository.save(usuario);
      }
      return true;
   }

//====================================================================================================================//

   @Transactional
   public boolean editarSenha(List<String> dadosAcesso) throws Exception {
      Usuario usuario = autenticar( dadosAcesso.get(0), dadosAcesso.get(1) );
      if(usuario != null) {
         usuario.setTxSenha(passwordEncoder.encode(dadosAcesso.get(2)));
         usuarioRepository.save(usuario);
      }
      return true;
   }

//====================================================================================================================//

}