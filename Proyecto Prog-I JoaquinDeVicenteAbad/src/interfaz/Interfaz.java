package interfaz;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.*;
import dominio.*;

public class Interfaz {
/* La clase Interfaz contiene la interfaz de texto que permite al usuario gestionar
 * el catalogo y trabajar con el. Trabaja sobre un objeto tipo ListaOrdenadores.
 * 
 * Tiene un contructor que ejecuta el metodo leer sobre el objeto ListaOrdenadores.
 * 
 * Un metodo interfazCatalogo que es un bucle que lee por pantalla los instrucciones a ejecutar
 * seleccionadas por el usuario y que solo se rompe cuando el usuario lo desea. 
 * Las instrucciones/metodos que puede ejecutar son los siguientes:
 * 
 * aniadir() que añade un ordenador.
 * eliminar() que elimina un ordenador dado el indice que ocupa en la lista en pantalla.
 * imprimir() muestra por pantalla el catalogo.
 * modificar() altera el valor de un atributo de un ordenador dado su indice.
 * cerrar() cierra la interfaz guardando los cambios.
 * 
 * Un metodo opciones() que despliega por pantalla las opciones posibles
 * Un metodo exito() para indicar que la operacion se ha realizado.
 */
    private ListaOrdenadores catalogo;
    private Scanner sc = new Scanner(System.in);

    public Interfaz(){
        
        catalogo = new ListaOrdenadores();
        catalogo.leer();
    }

    public void InterfazCatalogo(){

        int x=1;        
        while (true){
            try{
                
                //Menu de Opciones
                x=opciones();

                if(x==1){ //imprimir catalogo
                    
                    imprimir();
                }
                 else if(x==2){//añadir
                   
                    aniadir();
                }
                 else if(x==3){//eliminar
                   
                    eliminar();
                }
                 else if(x==4){ //modificar
                   
                    modificar();
                }
                else if(x==0){ // Se cierra el interfaz y se guarda el objeto
                    
                    cerrar();
                    break; //Se rompe el bucle while
                }
                else{ 
                    // Estructura de control para valores fuera de rango
                    System.out.println("\n \n OPCION NO VALIDA \n \n");
                }
            }catch(InputMismatchException ex){  //Maneja la introduccion de datos invalidos
                System.out.println("\n \n EL DATO INTRODUCIDO NO ES VALIDO \n \n");
                sc.next();
            }

        }
    sc.close();
    }
    private void exito(){//Imprime que la operacion se ha realizado
        System.out.println("La operacion ha tenido exito\n");
    }
    private int opciones(){//Imprime las diferentes opciones por pantalla

        System.out.println("\tOPCIONES:\n"+" 0.Cerrar \n"+" 1.Imprimir Catalogo \n"+" 2.Annadir un Ordenador \n"+" 3.Eliminar un Ordenador \n"+" 4.Modificar un Ordenador\n");
        System.out.println("Introduzca la opcion a elegir:");
        return sc.nextInt();       
    }
    private void imprimir(){//Imprime el catalogo
        
        System.out.println(catalogo.toString());
    }
    private void cerrar(){//guarda los datos 

        System.out.println("Guardando datos y cerrando menu");
        catalogo.escribir();
        exito();
    }
    private void aniadir(){ // añade un ordenador al catalogo

        System.out.println("Introduzca los siguientes parametros: Modelo,si se trata de un portatil(true/false) y precio");
        catalogo.annadir(new Ordenador(sc.next(),sc.nextBoolean(),sc.nextDouble()));
        exito();
    }
    private void eliminar(){ // Elimina un ordenador del catalogo
        
        int y=0;
        System.out.println(catalogo.toString()); //Imprime el catalogo
        System.out.println("Introduzca el indice asignado al ordenador en el catalogo: ");
        y=sc.nextInt()-1; //calcula el valor en el Array dado el indice
        if(y>=0 && y<catalogo.Size()){ //Verifica que y(ordenador) existe en el ArrayList
            
            catalogo.eliminar(y);
            exito();
        } else{
            
            System.out.println("El numero seleccionado no existe en el catalogo");
        }
    }
    private void modificar(){ //modifica un elemento de un ordenador del catalogo
        int y,z=0;
        System.out.print(catalogo.toString()+"\n"); //Imprime el catalogo
        System.out.println("Introduzca el indice asignado al ordenador en el catalogo: ");
        y = sc.nextInt()-1;
        if(y>=0 && y<catalogo.Size()){ //Verifica que y(ordenador) existe en el ArrayList
                        
            System.out.println("Que deseas modificar: \n1. Modelo \n2. Portatil \n3. Precio");
            z = sc.nextInt();
            if(z==1){ //modificar en nombre del modelo
                            
                System.out.println("Introduzca el nuevo modelo");
                catalogo.modificarModelo(y,sc.next());
                exito();
            }
            else if(z==2){ //modificar si se trata de un portatil
                            
                catalogo.modificarPortatil(y);
                exito();
            }
            else if(z==3){ // modificar el precio
                           
                System.out.println("Introduzca el nuevo precio");
                catalogo.modificarPrecio(y,sc.nextDouble());
                exito();
            }else{
                            
                System.out.println("Opcion no valida\n"); 
            }
        }else{
                        
            System.out.println("El numero seleccionado no existe en el catalogo");
        }
    }
}
