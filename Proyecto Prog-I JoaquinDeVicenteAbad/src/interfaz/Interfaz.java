package interfaz;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import dominio.*;

public class Interfaz {
/* La clase Interfaz contiene la interfaz de texto que permite al usuario gestionar
 * el catalogo y trabajar con el. Trabaja sobre un objeto tipo ListaOrdenadores.
 * 
 * Tiene un contructor que ejecuta su metodo leerPadron.
 * 
 * Un metodo interfazCatalogo que es un bucle que lee por pantalla los instrucciones 
 * del usuario y que solo se rompe cuando el usuario lo desea.
 * 
 * Ademas este metodo permite añadir un ordenador dado el indice que le corresponde, 
 * eliminar un ordenador de la misma manera, imprimir por pantalla el catalogo,
 * modificar un atributo de un ordenador dado su indice y cerrar el programa guardando los cambios.
 * 
 * 
 * Un metodo leerPadron que crea un objeto ObjectInputStream para leer los datos objecto del fichero
 * CATALOGO.dat. En caso de fallar en cargar los datos a catalogo porque no exista el archivo lo inicializa.
 * 
 * Un metodo escribirPadron que crea un objeto ObjectOutputStream para guardar nuestro objeto
 * ListaOrdenadores en un archivo llamado CATALOGO.dat. (Lo crea si no existe, metodo FileOutputStream)
 * 
 * Un metodo exito para indicar que la operacion se ha realizado.
 */
    private ListaOrdenadores catalogo;
    private Scanner sc = new Scanner(System.in);

    public Interfaz(){
        
        leerPadron();
    }

    public void InterfazCatalogo(){

        int x=1;        
        while (true){
            try{
                //Menu de Opciones
                System.out.println(" OPCIONES:\n"+"0.Cerrar \n"+"1.Imprimir Catalogo \n"+"2.Annadir un Ordenador \n"+"3.Eliminar un Ordenador \n"+"4.Modificar un Ordenador\n");
                System.out.println("Introduzca la opcion a elegir");
                x = sc.nextInt();
                if(x==1){ 
                    //imprimir catalogo
                    System.out.println(catalogo.toString());
                }
                 else if(x==2){
                    //añadir
                    System.out.println("Introduzca los siguientes parametros: Modelo,si se trata de un portatil y precio");
                    catalogo.annadir(new Ordenador(sc.next(),sc.nextBoolean(),sc.nextDouble()));
                    exito();
                }
                 else if(x==3){
                    //eliminar
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
                 else if(x==4){ //modificar
                   
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
                else if(x==0){ 
                    // Se cierra el interfaz y se guarda el objeto
                    System.out.println("Guardando datos y cerrando menu");
                    escribirPadron();
                    exito();
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
    private void leerPadron(){
        //Lee los datos y inicializa catalogo como los datos del fichero o si falla en hacerlo lo inicializa en vacio
        ObjectInputStream oi;
        try{
            oi = new ObjectInputStream(new FileInputStream("CATALOGO.dat")); 
            catalogo = (ListaOrdenadores)oi.readObject();
            oi.close();
        } catch (Exception e){
            catalogo = new ListaOrdenadores();
        }
    }
    private void escribirPadron(){
        //Guarda el objeto
        ObjectOutputStream oo;
        try{
            oo= new ObjectOutputStream(new FileOutputStream("CATALOGO.dat"));
            oo.writeObject(catalogo);
            oo.close();
        } catch (Exception e){ System.out.print("Error al guardar los datos en el fichero");}
    }
    private void exito(){
        //Imprime que la operacion se ha realizado
        System.out.println("La operacion ha tenido exito\n");
    }
}
