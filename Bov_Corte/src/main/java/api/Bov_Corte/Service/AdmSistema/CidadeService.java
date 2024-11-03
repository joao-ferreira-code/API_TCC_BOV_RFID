package api.Bov_Corte.Service.AdmSistema;

import api.Bov_Corte.Model.AdmSistema.Cidade;
import api.Bov_Corte.Repository.AdmSistema.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

   @Autowired
   private CidadeRepository cidadeRepository;

//====================================================================================================================//

   public Cidade create(Cidade cidade){
      return cidadeRepository.save(cidade);
   }

//====================================================================================================================//

   public List<Cidade> getAllCidade(){
      return (List<Cidade>)cidadeRepository.findAll();
   }

   public List<Cidade> getAllCidadeByEstadoId(int fkEstado) {
      return (List<Cidade>) cidadeRepository.findAllByFkEstado(fkEstado);
   }

   public Optional<Cidade> getCidadeById(int id){
      return cidadeRepository.findById(id);
   }

//====================================================================================================================//

}