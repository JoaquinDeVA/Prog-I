package dominio;

import java.util.ArrayList;

public class Provincia {
    
    private String nombreProvincia;
    private ArrayList<Municipio> ListaProvincia = new ArrayList<>();

    public int habitantesTotales(){
        
        int total=0;
            for(Municipio Municipio : ListaProvincia){

                total+=Municipio.habitantesTotales();
            }
        return total;
    }

    public String toString(){

        StringBuilder texto = new StringBuilder();
        texto.append("La provincia "+nombreProvincia +"consta de los siguientes municipios: \n \t");
        for(Municipio municipio : ListaProvincia){
            texto.append(municipio.toString());
        }
        return texto.toString();
    }
}
        