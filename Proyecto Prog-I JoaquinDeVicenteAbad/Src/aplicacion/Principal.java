package aplicacion;

import interfaz.Interfaz;
import dominio.*;

public class Principal {
 

    public static void main(String[] Args){
    
        //Nuestro metodo principal que ejecuta el interfaz sobre una instancia de catalogo.        
        ListaOrdenadores catalogo = new ListaOrdenadores();
        Interfaz.InterfazCatalogo(catalogo);


    }


}