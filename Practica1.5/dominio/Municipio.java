package dominio;

import java.util.ArrayList;

public class Municipio {
    
    ArrayList<Localidad> ListaMunicipio = new ArrayList<>();
    
    public int habitantesTotales(){
        int total=0;
        for(Localidad Localidad : ListaMunicipio){
            total+=Localidad.getNumeroHabitantes();
        }
        return total;
    }


}
