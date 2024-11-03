package api.Bov_Corte.Model.Perfil;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
public class UsuarioCadastro { //Sera o espelho da tabela do banco

    private int pkUsuario;

    private int fkCidade;

    private String txNome;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Maceio")
    private Date dtNascimento;

    private String txTelefone;

    private String txLogin;

    private String txSenha;

    private String txToken;

    private boolean autenticado;

    private boolean verficado;

    private boolean ativa ;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Maceio")
    private Date dtCadastro;

    private byte[] btFotoUsuario;


    public Usuario toUsuario(){
        Usuario user = new Usuario();
        user.setFkCidade(fkCidade);
        user.setTxNome(txNome);
        user.setDtNascimento(dtNascimento);
        user.setTxTelefone(txTelefone);
        user.setTxLogin(txLogin);
        user.setTxSenha(txSenha);
        user.setTxToken(txToken);
        user.setAutenticado(false);
        user.setVerficado(false);
        user.setAtiva(true);
        user.setDtCadastro(new Date());
        return user;
    }
}
