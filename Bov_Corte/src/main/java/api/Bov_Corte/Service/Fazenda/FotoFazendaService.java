package api.Bov_Corte.Service.Fazenda;
import api.Bov_Corte.Model.Fazenda.FotoFazenda;
import api.Bov_Corte.Repository.Fazenda.FotoFazendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FotoFazendaService {

   @Autowired
   private FotoFazendaRepository fotoFazendaRepository;

//====================================================================================================================//

   @Transactional
   public FotoFazenda create(FotoFazenda fotoFazenda){
      FotoFazenda ftoAnterior = fotoFazendaRepository.getFotoPerfilFazenda(fotoFazenda.getFkFazenda());
      if(ftoAnterior != null){
         ftoAnterior.setAtiva(false);
         fotoFazendaRepository.save(ftoAnterior);
      }
      fotoFazenda.setDtCadastro(new Date());
      fotoFazenda.setAtiva(true);
      return fotoFazendaRepository.save(fotoFazenda);
   }

//====================================================================================================================//

   public FotoFazenda getFotoPerfilFazenda(int fkFazenda){
      return fotoFazendaRepository.getFotoPerfilFazenda(fkFazenda);
   }

//====================================================================================================================//

   public List<FotoFazenda> getAllFotoByFazenda(int fkFazenda){
      return fotoFazendaRepository.getAllFotoByAtivaFazenda(fkFazenda);
   }

//====================================================================================================================//

   public boolean inativarFotoById(int id){
      Optional<FotoFazenda> ft = fotoFazendaRepository.findById(id);
      if(ft.isPresent()){
         ft.get().setAtiva(false);
         fotoFazendaRepository.save(ft.get());
      }
      return true;
   }

//====================================================================================================================//

}