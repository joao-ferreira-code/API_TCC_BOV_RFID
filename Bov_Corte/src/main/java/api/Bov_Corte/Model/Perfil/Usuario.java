package api.Bov_Corte.Model.Perfil;

import api.Bov_Corte.Model.AdmSistema.NivelAcesso;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "usuario")
public class Usuario{//} implements UserDetails { //Sera o espelho da tabela do banco

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "pk_usuario")
    private int pkUsuario;

    @Column(name = "fk_cidade")
    private int fkCidade;

    @Column(name = "tx_nome")
    private String txNome;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Maceio")
    @Column(name = "dt_nascimento")
    private Date dtNascimento;

    @Column(name = "tx_telefone")
    private String txTelefone;

    @Column(name = "tx_login")
    private String txLogin;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "tx_senha")
    private String txSenha;

    @Column(name = "tx_token")
    private String txToken;

    @Column(name = "is_autenticado")
    private boolean autenticado;

    @Column(name = "is_verficado")
    private boolean verficado;

    @Column(name = "is_ativa")
    private boolean ativa;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Maceio")
    @Column(name = "dt_cadastro")
    private Date dtCadastro;

    @Transient
    private String txToken_JWT;

    /*@ManyToMany
    @JoinTable( name = "colaborador_fazenda", joinColumns = @JoinColumn(name = "pk_Usuario"), inverseJoinColumns = @JoinColumn(name = "") )
    private List<NivelAcesso> permisssao;*/

//------------------------------------- UserDetails -------------------------------------//

    /*@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //retornar a lista
        //buscar a lista via service
        return null;
    }

    @Override
    public String getPassword() {
        return this.txSenha;
    }

    @Override
    public String getUsername() {
        return this.txLogin;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }*/

//---------------------------------------------------------------------------------------//

}
