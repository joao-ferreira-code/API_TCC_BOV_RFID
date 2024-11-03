package api.Bov_Corte.Service.Negociacao;

import api.Bov_Corte.Model.Negociacao.Venda;
import api.Bov_Corte.Repository.Negociacao.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

   @Autowired
   private VendaRepository vendaRepository;

//====================================================================================================================//

   public Venda create(Venda venda){
      return vendaRepository.save(venda);
   }

//====================================================================================================================//

   public List<Venda> getAllVenda(){
      return (List<Venda>)vendaRepository.findAll();
   }

   public Optional<Venda> getVendaById(int id){
      return vendaRepository.findById(id);
   }

//====================================================================================================================//

   public Venda edit(Venda venda){
      return vendaRepository.save(venda);
   }

//====================================================================================================================//

    public boolean delete(int id) {
       if (vendaRepository.existsById(id)) {
           vendaRepository.deleteById(id);
       }
       return true;
    }

//====================================================================================================================//

}