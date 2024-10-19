package dominio;

import java.util.ArrayList;

public class Provincia {
    
    private String nombreProvincia;
    private ArrayList<Municipio> ListaProvincia = new ArrayList<>();

    public Provincia (String nombreProvincia ){
        
        this.nombreProvincia=nombreProvincia;
    }
    public void annadirMunicipio(Municipio municipio){

        ListaProvincia.add(municipio);
    }
    public int habitantesTotales(){
        
        int total=0;
            for(Municipio Municipio : ListaProvincia){

                total+=Municipio.habitantesTotales();
            }
        return total;
    }

    public String toString(){

        int n=1;
        StringBuilder texto = new StringBuilder();
        texto.append("La provincia de "+nombreProvincia +" consta de los siguientes municipios: \n \t");
        for(Municipio municipio : ListaProvincia){
           
            texto.append(n+") "+municipio.toString());
            n++;
        }
        return texto.toString();
    }
}
        