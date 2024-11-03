package api.Bov_Corte.Controller.Fazenda;

import api.Bov_Corte.Model.Fazenda.FotoFazenda;
import api.Bov_Corte.RequestResponseProtocol;
import api.Bov_Corte.Service.Fazenda.FotoFazendaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("fotoFazenda")
@SecurityRequirement(name = "jwt-authentication")
@Tag(name = "FAZENDA - Foto Fazenda", description = "Endpoints relacionados a Fotografia da Fazenda")
public class FotoFazendaController {

   @Autowired
   private FotoFazendaService fotoFazendaService;

//====================================================================================================================//

   @PostMapping("/create")
   public Object createFotoFazenda(@RequestBody FotoFazenda fotoFazenda){
      RequestResponseProtocol<Boolean> resposta = new RequestResponseProtocol<Boolean>();
      try {
         fotoFazendaService.create(fotoFazenda);
         resposta.setValue( true );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;

   }

//====================================================================================================================//

   @PostMapping("/getFotoPerfilFazenda")
   public Object getFotoPerfilFazenda(@RequestBody Integer fkFazenda){
      RequestResponseProtocol<FotoFazenda> resposta = new RequestResponseProtocol<FotoFazenda>();
      try {
         resposta.setValue( fotoFazendaService.getFotoPerfilFazenda(fkFazenda) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @PostMapping("/getAllFotoByFazenda")
   public Object getAllFotoByFazenda(@RequestBody Integer fkFazenda){
      RequestResponseProtocol<List<FotoFazenda>> resposta = new RequestResponseProtocol<List<FotoFazenda>>();
      try {
         resposta.setValue( fotoFazendaService.getAllFotoByFazenda(fkFazenda) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @PostMapping({"/inativarFotoById"})
   public Object inativarFotoById(@RequestBody Integer id){
      RequestResponseProtocol<Boolean> resposta = new RequestResponseProtocol<Boolean>();
      try {
         resposta.setValue( fotoFazendaService.inativarFotoById(id) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

}