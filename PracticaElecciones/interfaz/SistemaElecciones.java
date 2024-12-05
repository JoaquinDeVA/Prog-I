package interfaz;


import java.util.ArrayList;

import dominio.*;

public class SistemaElecciones {
    
    private Eleccion eleccion;
    private Candidato ganador;
    
    public SistemaElecciones(ArrayList<Candidato> candidatos, ArrayList<Papeleta> papeletas){

        eleccion = new Eleccion(candidatos, papeletas);
    }

    public void iniciarEleccion(){

        if(!eleccion.validarPapeletas()){

            System.out.println("LAS PAPELETAS NO SON VALIDAS");
            return;
        }
        
        while (true) {
           
            
            ganador = eleccion.realizarRecuento();
            if(eleccion.comprobarMayoriaAbsoluta(ganador)){
            
                break;
            }

            if(!eleccion.eliminarCandidatoConMenosVotos()){

                System.out.println("Eleccion terminada sin ganador");
                break;
            }
            
        }
        
    }

    public void mostrarResultado(){

        System.out.println("El ganador de las elecciones es, " + ganador.toString());
    }
}
