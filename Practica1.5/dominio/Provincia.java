package dominio;

import java.util.ArrayList;
import java.io.Serializable;

public class Provincia implements Serializable{
    
    private String nombre;
    private ArrayList<Municipio> municipios;

    public Provincia (String nombreProvincia ){
        
        nombre=nombreProvincia;
        municipios = new ArrayList<>();
    }
    public Provincia add(Municipio municipio){

        municipios.add(municipio);
        return this;
    }
    public int  getPoblacion(){
        
        int total=0;
            for(Municipio Municipio : municipios){

                total+=Municipio.getPoblacion();
            }
        return total;
    }
    public ArrayList<Municipio> getMunicipios(){
        
        return municipios;
    }
    public Municipio getMunicipio(int i){
        
        return municipios.get(i);
    }
    public int size(){
       
        return municipios.size();
    }
    public String toString(){

        int n=1;
        StringBuilder texto = new StringBuilder();
        texto.append("La provincia de "+nombre+" con "+ getPoblacion() +" habitantes consta de los siguientes municipios: \n \t");
        for(Municipio municipio : municipios){
           
            texto.append(n+") "+municipio.toString());
            n++;
        }
        return texto.toString();
    }
}
        