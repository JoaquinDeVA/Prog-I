package interfaz;

import dominio.*;
import java.util.Scanner;

public class Interfaz {
 
    private Scanner sc = new Scanner(System.in);
    private Pais p= new Pais();

    public Interfaz(){

        p=Pais.leer();
    }
    public void InterfazUsuario(){


        
    }
    public void grabar(){

        p.grabar();
    }
    public void aniadirProvincia(){

        System.out.println("Nombre de la provincia:");
        String nombre = sc.nextLine();
        p.add(new Provincia(nombre));

    }
    
    /* AddProvincia
     * AddLocalidad
     * AddLocalidad
     * 
     */
    
}
