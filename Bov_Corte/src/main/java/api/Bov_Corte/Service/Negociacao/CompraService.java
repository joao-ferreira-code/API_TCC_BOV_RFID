package api.Bov_Corte.Service.Negociacao;

import api.Bov_Corte.Model.Negociacao.Compra;
import api.Bov_Corte.Repository.Negociacao.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

   @Autowired
   private CompraRepository compraRepository;

//====================================================================================================================//

   public Compra create(Compra compra){
      return compraRepository.save(compra);
   }

//====================================================================================================================//

   public List<Compra> getAllCompra(){
      return (List<Compra>)compraRepository.findAll();
   }

   public Optional<Compra> getCompraById(int id){
      return compraRepository.findById(id);
   }

//====================================================================================================================//

   public Compra edit(Compra compra){
      return compraRepository.save(compra);
   }

//====================================================================================================================//

    public boolean delete(int id) {
       if (compraRepository.existsById(id)) {
           compraRepository.deleteById(id);
       }
       return true;
    }

//====================================================================================================================//

}