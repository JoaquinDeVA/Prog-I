package principal;

import java.util.ArrayList;

import dominio.*;
import interfaz.*;
public class Aplicacion {
    

    public static void main(String[] Args){


        ArrayList<Candidato> candidatos = new ArrayList<>(); 
        Candidato candidato1 = new Candidato("Vicky");
        Candidato candidato2 = new Candidato ("Jorge");
        Candidato candidato3 = new Candidato ("Tio Gilito");
        candidatos.add(candidato1);
        candidatos.add(candidato2);
        candidatos.add(candidato3);
        ArrayList<Papeleta> papeletas = new ArrayList<>();

        ArrayList<Candidato> papeleta11= new ArrayList<>(); 
        papeleta11.add(candidato3);
        papeleta11.add(candidato2);
        papeleta11.add(candidato1);
        Papeleta papeleta1 = new Papeleta(papeleta11);

        ArrayList<Candidato> papeleta22= new ArrayList<>(); 
        papeleta22.add(candidato3);
        papeleta22.add(candidato2);
        papeleta22.add(candidato1);
        Papeleta papeleta2 = new Papeleta(papeleta22);

        ArrayList<Candidato> papeleta33= new ArrayList<>(); 
        papeleta33.add(candidato2);
        papeleta33.add(candidato1);
        papeleta33.add(candidato3);
        Papeleta papeleta3 = new Papeleta(papeleta33);
        
        ArrayList<Candidato> papeleta44 = new ArrayList<>();
        papeleta44.add(candidato2);
        papeleta44.add(candidato1);
        papeleta44.add(candidato3);
        Papeleta papeleta4 = new Papeleta(papeleta44);

        ArrayList<Candidato> papeleta55 = new ArrayList<>();
        papeleta55.add(candidato1);
        papeleta55.add(candidato2);
        papeleta55.add(candidato3);
        Papeleta papeleta5 = new Papeleta(papeleta55);

        ArrayList<Candidato> papeleta66 = new ArrayList<>();
        papeleta66.add(candidato2);
        papeleta66.add(candidato1);
        papeleta66.add(candidato3);
        Papeleta papeleta6 = new Papeleta(papeleta66);

        papeletas.add(papeleta1);
        papeletas.add(papeleta2);
        papeletas.add(papeleta3);
        papeletas.add(papeleta4);
        papeletas.add(papeleta5);
        papeletas.add(papeleta6);

        SistemaElecciones se = new SistemaElecciones(candidatos, papeletas);
        se.iniciarEleccion();
        se.mostrarResultado();

    }
}
