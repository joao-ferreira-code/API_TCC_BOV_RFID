package api.Bov_Corte.Controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("teste")
@SecurityRequirement(name = "jwt-authentication")
@Tag(name = "Testes", description = "Endpoints para testes")
public class Testes_Controller {
    private int solicitacoesPublicas = 0;
    private int solicitacoesPrivadas = 0;

//====================================================================================================================//

    @GetMapping("pulic/{valor}")
    public ResponseEntity pulic(@PathVariable("valor") String valor){
        printarValor(solicitacoesPublicas++, valor);
        return ResponseEntity.ok( "Olá Mundo!" );
    }

//====================================================================================================================//

    @GetMapping("private/auth/{valor}")
    public ResponseEntity olaMundo(@PathVariable("valor") String valor){
        printarValor(solicitacoesPrivadas++, valor);
        return ResponseEntity.ok( "Olá Mundo!" );
    }

//====================================================================================================================//
//====================================================================================================================//

    private void printarValor(int nrSolicitacao, String valor){
        System.out.println("SOLICITACAO:    " + nrSolicitacao);
        System.out.println("VALOR RECEBIDO: " + valor);
    }


}
