package dominio;

import java.util.ArrayList;
import java.io.Serializable;

public class Municipio implements Serializable {
    
    private String nombreMunicipio;
    private ArrayList<Localidad> localidades;

    public Municipio(String nombreMunicipo){
        
        this.nombreMunicipio=nombreMunicipo;
        localidades = new ArrayList<>();
    }

    public Municipio add(Localidad localidad){

        localidades.add(localidad);
        return this;
    }
    
    public int getPoblacion(){
        int total=0;
        for(Localidad Localidad : localidades){
            total+=Localidad.getPoblacion();
        }
        return total;
    }
    public int getLocalidades(){
        
        return localidades.size();
    }
    public Localidad getLocalidad(int i){
        
        return localidades.get(i);
    }
    public String getNombre() {
        
        return nombreMunicipio;
    }
    public String toString(){

        StringBuilder texto = new StringBuilder();
        texto.append("El municipio de " +nombreMunicipio +" con "+ getPoblacion() +" habitantes consta de las siguientes Localidades: \n \t");
        for(Localidad localidad : localidades){
            texto.append(localidad.toString()+"\n \t");
        }

        return texto.toString();
    }

}
