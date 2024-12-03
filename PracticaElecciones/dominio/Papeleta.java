package dominio;

import java.util.ArrayList;
public class Papeleta {
    
    private ArrayList<Candidato> preferencias;
    
    public Papeleta(ArrayList<Candidato> candidatos){

        preferencias = candidatos;
    }

    public Candidato obtenerPrimeraPreferencia(){

        return preferencias.get(0);
    }

    public Papeleta eliminarCandidato(Candidato candidato){

       // if(preferencias.contains(candidato)){
        
            preferencias.remove(candidato);
            return this;
        //}
        
    }

    public boolean contiene(Candidato candidato){

        if(preferencias.contains(candidato)){
            return true;
        }
        return false;
    }

}
