package dominio;

import java.util.ArrayList;

public class BandaMusica {
    
    private ArrayList<Actuacion> bm;
    private String nombre;

    public BandaMusica(String nombre){

        bm = new ArrayList<>();
        this.nombre = nombre;
    }

    public BandaMusica annadirActuacion(Actuacion ac){

        bm.add(ac);
        return this;
    }

    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append(nombre.toUpperCase()).append("\n \n");

        for(Actuacion ac : bm){

            sb.append(ac.toString()).append("\n");
        }
        return sb.toString();
    }
}
