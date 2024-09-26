package Comprobacion;

import dominio.Habitante;
import dominio.OficinaPadron;
import java.util.ArrayList;
public class comprobaciones {
    
    public static void realizarComprobacion(){
        Habitante habitante1 = new Habitante("Juan", "Torres", "Sanz");
        Habitante habitante2 = new Habitante("Marta","Caballero","Ramos");
        OficinaPadron padron = new OficinaPadron();
        padron.annadir(habitante1);
        padron.annadir(habitante2);
        ArrayList<Habitante> habitantes = padron.getHabitantesPadron();
        for(Habitante habitante : habitantes){
            System.out.println(habitante.getNombre() + " " +habitante.getApellido1() + " " +habitante.getApellido2());
        }

    }
}
