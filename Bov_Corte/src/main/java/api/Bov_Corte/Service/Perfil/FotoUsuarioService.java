package api.Bov_Corte.Service.Perfil;

import api.Bov_Corte.Model.Perfil.FotoUsuario;
import api.Bov_Corte.Repository.Perfil.FotoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FotoUsuarioService {

   @Autowired
   private FotoUsuarioRepository fotoUsuarioRepository;

//====================================================================================================================//

   public boolean create(FotoUsuario fotoUsuario){
      FotoUsuario ftoAnterior = fotoUsuarioRepository.findByFkUsuarioAndIsAtiva(fotoUsuario.getFkUsuario(), true);
      if( ftoAnterior != null ) {
         ftoAnterior.setAtiva(false);
         fotoUsuarioRepository.save(fotoUsuario);
      }else{
         fotoUsuarioRepository.save(fotoUsuario);
      }
      return true;
   }

//====================================================================================================================//

   public List<FotoUsuario> getAllFotoUsuarIsAtiva(boolean isAtiva){
      return (List<FotoUsuario>)fotoUsuarioRepository.findAllByIsAtiva(isAtiva);
   }

//====================================================================================================================//

   public FotoUsuario getFotoAtivaByUsuario(int fkUsuario){
      return fotoUsuarioRepository.findByFkUsuarioAndIsAtiva(fkUsuario, true);
   }

//====================================================================================================================//

   public Optional<FotoUsuario> getFotoUsuarioById(int id){
      return fotoUsuarioRepository.findById(id);
   }

//====================================================================================================================//

   public FotoUsuario edit(FotoUsuario fotoUsuario){
      return fotoUsuarioRepository.save(fotoUsuario);
   }

//====================================================================================================================//

}