package api.Bov_Corte.Controller.Fazenda;

import api.Bov_Corte.Model.Fazenda.ColaboradorFazenda;
import api.Bov_Corte.Model.Fazenda.VWColaboradorFazenda;
import api.Bov_Corte.Model.Perfil.Usuario;
import api.Bov_Corte.RequestResponseProtocol;
import api.Bov_Corte.Service.Fazenda.ColaboradorFazendaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("colaboradorFazenda")
@SecurityRequirement(name = "jwt-authentication")
@Tag(name = "FAZENDA - Colaborador", description = "Endpoints relacionados aos Colaboradores da Fazenda")
public class ColaboradorFazendaController {

   @Autowired
   private ColaboradorFazendaService colaboradorFazendaService;

//====================================================================================================================//

   @PostMapping("/create")
   public Object createColaboradorFazenda(@RequestBody ColaboradorFazenda colaboradorFazenda){
      RequestResponseProtocol<Boolean> resposta = new RequestResponseProtocol<Boolean>();
      try {
         colaboradorFazendaService.create(colaboradorFazenda);
         resposta.setValue( true );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
         resposta.setValue(false);
      }
      return resposta;
   }

//====================================================================================================================//

   @PostMapping("/getAllByFazenda")
   public Object getAllByFazenda(@RequestBody int fkFazenda){
      RequestResponseProtocol<List<VWColaboradorFazenda>> resposta = new RequestResponseProtocol<List<VWColaboradorFazenda>>();
      try {
         resposta.setValue( colaboradorFazendaService.getAllColaboradorFazenda(fkFazenda) );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
      }
      return resposta;
   }

//====================================================================================================================//

   @GetMapping({"/{id}"})
   public Object getColaboradorFazendaById(@PathVariable("id") Integer id){
      return colaboradorFazendaService.getColaboradorFazendaById(id);
   }

//====================================================================================================================//

   @PostMapping("/edit")
   public Object editColaboradorFazenda(@RequestBody ColaboradorFazenda colaboradorFazenda){
      RequestResponseProtocol<Boolean> resposta = new RequestResponseProtocol<Boolean>();
      try {
         colaboradorFazendaService.edit(colaboradorFazenda);
         resposta.setValue( true );
      }catch (Exception e){
         resposta.setMessage(e.getMessage());
         resposta.setCode(RequestResponseProtocol.ERROR);
         resposta.setValue(false);
      }
      return resposta;
   }

//====================================================================================================================//

    @PostMapping({"/inativarColaboradorFazenda"})
    public Object inativarColaboradorFazenda(@RequestBody ColaboradorFazenda colaboradorFazenda) {
       RequestResponseProtocol<Boolean> resposta = new RequestResponseProtocol<Boolean>();
       try {
          resposta.setValue( colaboradorFazendaService.inativarColaboradorFazenda( colaboradorFazenda ) );
       }catch (Exception e){
          resposta.setMessage(e.getMessage());
          resposta.setCode(RequestResponseProtocol.ERROR);
          resposta.setValue(false);
       }
       return resposta;
    }

//====================================================================================================================//

}