package api.Bov_Corte.Controller.Bovino;

import api.Bov_Corte.Model.Bovino.CompraBovino;
import api.Bov_Corte.Service.Bovino.CompraBovinoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController 
@RequestMapping("compraBovino")
@SecurityRequirement(name = "jwt-authentication")
@Tag(name = "BOVINO - Compra", description = "Endpoints relacionados a Compra")
public class CompraBovinoController {

   @Autowired
   private CompraBovinoService compraBovinoService;

//====================================================================================================================//

   @PostMapping("/create") 
   public Object createCompraBovino(@RequestBody CompraBovino compraBovino){
      return compraBovinoService.create(compraBovino);
   }

//====================================================================================================================//

   @GetMapping("/getAllCompraBovino") 
   public Object getAllCompraBovino(){
      return compraBovinoService.getAllCompraBovino();
   }

   @GetMapping({"/{id}"}) 
   public Object getCompraBovinoById(@PathVariable("id") Integer id){
      return compraBovinoService.getCompraBovinoById(id);
   }

//====================================================================================================================//

   @PostMapping("/edit") 
   public Object editCompraBovino(@RequestBody CompraBovino compraBovino){
      return compraBovinoService.edit(compraBovino);
   }

//====================================================================================================================//

    @DeleteMapping({"/{id}"})
    public boolean delete(@PathVariable("id") Integer id) {
       return compraBovinoService.delete(id);
    }

//====================================================================================================================//

}