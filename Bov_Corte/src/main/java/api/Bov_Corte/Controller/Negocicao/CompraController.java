package api.Bov_Corte.Controller.Negocicao;

import api.Bov_Corte.Model.Negociacao.Compra;
import api.Bov_Corte.Service.Negociacao.CompraService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController 
@RequestMapping("compra")
@SecurityRequirement(name = "jwt-authentication")
@Tag(name = "NEGOCIAÇÃO - Compra", description = "Endpoints relacionados a Compra")
public class CompraController {

   @Autowired
   private CompraService compraService;

//====================================================================================================================//

   @PostMapping("/create") 
   public Object createCompra(@RequestBody Compra compra){
      return compraService.create(compra);
   }

//====================================================================================================================//

   @GetMapping("/getAllCompra") 
   public Object getAllCompra(){
      return compraService.getAllCompra();
   }

   @GetMapping({"/{id}"}) 
   public Object getCompraById(@PathVariable("id") Integer id){
      return compraService.getCompraById(id);
   }

//====================================================================================================================//

   @PostMapping("/edit") 
   public Object editCompra(@RequestBody Compra compra){
      return compraService.edit(compra);
   }

//====================================================================================================================//

    @DeleteMapping({"/{id}"})
    public boolean delete(@PathVariable("id") Integer id) {
       return compraService.delete(id);
    }

//====================================================================================================================//

}