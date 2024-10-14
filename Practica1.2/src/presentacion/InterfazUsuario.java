package presentacion;

import dominio.*;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class InterfazUsuario{
    //string instruccion  pide como argumento un array de strings que contiene la instruccion y los valores del habitante.        
            
    private OficinaPadron padron;
    private Scanner sc = new Scanner(System.in);

    public InterfazUsuario(){
    
        leerPadron();
    }
    public boolean ejecutar(String[] instruccion){
        OficinaPadron padron = new OficinaPadron();
        if(instruccion.length == 1){

            if(instruccion[0].equalsIgnoreCase("mostrar")){
                
                mostrarOficinaPadron(padron);
            }else if(instruccion[0].equalsIgnoreCase("ayuda")){

                System.out.println("Opciones: mostrar \n  ayuda \n añadir <nombre><apellido1><apellido2> \n salir");
            }else if (instruccion[0].equalsIgnoreCase("salir")){
                            
                escribirPadron();
                System.out.println("Finalizado con exito");
                sc.close();
                
                return false;
            }
            else {System.out.println("Error en la instrucción. <ayuda> para mas información");}
        }
        else if (instruccion[0].equalsIgnoreCase("añadir") && instruccion.length == 4){
                       
            padron.annadir(new Habitante(instruccion[1],instruccion[2], instruccion[3]));
            System.out.println("Habitante añadido correctamente");
        }else{
                       
            System.out.println("Error en la instrucción");
        }
        return true;
    }
    public String[] leerInstruccion(){
        System.out.print("?>");
        String linea = sc.nextLine();
        return linea.split(" ");
    }

    public void leerPadron(){

        ObjectInputStream oi;
        try{
                oi=new ObjectInputStream(new FileInputStream("padron.dat"));
                padron=(OficinaPadron) oi.readObject();
                oi.close();
        }catch(Exception e){
            padron = new OficinaPadron();
        }

    }
    private void escribirPadron(){
        
        ObjectOutputStream oo;
        try{
                oo=new ObjectOutputStream(new FileOutputStream("padron.dat"));
                oo.writeObject(padron);
                oo.close();
        }catch(Exception e){
            System.out.print("Error al escribir fichero");
        }

    }
    private static void mostrarOficinaPadron(OficinaPadron padron){
                    
        ArrayList<Habitante> habitantes = padron.getHabitantesPadron();
        for(Habitante habitante : habitantes){
                System.out.println(habitante.getNombre() + " " +habitante.getApellido1() + " " +habitante.getApellido2());
        }
        System.out.println("El numero total de habitantes es " + padron.calcularNumeroHabitantes());
    }

}
                