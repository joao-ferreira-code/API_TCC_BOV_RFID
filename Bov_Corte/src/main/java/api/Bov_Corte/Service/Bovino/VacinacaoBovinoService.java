package api.Bov_Corte.Service.Bovino;

import api.Bov_Corte.Model.Bovino.VacinacaoBovino;
import api.Bov_Corte.Repository.Bovino.VacinacaoBovinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VacinacaoBovinoService {

   @Autowired
   private VacinacaoBovinoRepository vacinacaoBovinoRepository;

//====================================================================================================================//

   public VacinacaoBovino create(VacinacaoBovino vacinacaoBovino){
      vacinacaoBovino.setDtCadastro(new Date());
      return vacinacaoBovinoRepository.save(vacinacaoBovino);
   }

//====================================================================================================================//

   public List<VacinacaoBovino> getAllVacinacaoByBovinoAndFazeda(int fkAnimal, int fkFazenda){
      return (List<VacinacaoBovino>)vacinacaoBovinoRepository.getAllVacinacaoByBovinoAndFazeda(fkAnimal, fkFazenda);
   }

//====================================================================================================================//

   public Object getResumoBovinoFazendaByIntervalo(int pkFazenda, int intervalo) {
      return vacinacaoBovinoRepository.getResumoBovinoFazendaByIntervalo(pkFazenda, intervalo);
   }

//====================================================================================================================//

   public Optional<VacinacaoBovino> getVacinacaoBovinoById(int id){
      return vacinacaoBovinoRepository.findById(id);
   }

//====================================================================================================================//

   public VacinacaoBovino edit(VacinacaoBovino vacinacaoBovino){
      return vacinacaoBovinoRepository.save(vacinacaoBovino);
   }

//====================================================================================================================//

    public boolean delete(int id) {
       if (vacinacaoBovinoRepository.existsById(id)) {
           vacinacaoBovinoRepository.deleteById(id);
       }
       return true;
    }

//====================================================================================================================//

}