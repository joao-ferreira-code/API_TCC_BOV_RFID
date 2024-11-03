package api.Bov_Corte.Controller.Bovino;

import api.Bov_Corte.Model.Bovino.FotoBovino;
import api.Bov_Corte.RequestResponseProtocol;
import api.Bov_Corte.Service.Bovino.FotoBovinoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("fotoBovino")
@SecurityRequirement(name = "jwt-authentication")
@Tag(name = "BOVINO - Foto Bovino", description = "Endpoints relacionados a Fotografia do Bovino")
public class FotoBovinoController {

   @Autowired
   private FotoBovinoService fotoBovinoService;

//====================================================================================================================//

   @PostMapping("/create")
   public Object createFotoBovino(@RequestBody FotoBovino fotoBovino){
      RequestResponseProtocol<Boolean> resposta = new RequestResponseProtocol<Boolean>();
      try {
         fotoBovinoService.create(fotoBovino);
         resposta.setValue( true );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;

   }

//====================================================================================================================//

   @PostMapping("/getFotoPerfilAnimal")
   public Object getFotoPerfilAnimal(@RequestBody Integer fkAnimal){
      RequestResponseProtocol<FotoBovino> resposta = new RequestResponseProtocol<FotoBovino>();
      try {
         resposta.setValue( fotoBovinoService.getFotoPerfilAnimal(fkAnimal) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @PostMapping("/getAllFotoByAnimal")
   public Object getAllFotoByAnimal(@RequestBody Integer fkAnimal){
      RequestResponseProtocol<List<FotoBovino>> resposta = new RequestResponseProtocol<List<FotoBovino>>();
      try {
         resposta.setValue( fotoBovinoService.getAllFotoByAtivaBovino(fkAnimal) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @GetMapping({"/{id}"})
   public Object getFotoFazendaById(@PathVariable("id") Integer id){
      return fotoBovinoService.getFotoFazendaById(id);
   }

//====================================================================================================================//

}