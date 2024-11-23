package dominio;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MusicoRefuerzo extends Participante{
    
    private String instrumento;
    private double precio;

    public MusicoRefuerzo(String nombre,String instrumento,double precio){

        super(nombre);
        this.instrumento = instrumento;
        this.precio = precio; 
    }
    

    public String toString(){

        DecimalFormat df = new DecimalFormat("0.00");
        StringBuilder sb = new StringBuilder();
        sb.append(getNombre()).append(", ").append(instrumento).append(", ").append(df.format(precio)).append(" euros");

        return sb.toString();
    }

}
