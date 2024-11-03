package api.Bov_Corte.Model.Bovino;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
public class ResumoCadastroBovino {

    private int qtdTotalAnimais;

    private int qtdAnimaisMachos;

    private int qtdNrCompras;

    private int qtdNrNascimento;

}
