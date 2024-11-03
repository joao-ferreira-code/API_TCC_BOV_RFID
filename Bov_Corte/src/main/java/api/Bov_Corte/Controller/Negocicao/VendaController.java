package api.Bov_Corte.Controller.Negocicao;

import api.Bov_Corte.Model.Negociacao.Venda;
import api.Bov_Corte.Service.Negociacao.VendaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController 
@RequestMapping("venda")
@SecurityRequirement(name = "jwt-authentication")
@Tag(name = "NEGOCIAÇÃO - Venda", description = "Endpoints relacionados a Venda")
public class VendaController {

   @Autowired
   private VendaService vendaService;

//====================================================================================================================//

   @PostMapping("/create") 
   public Object createVenda(@RequestBody Venda venda){
      return vendaService.create(venda);
   }

//====================================================================================================================//

   @GetMapping("/getAllVenda") 
   public Object getAllVenda(){
      return vendaService.getAllVenda();
   }

   @GetMapping({"/{id}"}) 
   public Object getVendaById(@PathVariable("id") Integer id){
      return vendaService.getVendaById(id);
   }

//====================================================================================================================//

   @PostMapping("/edit") 
   public Object editVenda(@RequestBody Venda venda){
      return vendaService.edit(venda);
   }

//====================================================================================================================//

    @DeleteMapping({"/{id}"})
    public boolean delete(@PathVariable("id") Integer id) {
       return vendaService.delete(id);
    }

//====================================================================================================================//

}