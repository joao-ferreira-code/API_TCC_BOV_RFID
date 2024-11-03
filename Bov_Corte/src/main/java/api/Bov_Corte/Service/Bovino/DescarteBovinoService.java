package api.Bov_Corte.Service.Bovino;

import api.Bov_Corte.Model.Bovino.DescarteBovino;
import api.Bov_Corte.Model.Bovino.VWDadosDescarte;
import api.Bov_Corte.Repository.Bovino.DescarteBovinoRepository;
import api.Bov_Corte.Repository.Bovino.VWDadosDescarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DescarteBovinoService {

   @Autowired
   private DescarteBovinoRepository descarteBovinoRepository;

   @Autowired
   private VWDadosDescarteRepository vwDadosDescarteRepository;

//====================================================================================================================//

   public DescarteBovino create(DescarteBovino descarteBovino){
      descarteBovino.setDtCadastro(new Date());
      descarteBovino.setAtiva(true);
      return descarteBovinoRepository.save(descarteBovino);
   }

//====================================================================================================================//

   public List<VWDadosDescarte> getAllByPkFazenda(int fkFazenda){
      return  vwDadosDescarteRepository.findAllByFkFazenda(fkFazenda);
   }

//====================================================================================================================//

   public Object getResumoBovinoFazendaByIntervalo(int pkFazenda, int intervalo) {
      return descarteBovinoRepository.getResumoBovinoFazendaByIntervalo(pkFazenda, intervalo);
   }

//====================================================================================================================//

   public Optional<DescarteBovino> getDescarteBovinoById(int id){
      return descarteBovinoRepository.findById(id);
   }

//====================================================================================================================//

   public DescarteBovino edit(DescarteBovino descarteBovino){
      return descarteBovinoRepository.save(descarteBovino);
   }

//====================================================================================================================//

    public boolean delete(int id) {
       if (descarteBovinoRepository.existsById(id)) {
           descarteBovinoRepository.deleteById(id);
       }
       return true;
    }

//====================================================================================================================//

}