package api.Bov_Corte.Config.Email;

public interface Notificacao { //Caso seja utilizado mais de uma Estrutura para envio de notificacaoes

    boolean enviarNotificacao(ParametrosEmail mensagem);

}
