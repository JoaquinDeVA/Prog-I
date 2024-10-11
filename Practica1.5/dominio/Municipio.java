package dominio;

import java.util.ArrayList;

public class Municipio {
    
    private String nombreMunicipio;
    private ArrayList<Localidad> ListaMunicipio = new ArrayList<>();

    public Municipio(String nombreMunicipo){
        
        this.nombreMunicipio=nombreMunicipo;
    }

    public void annadirLocalidad(Localidad localidad){

        ListaMunicipio.add(localidad);
    }
    
    public int habitantesTotales(){
        int total=0;
        for(Localidad Localidad : ListaMunicipio){
            total+=Localidad.getNumeroHabitantes();
        }
        return total;
    }

    public String toString(){

        StringBuilder texto = new StringBuilder();
        texto.append("El municipio " +nombreMunicipio + " consta de las siguientes Localidades: \n \t");
        for(Localidad localidad : ListaMunicipio){
            texto.append(localidad.toString()+"\n \t");
        }

        return texto.toString();
    }

}
