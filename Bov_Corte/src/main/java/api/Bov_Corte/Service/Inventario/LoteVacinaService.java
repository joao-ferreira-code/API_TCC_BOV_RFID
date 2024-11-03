package api.Bov_Corte.Service.Inventario;

import api.Bov_Corte.Model.Inventario.LoteVacina;
import api.Bov_Corte.Repository.Inventario.LoteVacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LoteVacinaService {

   @Autowired
   private LoteVacinaRepository loteVacinaRepository;

//====================================================================================================================//

   public LoteVacina create(LoteVacina loteVacina){
      loteVacina.setDtCadastro( new Date() );
      return loteVacinaRepository.save(loteVacina);
   }

//====================================================================================================================//

   public List<LoteVacina> getAllLoteObrigatorioByFazenda(int fkFazenda){
      return (List<LoteVacina>) loteVacinaRepository.findAllByFkFazendaAndIsObrigatoria(fkFazenda, true);
   }

//====================================================================================================================//

   public List<LoteVacina> getAllLoteRotineiraByFazenda(int fkFazenda){
      return (List<LoteVacina>) loteVacinaRepository.findAllByFkFazendaAndIsObrigatoria(fkFazenda, false);
   }

//====================================================================================================================//

   public List<LoteVacina> getAllLoteAtivoByFazenda(int fkFazenda){
      return (List<LoteVacina>) loteVacinaRepository.findAllByFkFazendaAndIsAtiva(fkFazenda, true);
   }

//====================================================================================================================//

   public Optional<LoteVacina> getVacinaById(int id){
      return loteVacinaRepository.findById(id);
   }

//====================================================================================================================//

   public LoteVacina edit(LoteVacina loteVacina){
      return loteVacinaRepository.save(loteVacina);
   }

//====================================================================================================================//

    public boolean delete(int id) {
       if (loteVacinaRepository.existsById(id)) {
           loteVacinaRepository.deleteById(id);
       }
       return true;
    }

//====================================================================================================================//

}