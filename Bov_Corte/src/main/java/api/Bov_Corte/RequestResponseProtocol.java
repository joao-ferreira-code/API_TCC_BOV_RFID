package api.Bov_Corte;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
public class RequestResponseProtocol<T>{
    private String key;
    public static int SUCCESS=200;
    public final static int ERROR_PROCCESS=500;
    public final static int ERROR_PROCCESS_PEDIDO_NAO_EXISTE=501;
    public final static int ERROR=400;
    public final static int ERROR_AUTHORIZATION=401;
    private int code = SUCCESS;
    private String message="";
    private String errorDetail;
    private T value;

    public ResponseEntity toResponseEntityOk() {
        return new ResponseEntity(this, HttpStatus.OK);
    }

    public ResponseEntity toResponseEntityError() {
        return new ResponseEntity(this, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
