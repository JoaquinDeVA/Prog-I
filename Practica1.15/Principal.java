import java.time.*;
import java.time.temporal.*;

public class Principal {

    public static void main(String[] args){

        //Fecha y hora local con Id de zona horaria
        LocalDateTime ldt = LocalDateTime.now();
        ZoneId madrid = ZoneId.of("Europe/Madrid");
        ZonedDateTime ldtMadrid = ZonedDateTime.of(ldt,madrid);

        //Fecha y hora de caracas con Id de zona horaria
        LocalDateTime ldt5 = ldt.minusHours(5);
        ZoneId caracas = ZoneId.of("America/Caracas");
        ZonedDateTime ldtCaracas = ZonedDateTime.of(ldt5,caracas);

        //Fecha del descubrimiento de America
        LocalDateTime DescubrimientoAmerica = LocalDateTime.of(1492,10,12,0,0);


        //Fecha y hora de llegada a la luna
        LocalDateTime Armstrong =LocalDateTime.of(1969,07,21,03,56);
        ZonedDateTime ldtArmstrong = ZonedDateTime.of(Armstrong,madrid);



        //Fechas de madrid y Caracas
        System.out.println("Fecha actual: " + ldtMadrid.toLocalDate()); 
        System.out.println("Fecha en Caracas: " + ldtCaracas.toLocalDate());
        
        //Años desde el descubrimiento de america
        System.out.println("Años desde el descubrimiento de America: " + ChronoUnit.YEARS.between(DescubrimientoAmerica, ldtMadrid) + " años");

        //Hora local y de caracas
        System.out.println("La hora actual en Madrid es: "+ ldtMadrid.toLocalTime());
        System.out.println("La hora en Caracas es: "+ ldtCaracas.toLocalTime());
        
        //Horas de diferencia entre madrid y caracas
        System.out.println("La diferencia horaria entre Madrid y Caracas es:" + ChronoUnit.HOURS.between(ldt,ldt5) + " horas");

        //Fecha en Madrid cuando se llego a la luna
        System.out.println("La fecha y hora de la llegada a la luna es: " + ldtArmstrong);
    }   
}