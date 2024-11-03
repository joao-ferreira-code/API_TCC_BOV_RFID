package api.Bov_Corte.Service.AdmSistema;

import api.Bov_Corte.Model.AdmSistema.Estado;
import api.Bov_Corte.Repository.AdmSistema.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

   @Autowired
   private EstadoRepository estadoRepository;

//====================================================================================================================//

   public Estado create(Estado estado){
      return estadoRepository.save(estado);
   }

//====================================================================================================================//

   public List<Estado> getAllEstado(){
      return (List<Estado>)estadoRepository.findAll();
   }

   public Optional<Estado> getEstadoById(int id){
      return estadoRepository.findById(id);
   }

//====================================================================================================================//

}