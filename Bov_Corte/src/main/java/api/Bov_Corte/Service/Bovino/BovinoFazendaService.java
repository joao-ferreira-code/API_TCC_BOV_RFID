package api.Bov_Corte.Service.Bovino;

import api.Bov_Corte.Model.Bovino.*;
import api.Bov_Corte.Model.Bovino.DTO.Bovino_Transferencia_DTO;
import api.Bov_Corte.Model.Bovino.DTO.CadastroBovino_DTO;
import api.Bov_Corte.Repository.Bovino.BovinoFazendaRepository;
import api.Bov_Corte.Repository.Bovino.VWBovinoFazendaRepository;
import api.Bov_Corte.Repository.Bovino.VWBovinoFazendaSimplesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class BovinoFazendaService {

   @Autowired
   private BovinoFazendaRepository bovinoFazendaRepository;

   @Autowired
   private VWBovinoFazendaRepository vwBovinoFazendaRepository;

   @Autowired
   private VWBovinoFazendaSimplesRepository vwBovinoFazendaSimplesRepository;

   @Autowired
   private BovinoService bovinoService;

   @Autowired
   private CompraBovinoService compraBovinoService;

//====================================================================================================================//

   @Transactional
   public BovinoFazenda createByNascimeto(CadastroBovino_DTO cadastroBovino_DTO){
      cadastroBovino_DTO.getBovino().setDtCadastro(new Date());
      Bovino bovino = bovinoService.create(cadastroBovino_DTO.getBovino());
      if(bovino != null){
         BovinoFazenda bovinoFazenda =  new BovinoFazenda();
         bovinoFazenda.setFkFazenda(cadastroBovino_DTO.getFkFazenda());
         bovinoFazenda.setFkAnimal(bovino.getPkBovino());
         bovinoFazenda.setFkTagRfid(cadastroBovino_DTO.getFkTagRFID());
         bovinoFazenda.setFkUsuarioCadastrou(cadastroBovino_DTO.getBovino().getFkUsuarioCadastrou());
         bovinoFazenda.setTxObtencao("NASC");
         bovinoFazenda.setDtCadastro(new Date());
         return bovinoFazendaRepository.save(bovinoFazenda);
      }
      return null;
   }

//====================================================================================================================//

   @Transactional
   public boolean createByCompraCadAnimal(CadastroBovino_DTO cadastroBovino_DTO){
      cadastroBovino_DTO.getBovino().setDtCadastro(new Date());
      Bovino bovino = bovinoService.create(cadastroBovino_DTO.getBovino());
      if(bovino != null){
         BovinoFazenda bovinoFazenda =  new BovinoFazenda();
         bovinoFazenda.setFkFazenda(cadastroBovino_DTO.getFkFazenda());
         bovinoFazenda.setFkAnimal(bovino.getPkBovino());
         bovinoFazenda.setFkTagRfid(cadastroBovino_DTO.getFkTagRFID());
         bovinoFazenda.setFkUsuarioCadastrou(cadastroBovino_DTO.getBovino().getFkUsuarioCadastrou());
         bovinoFazenda.setTxObtencao("COM");
         bovinoFazenda.setDtCadastro(new Date());
         BovinoFazenda bovinoFazendaCad = bovinoFazendaRepository.save(bovinoFazenda);
         if(bovinoFazendaCad != null) {
            cadastroBovino_DTO.getCompraBovino().setDtCadastro(new Date());
            cadastroBovino_DTO.getCompraBovino().setFkAnimalFazenda(bovinoFazendaCad.getPkBovinoFazenda());
            compraBovinoService.create(cadastroBovino_DTO.getCompraBovino());
         }
      }
      return true;
   }

//====================================================================================================================//

   @Transactional
   public BovinoFazenda createByCompraByTransferencia(Bovino_Transferencia_DTO cadastroBovino_DTO){
      System.out.println("OKAY");
      BovinoFazenda paraTransferir = bovinoFazendaRepository.findByPkBovinoFazenda(cadastroBovino_DTO.getPkBovinoFazendaRegistro());
      paraTransferir.setAtiva(false);
      paraTransferir.setDtBaixa(new Date());
      System.out.println("2");
      if( bovinoFazendaRepository.save(paraTransferir) != null) {
         System.out.println("OKAY3");
         BovinoFazenda registroNovaFazenda = new BovinoFazenda();
         registroNovaFazenda.setFkFazenda(cadastroBovino_DTO.getFkFazenda());
         registroNovaFazenda.setFkAnimal(paraTransferir.getFkAnimal());
         //registroNovaFazenda.setFkTagRfid(cadastroBovino_DTO.getFkTagRFID()); //Ver se vai ter repase das tags
         //registroNovaFazenda.setFkUsuarioCadastrou(cadastroBovino_DTO.getBovino().getFkUsuarioCadastrou());
         registroNovaFazenda.setDtCadastro(new Date());
         registroNovaFazenda.setTxObtencao("COM");
         System.out.println("OKAY4");
         BovinoFazenda bovinoFazendaCad = bovinoFazendaRepository.save(registroNovaFazenda);
         if(bovinoFazendaCad != null) {
            cadastroBovino_DTO.getCompraBovino().setDtCadastro(new Date());
            cadastroBovino_DTO.getCompraBovino().setFkAnimalFazenda(bovinoFazendaCad.getPkBovinoFazenda());
            compraBovinoService.create(cadastroBovino_DTO.getCompraBovino());
         }
         System.out.println("OKAY5");
      }
      return null;
   }

//====================================================================================================================//

   public List<VWBovinoFazenda> getDadosCompletosByFazenda(int fkFazenda, int pkBovino, int viaRFID){
      if(viaRFID == 1){
         return (List<VWBovinoFazenda>) vwBovinoFazendaRepository.getAllBovinoFazendaByCodeRFID( fkFazenda, ""+pkBovino );
      }
      return (List<VWBovinoFazenda>) vwBovinoFazendaRepository.getAllBovinoFazendaByCodeAnimal( fkFazenda, pkBovino );
   }

//====================================================================================================================//

   public VWBovinoFazendaSimples getDadosSimplificadosByFazenda(int fkFazenda, int pkBovino, int viaRFID){
      if(viaRFID == 1){
         return vwBovinoFazendaSimplesRepository.getByCodeRFID( fkFazenda, ""+pkBovino );
      }
      return vwBovinoFazendaSimplesRepository.getByCodeAnimal( fkFazenda, pkBovino );
   }

//====================================================================================================================//

   public List<VWBovinoFazenda> getAllBovinoByFazenda(int fkFazenda){
      return bovinoFazendaRepository.getAllByFkFazenda(fkFazenda);
   }

//====================================================================================================================//

   public BovinoFazenda edit(BovinoFazenda bovinoFazenda){
      return bovinoFazendaRepository.save(bovinoFazenda);
   }

//====================================================================================================================//

    public boolean delete(int id) {
       if (bovinoFazendaRepository.existsById(id)) {
           bovinoFazendaRepository.deleteById(id);
       }
       return true;
    }

   public Object getResumoBovinoFazendaByIntervalo(int pkFazenda, int intervalo) {
      return bovinoFazendaRepository.getResumoBovinoFazendaByIntervalo(pkFazenda, intervalo);
   }

//====================================================================================================================//

}