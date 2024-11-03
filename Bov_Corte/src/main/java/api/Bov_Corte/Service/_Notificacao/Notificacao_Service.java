package api.Bov_Corte.Service._Notificacao;

import api.Bov_Corte.Config.Email.EmailNotificacao_Service;
import api.Bov_Corte.Config.Email.ParametrosEmail;
import api.Bov_Corte.Model.Perfil.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Notificacao_Service {

    @Autowired
    private EmailNotificacao_Service notificacaoEmail;

//------------------------------------------------------------------------//

    @Value("${nome-fantasia}")
    private String nomeFantasia;

    @Value("${url-base}")
    private String urlBase;

//====================================================================================================================//

    public boolean notificarCadastro(Usuario usuario){
        try {
            String msgRegistroUsuario =
                    "Olá, " + usuario.getTxNome() + "!\n" +
                    "Sua conta no " + nomeFantasia + " está quase pronta. Para ativá-la, " +
                            "por favor confirme o seu endereço de email clicando no link abaixo.\n\n" +
                    urlBase + "/usuario/validarToken/" + usuario.getTxToken() + "\n\n" +
                    "Sua conta não será ativada até que seu email seja confirmado.\n" +
                    "Se você não se cadastrou no " + nomeFantasia + " recentemente, por favor ignore este email.\n" +
                    "\n" +
                    "Atensiosamente, " + nomeFantasia + ".";

            ParametrosEmail parametrosEmail = new ParametrosEmail( nomeFantasia + " - Confirmar Cadastro!.", msgRegistroUsuario, usuario.getTxLogin());
            return notificacaoEmail.enviarNotificacao(parametrosEmail);

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

//====================================================================================================================//

    public boolean esqueciMinhaSenha(Usuario usuario, String token){
        String msgRedefinicaoSenha =
                "Olá, "+usuario.getTxNome()+",\n" +
                "Recebemos uma solicitação para restaurar sua senha de acesso ao sistema do " + nomeFantasia + ".\n" +
                "Se você reconhece essa ação, clique no link abaixo para prosseguir:\n\n" +
                urlBase + "/recuperarSenha/solicitarNovaSenha/"+ token +"\n\n" +
                "Atensiosamente, " + nomeFantasia + ".";

        ParametrosEmail parametrosEmail = new ParametrosEmail(nomeFantasia + " - Redefinir Senha!.", msgRedefinicaoSenha, usuario.getTxLogin());
        return notificacaoEmail.enviarNotificacao(parametrosEmail);
    }

//====================================================================================================================//

    public boolean novaSenha(Usuario usuario, String novaSenha){
        String msgNovaSenha =
                "Olá, "+usuario.getTxNome()+",\n" +
                "Redefinimos sua senha de acesso para o sistema do " + nomeFantasia + ".\n\n" +
                "Sua nova senha é: " + novaSenha +"\n\n" +
                "Atensiosamente, " + nomeFantasia + ".";

        ParametrosEmail parametrosEmail = new ParametrosEmail(nomeFantasia +  " - Nova Senha!.", msgNovaSenha, usuario.getTxLogin());
        return notificacaoEmail.enviarNotificacao(parametrosEmail);
    }

//====================================================================================================================//

}
