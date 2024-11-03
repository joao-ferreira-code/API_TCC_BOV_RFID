package api.Bov_Corte.Config.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailNotificacao_Service implements Notificacao {

    @Autowired
    private JavaMailSender javaMailSender;

//------------------------------------------------------------------------//

    @Value("${bov-corte.email}")
    private String tipoEnvio;

//====================================================================================================================//

    @Override
    public boolean enviarNotificacao(ParametrosEmail parametrosEmail) {
        try{
            if(tipoEnvio.toUpperCase().equals("FAKE")){
                return fakeMail(parametrosEmail);
            }else{
                return simpleMailMessage(parametrosEmail);
            }

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

//====================================================================================================================//

    private boolean simpleMailMessage(ParametrosEmail parametrosEmail){
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(parametrosEmail.getDestinatario());
            message.setSubject(parametrosEmail.getTitulo());
            message.setText(parametrosEmail.getMensagem());

            javaMailSender.send(message);
            System.out.println("Email enviado com sucesso!");

            return true;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Erro ao enviar email.");
            return false;
        }
    }

//====================================================================================================================//

    private boolean fakeMail(ParametrosEmail parametrosEmail){
        try{
            System.out.println("\nPARA: "+parametrosEmail.getDestinatario());
            System.out.println("TITULO: "+parametrosEmail.getTitulo());
            System.out.println("MSG: "+parametrosEmail.getMensagem()+"\n");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Erro ao enviar email.");
            return false;
        }
    }

//====================================================================================================================//

}
