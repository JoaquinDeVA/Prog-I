package dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Actuacion {
 
    private LocalDate ld;
    private ArrayList<Participante> participantes = new ArrayList<>();

    public Actuacion(LocalDate ld){

        this.ld = ld;
    }
    public Actuacion annadirParticipante(Participante p){

        participantes.add(p);
        return this;
    }
    public String toString(){
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("Fecha de actuacion: ").append(ld.format(formatter)).append("\n");
        for(Participante p : participantes){

            sb.append(p.toString()).append("\n");
        }

        return sb.toString();
    }
}
