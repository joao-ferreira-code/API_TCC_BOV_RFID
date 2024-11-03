package api.Bov_Corte.Service.Fazenda;

import api.Bov_Corte.GerarValoresAleatorios;
import api.Bov_Corte.Model.Fazenda.ColaboradorFazenda;
import api.Bov_Corte.Model.Fazenda.Fazenda;
import api.Bov_Corte.Model.Fazenda.FotoFazenda;
import api.Bov_Corte.Model.Fazenda.VWDadosFazenda;
import api.Bov_Corte.Repository.Fazenda.FazendaRepository;
import api.Bov_Corte.Repository.Fazenda.VWDadosFazendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FazendaService {

   @Autowired
   private FazendaRepository fazendaRepository;

   @Autowired
   private ColaboradorFazendaService colaboradorFazendaService;

   @Autowired
   private FotoFazendaService fotoFazendaService;

   @Autowired
   private VWDadosFazendaRepository vwDadosFazendaRepository;

//====================================================================================================================//

   @Transactional
   public Fazenda create(Fazenda fazenda){
      fazenda.setTxCodigoPublico( new GerarValoresAleatorios().gerarCodPublico() );
      Fazenda fazendaResult = fazendaRepository.save(fazenda);
      if( fazendaResult != null ){
         ColaboradorFazenda colaborador = new ColaboradorFazenda();
         colaborador.setFkFazenda(fazendaResult.getPkFazenda());
         colaborador.setFkUsuario(fazendaResult.getFkUsuarioCadastrou());
         colaborador.setDtCadastro(fazendaResult.getDtCadastro());
         colaborador.setAtiva(true);
         colaborador.setFkNivelAcesso(2);
         colaborador.setDtCadastro(fazendaResult.getDtCadastro());
         colaboradorFazendaService.create(colaborador);

         FotoFazenda fotoFazenda = new FotoFazenda();
         fotoFazenda.setBtFotoFazenda(fazenda.getBtFotoFazenda());
         fotoFazenda.setFkFazenda(fazendaResult.getPkFazenda());
         fotoFazenda.setFkUsuarioCadastrou(fazendaResult.getFkUsuarioCadastrou());
         fotoFazendaService.create(fotoFazenda);
      }
      return fazendaRepository.save(fazenda);
   }

//====================================================================================================================//

   public List<Fazenda> getAllFazendasAtivaByColaborador(int usuNrId){
      return (List<Fazenda>)fazendaRepository.getAllFazendasAtivaByColaborador(usuNrId);
   }

//====================================================================================================================//

   public Fazenda edit(Fazenda fazendaEditada){
      Fazenda fazendaOriginal = fazendaRepository.buscarFazendaSeUsuarioAdm(fazendaEditada.getPkFazenda(), fazendaEditada.getFkUsuarioCadastrou());
      if(fazendaOriginal != null){
         fazendaOriginal.setTxNome(fazendaEditada.getTxNome());
         fazendaOriginal.setNrTotalHectares(fazendaEditada.getNrTotalHectares());
         fazendaOriginal.setTxTelefone(fazendaEditada.getTxTelefone());
         fazendaOriginal.setFkCidade(fazendaEditada.getFkCidade());
         return fazendaRepository.save(fazendaOriginal);
      }
      return null;
   }

//====================================================================================================================//

   public boolean inativarFazendaByPkFazendaAndFkUsuario(int pkFazenda, int fkUsuario){
      Fazenda fazendaOriginal = fazendaRepository.buscarFazendaSeUsuarioAdm(pkFazenda, fkUsuario);
      if(fazendaOriginal != null){
         fazendaOriginal.setAtiva(false);
         fazendaRepository.save(fazendaOriginal);
      }
      return true;
   }

//====================================================================================================================//

   public VWDadosFazenda buscarFazendaByCodigoPublico(String codigoPublico) {
      return vwDadosFazendaRepository.findByTxCodigoPublico(codigoPublico);
   }

//====================================================================================================================//

}