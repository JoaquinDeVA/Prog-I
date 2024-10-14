package dominio;
import java.util.ArrayList;
import java.io.Serializable;

public class OficinaPadron {
    
        private ArrayList<Habitante> habitantesPadron = new ArrayList<>();

        public OficinaPadron(){

        }
        public void annadir(Habitante habitante){
        
            habitantesPadron.add(habitante);
           
        }
        public ArrayList getHabitantesPadron(){
        

            return habitantesPadron;
        }
        public int calcularNumeroHabitantes(){
            
            int suma = 0;
            for(Habitante habitante : habitantesPadron) {
                suma++;
            }
            return suma;
            
        }
        public String toString(){
            int numero=0;
            StringBuilder cad = new StringBuilder();
            for(Habitante habitante : habitantesPadron){
                cad.append(habitante.toString() + "\n");
                numero++;
            }
            cad.append("El numero total de habitantes es " + numero + "\n");
            return cad.toString();
        }

    }

