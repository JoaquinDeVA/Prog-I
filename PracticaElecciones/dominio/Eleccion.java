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
    public boolean eliminarCandidatoConMenosVotos(){

        if(candidatos.size() == 0){

            return false;
        }
        int cantidad = candidatos.get(0).getVotos();
        ArrayList<Candidato> perdedores = new ArrayList<>();
        for(Candidato candidato : candidatos){
           
            if(candidato.getVotos() < cantidad){
                
                cantidad = candidato.getVotos();
            }
        }
        for(Candidato candidato : candidatos){

            if(candidato.getVotos() == cantidad){

                for(Papeleta papeleta : papeletas){

                    papeleta.eliminarCandidato(candidato);
                }
                perdedores.add(candidato);
            }else{
                candidato.resetearVotos();
            }
        }

        for(Candidato perdedor : perdedores){

            candidatos.remove(perdedor);
        }
        return true;
    }

    public boolean comprobarMayoriaAbsoluta(Candidato ganador){

        int total = 0;
        for(Candidato candidato : candidatos){
            
            total = total + candidato.getVotos();
        }
        if(total%2 == 1){
            total++;
        }
        if(ganador.getVotos() > total/2){

            return true;
        }
        return false;
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
