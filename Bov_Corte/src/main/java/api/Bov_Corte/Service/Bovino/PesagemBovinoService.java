package api.Bov_Corte.Service.Bovino;

import api.Bov_Corte.Model.Bovino.PesagemBovino;
import api.Bov_Corte.Repository.Bovino.PesagemBovinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PesagemBovinoService {

   @Autowired
   private PesagemBovinoRepository pesagemBovinoRepository;

//====================================================================================================================//

   public PesagemBovino create(PesagemBovino pesagemBovino){
      pesagemBovino.setDtCadastro(new Date());
      return pesagemBovinoRepository.save(pesagemBovino);
   }

//====================================================================================================================//

   public List<PesagemBovino> getAllPesagemByBovinoAndFazeda(int fkAnimal, int fkFazenda){
      return (List<PesagemBovino>)pesagemBovinoRepository.getAllPesagemByBovinoAndFazeda(fkAnimal, fkFazenda);
   }

//====================================================================================================================//

   public Object getResumoBovinoFazendaByIntervalo(int pkFazenda, int intervalo) {
      return pesagemBovinoRepository.getResumoBovinoFazendaByIntervalo(pkFazenda, intervalo);
   }

//====================================================================================================================//

   public Optional<PesagemBovino> getPesagemBovinoById(int id){
      return pesagemBovinoRepository.findById(id);
   }

//====================================================================================================================//

   public PesagemBovino edit(PesagemBovino pesagemBovino){
      return pesagemBovinoRepository.save(pesagemBovino);
   }

//====================================================================================================================//

    public boolean delete(int id) {
       if (pesagemBovinoRepository.existsById(id)) {
           pesagemBovinoRepository.deleteById(id);
       }
       return true;
    }

//====================================================================================================================//

}