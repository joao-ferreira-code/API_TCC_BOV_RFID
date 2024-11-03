package api.Bov_Corte.Config.Email;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ParametrosEmail {

    private String titulo;
    private String mensagem;
    private String destinatario;

//====================================================================================================================//

    public ParametrosEmail(String titulo, String mensagem, String destinatario) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.destinatario = destinatario;
    }

//====================================================================================================================//


}
