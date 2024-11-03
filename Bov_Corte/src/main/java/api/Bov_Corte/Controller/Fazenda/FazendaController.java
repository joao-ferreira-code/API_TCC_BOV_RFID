package api.Bov_Corte.Controller.Fazenda;

import api.Bov_Corte.Model.Fazenda.Fazenda;
import api.Bov_Corte.Model.Fazenda.VWDadosFazenda;
import api.Bov_Corte.RequestResponseProtocol;
import api.Bov_Corte.Service.Fazenda.FazendaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("fazenda")
@SecurityRequirement(name = "jwt-authentication")
@Tag(name = "FAZENDA - Fazenda", description = "Endpoints relacionados a Fazenda")
public class FazendaController {

   @Autowired
   private FazendaService fazendaService;

//====================================================================================================================//

   @PostMapping("/create")
   public Object createFazenda(@RequestBody Fazenda fazenda){
      RequestResponseProtocol<Fazenda> resposta = new RequestResponseProtocol<Fazenda>();
      try {
         resposta.setValue( fazendaService.create(fazenda) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
         resposta.setValue(null);
      }
      return resposta;
   }

//====================================================================================================================//

   @PostMapping("/getAllFazendasAtivaByColaborador")
   public Object getAllFazendasAtivaByColaborador(@RequestBody int usuNrId){
      RequestResponseProtocol<List<Fazenda>> resposta = new RequestResponseProtocol<List<Fazenda>>();
      try {
         resposta.setValue( fazendaService.getAllFazendasAtivaByColaborador(usuNrId) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
         resposta.setValue(null);
      }
      return resposta;
   }

//====================================================================================================================//

   @PostMapping("/edit")
   public Object editFazenda(@RequestBody Fazenda fazenda){
      RequestResponseProtocol<Fazenda> resposta = new RequestResponseProtocol<Fazenda>();
      try {
         resposta.setValue( fazendaService.edit(fazenda) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
         resposta.setValue(null);
      }
      return resposta;
   }

//====================================================================================================================//

   @PostMapping({"/inativarFazenda"})
   public Object inativarFazenda(@RequestBody Integer[] param){
      RequestResponseProtocol<Boolean> resposta = new RequestResponseProtocol<>();
      try {
         resposta.setValue( fazendaService.inativarFazendaByPkFazendaAndFkUsuario(param[0], param[1]) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
         resposta.setValue(null);
      }
      return resposta;
   }

//====================================================================================================================//

   @PostMapping("/buscarFazendaByCodigoPublico")
   public Object buscarFazendaByCodigoPublico(@RequestBody String codigoPublico){
      RequestResponseProtocol<VWDadosFazenda> resposta = new RequestResponseProtocol<>();
      try {
         resposta.setValue( fazendaService.buscarFazendaByCodigoPublico(codigoPublico) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

}