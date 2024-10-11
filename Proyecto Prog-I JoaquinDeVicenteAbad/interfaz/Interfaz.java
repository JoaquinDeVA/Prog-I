package interfaz;

import java.util.Scanner;
import java.util.InputMismatchException;
import dominio.*;

public class Interfaz {

    public static void InterfazCatalogo(ListaOrdenadores catalogo){

        int x=1;
        Scanner sc= new Scanner(System.in);
        catalogo.CargarLista();
       
        while (x != 0){
            try{
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
                    int y=0;
                    System.out.print(catalogo.toString()+"\n");
                    System.out.println("Introduzca el indice asignado al ordenador en el catálogo: ");
                    y=sc.nextInt()-1;
                    if(y>=0 && y<catalogo.Size()){
                        catalogo.eliminar(y);
                    } else{
                        System.out.println("\n \n OPCION NO VALIDA \n \n");
                    }
                }
                if(x==4){ //modificar
                    int y,z=0;
                    System.out.print(catalogo.toString()+"\n");
                    System.out.println("Introduzca el indice asignado al ordenador en el catálogo: ");
                    y = sc.nextInt()-1;
                    System.out.println("¿Que deseas modificar: \n1. modelo \n2. Portatil \n3. Precio");
                    z = sc.nextInt();
                    if(y>=0 && y<catalogo.Size()){
                        
                        if(z==1){
                            System.out.println("Introduzca el nuevo modelo");
                            catalogo.modificarModelo(y,sc.next());
                        }
                        if(z==2){
                            System.out.println("Introduzca el nuevo estado de portatil");   
                            catalogo.modificarPortatil(y,sc.nextBoolean());
                        }
                        if(z==3){
                            System.out.println("Introduzca el nuevo precio");
                            catalogo.modificarPrecio(y,sc.nextDouble());
                        }else{
                            System.out.println("Opcion no valida");
                        }
                    }
                }
                if(x==0){ // Se cierra el interfaz
                    catalogo.GuardarLista();
                    System.out.println("Cerrando menu");
                }
                if(x > 4 || x < 0){
                    System.out.println("\n \n OPCION NO VALIDA \n \n");
                }
            }catch(InputMismatchException ex){
                System.out.println("\n \n EL DATO INTRODUCIDO NO ES VALIDO \n \n");
                sc.next();
            }
        
        }
    sc.close();
    }

}
