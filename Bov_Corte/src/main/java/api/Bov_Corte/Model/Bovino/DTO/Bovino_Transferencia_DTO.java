package api.Bov_Corte.Model.Bovino.DTO;

import api.Bov_Corte.Model.Bovino.Bovino;
import api.Bov_Corte.Model.Bovino.CompraBovino;
import lombok.Data;

@Data
public class Bovino_Transferencia_DTO {

    private int fkFazenda;
    private int pkBovinoRegistro;
    private int pkBovinoFazendaRegistro;

    private CompraBovino compraBovino;

//----------------------------------------------------------------------//

}
