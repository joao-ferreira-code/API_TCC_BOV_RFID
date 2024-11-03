package api.Bov_Corte.Model.Bovino.DTO;

import api.Bov_Corte.Model.Bovino.Bovino;
import api.Bov_Corte.Model.Bovino.CompraBovino;
import lombok.Data;

@Data
public class CadastroBovino_DTO {

    private int fkFazenda;

    private Bovino bovino;

    private CompraBovino compraBovino;

//----------------------------------------------------------------------//

    private int pkBovinoFazendaRegistro;

    private int fkTagRFID;

    private String txCodigoEpc;

    private String txObtencao;


}
