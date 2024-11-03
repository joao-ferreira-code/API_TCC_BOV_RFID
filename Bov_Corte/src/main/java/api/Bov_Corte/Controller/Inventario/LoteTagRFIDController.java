package api.Bov_Corte.Controller.Inventario;

import api.Bov_Corte.Model.Inventario.LoteTagRFID;
import api.Bov_Corte.Model.Inventario.LoteVacina;
import api.Bov_Corte.RequestResponseProtocol;
import api.Bov_Corte.Service.Inventario.LoteTagRFIDService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController 
@RequestMapping("loteTagRFID")
@SecurityRequirement(name = "jwt-authentication")
@Tag(name = "INVENTARIO - Lote Tag RFID", description = "Endpoints relacionados aos Lotes de Tags RFID")
public class LoteTagRFIDController {

   @Autowired
   private LoteTagRFIDService loteTagRFIDService;

//====================================================================================================================//

   @PostMapping("/create") 
   public Object createLoteTagRFID(@RequestBody LoteTagRFID loteTagRFID){
      RequestResponseProtocol<Boolean> resposta = new RequestResponseProtocol<Boolean>();
      try {
         loteTagRFIDService.create(loteTagRFID);
         resposta.setValue( true );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
         resposta.setValue(false);
      }
      return resposta;
   }

//====================================================================================================================//

   @GetMapping("/getAllLoteTagRFIDByFazenda/{id}")
   public Object getAllLoteTagRFIDByFazenda(@PathVariable("id") Integer fkFazenda){
      RequestResponseProtocol<List<LoteTagRFID>> resposta = new RequestResponseProtocol<List<LoteTagRFID>>();
      try {
         resposta.setValue( loteTagRFIDService.getAllLoteTagRFID(fkFazenda) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @GetMapping({"/{id}"}) 
   public Object getLoteTagRFIDById(@PathVariable("id") Integer id){
      RequestResponseProtocol<LoteTagRFID> resposta = new RequestResponseProtocol<LoteTagRFID>();
      try {
         resposta.setValue( loteTagRFIDService.getLoteTagRFIDById(id).get() );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @PostMapping("/edit") 
   public Object editLoteTagRFID(@RequestBody LoteTagRFID loteTagRFID){
      return loteTagRFIDService.edit(loteTagRFID);
   }

//====================================================================================================================//

    @DeleteMapping({"/{id}"})
    public boolean delete(@PathVariable("id") Integer id) {
       return loteTagRFIDService.delete(id);
    }

//====================================================================================================================//

}