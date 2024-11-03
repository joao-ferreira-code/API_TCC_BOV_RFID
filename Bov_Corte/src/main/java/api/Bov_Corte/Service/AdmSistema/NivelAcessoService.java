package api.Bov_Corte.Service.AdmSistema;

import api.Bov_Corte.Model.AdmSistema.NivelAcesso;
import api.Bov_Corte.Repository.AdmSistema.NivelAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NivelAcessoService {

   @Autowired
   private NivelAcessoRepository nivelAcessoRepository;

//====================================================================================================================//

   public NivelAcesso create(NivelAcesso nivelAcesso){
      return nivelAcessoRepository.save(nivelAcesso);
   }

//====================================================================================================================//

   public List<NivelAcesso> getAllNivelAcesso(){
      return (List<NivelAcesso>) nivelAcessoRepository.findAll();
   }

   public Optional<NivelAcesso> getNivelAcessoById(int id){
      return nivelAcessoRepository.findById(id);
   }

//====================================================================================================================//

   public NivelAcesso edit(NivelAcesso nivelAcesso){
      return nivelAcessoRepository.save(nivelAcesso);
   }

//====================================================================================================================//


}