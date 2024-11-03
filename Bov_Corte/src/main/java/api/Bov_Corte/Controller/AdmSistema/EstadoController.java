package api.Bov_Corte.Controller.AdmSistema;

import api.Bov_Corte.Model.AdmSistema.Estado;
import api.Bov_Corte.RequestResponseProtocol;
import api.Bov_Corte.Service.AdmSistema.EstadoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("estado")
@Tag(name = "ADMINISTRAÇÃO SISTEMA - Estado", description = "Endpoints relacionados ao Estado")
public class EstadoController {

   @Autowired
   private EstadoService estadoService;

//====================================================================================================================//

   @SecurityRequirement(name = "jwt-authentication")
   @PostMapping("/create")
   public Object createEstado(@RequestBody Estado estado){
      return estadoService.create(estado);
   }

//====================================================================================================================//

   @GetMapping("/getAllEstado")
   public Object getAllEstado(){
      RequestResponseProtocol<List<Estado>> resposta = new RequestResponseProtocol<List<Estado>>();
      try {
         resposta.setValue( estadoService.getAllEstado() );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @GetMapping("/{id}")
   public Object getEstadoById(@PathVariable("id") int id){
      RequestResponseProtocol<Estado> resposta = new RequestResponseProtocol<Estado>();
      try {
         resposta.setValue( estadoService.getEstadoById(id).get() );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

}