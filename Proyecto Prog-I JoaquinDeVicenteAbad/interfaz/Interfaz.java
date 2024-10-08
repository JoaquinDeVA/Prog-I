package interfaz;

import java.util.Scanner;
import dominio.*;

public class Interfaz {

    public static void InterfazCatalogo(ListaOrdenadores catalogo){

        int x=1;
        Scanner sc= new Scanner(System.in);
        catalogo.CargarLista();

        while (x != 0){
            System.out.println("OPCIONES:\n"+"0.Cerrar \n"+"1.Imprimir Catálogo \n"+"2.Añadir un Ordenador \n"+"3.Eliminar un Ordenador \n"+"4.Modificar un Ordenador\n");
            //menu
            System.out.println("Introduzca la opcion a elegir");
            x = sc.nextInt();
            if(x==1){ //imprimir catalogo
                
                System.out.print(catalogo.toString()+"\n");
            }
            if(x==2){ //añadir
                System.out.println("Introduzca los siguientes parametros: Modelo,si se trata de un portatil y precio");
                catalogo.annadir(new Ordenador(sc.next(),sc.nextBoolean(),sc.nextDouble()));
                System.out.println("");
            }
            if(x==3){ //eliminar
                System.out.println("Introduzca el indice asignado al ordenador en el catálogo: ");
                catalogo.eliminar(sc.nextInt()-1);
            }
            if(x==4){ //modificar
                
            }
            if(x==0){ // Se cierra el interfaz
                catalogo.GuardarLista();
                System.out.println("Cerrando menu");
            }
        }
        sc.close();
    }

}
