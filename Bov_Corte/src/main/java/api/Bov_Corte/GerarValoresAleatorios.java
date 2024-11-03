package api.Bov_Corte;

import java.util.Random;

public class GerarValoresAleatorios {

    private String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ" + "abcdefghijklmnopqrstuvywxz" + "0123456789";
    private Random random = new Random();

//====================================================================================================================//

    public String gerarToken(){
        return gerarToken(10);
    }

    public String gerarCodPublico(){
        return gerarToken(6);
    }

//------------------------------------------------------------------//

    public String gerarToken(int nrCaracteres){
        String token = "";
        int index = -1;
        for( int i = 0; i < nrCaracteres; i++ ) {
            index = random.nextInt( letras.length() );
            token += letras.substring( index, index + 1 );
        }

        return token;
    }

//====================================================================================================================//

}
