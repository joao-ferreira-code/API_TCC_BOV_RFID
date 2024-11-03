package api.Bov_Corte;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class ValidarCodigosEspecificos {


    public static void main(String[] args) throws ParseException {
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        dt.parse("14/12/1999 10:00");

        calendar.setTime(dt.parse("14/12/1999 10:00"));

        calendar.add(calendar.DATE, 1);
        System.out.println("Ontem foi " + dt.format(calendar.getTime()));
    }


}
