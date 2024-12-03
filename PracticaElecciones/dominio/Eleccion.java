package dominio;

import java.util.ArrayList;
public class Eleccion {

    private ArrayList<Candidato> candidatos;
    private ArrayList<Papeleta> papeletas;

    public Eleccion(ArrayList<Candidato> candidatos,ArrayList<Papeleta> papeletas){

        this.candidatos = candidatos;
        this.papeletas = papeletas;
    }
    public Candidato realizarRecuento(){

        Candidato ganador = candidatos.get(0);

        for(Papeleta papeleta : papeletas){

            papeleta.obtenerPrimeraPreferencia().incrementarVotos();
        }
        for(Candidato candidato : candidatos){
           
            if(candidato.getVotos() > ganador.getVotos()){

                ganador = candidato;
            }
        }
        return ganador;
    }
    public Eleccion eliminarCandidatoConMenosVotos(){

        Candidato perdedor = candidatos.get(0);
        for(Candidato candidato : candidatos){
            
            if(candidato.getVotos() < perdedor.getVotos()){
                
                perdedor = candidato;
            }
            candidato.resetearVotos();
        }
        candidatos.remove(perdedor);

        for(Papeleta papeleta : papeletas){

            papeleta.eliminarCandidato(perdedor);
        }
        return this;
    }

    public boolean comprobarMayoriaAbsoluta(Candidato ganador){

        for(Candidato candidato : candidatos){

            if(candidato.getVotos() == ganador.getVotos() && !candidato.equals(ganador)){

                return false;
            }
        }
        return true;
    }

    public boolean validarPapeletas(){

        for(Candidato candidato : candidatos){
            
            for(Papeleta papeleta : papeletas){

                if(!papeleta.contiene(candidato)){

                    return false;
                }
            }
        }
        return true;
    }
    
}
