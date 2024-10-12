package dominio;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaOrdenadores{

/* 
 *Clase ListaOrdenadores que es un arrayList del tipo Ordenador. 
 *
 *tenemos definido  un constructor vacio.
 *
 * Un metodo annadir que anade un ordenador al arrayList,
 * un metodo eliminar que elimina un ordenador del arrayList,
 * 
 *Una serie de metodos modificar que modifican respectivamente diferentes atributos 
 *dados el indice del arrayList.
 *
 *Un metodo Size que devuelve el tamaño de nuestro ArrayList.
 * 
 * Un metodo GuardarLista que escribe en el fichero CATALOGO.csv los datos del
 * arrayList y un metodo CargarLista que carga los datos de CATALOGO.csv en el arrayList.
 * 
 * 
 * Y el metodo toString que devuelve un String con los datos del arrayList.
 */
    private ArrayList<Ordenador> ListaOrdenadores = new ArrayList<>();

    public ListaOrdenadores(){
    
    }
    public void annadir(Ordenador OrdenadorNuevo){

        ListaOrdenadores.add(OrdenadorNuevo);
    }
    public void eliminar(int i){
        ListaOrdenadores.remove(ListaOrdenadores.get(i));
    }

    public void modificarModelo(int i,String modelo){

        ListaOrdenadores.get(i).setModelo(modelo);
    }
    public void modificarPortatil(int i,boolean portatil){
        
        ListaOrdenadores.get(i).setPortatil(portatil);
    }
    public void modificarPrecio(int i,double precio){
        
        ListaOrdenadores.get(i).setPrecio(precio);
    }
    public int Size(){

        return ListaOrdenadores.size();
    }
    
    public void GuardarLista(){

        try{
            FileWriter fw = new FileWriter("CATALOGO.csv");
            for(Ordenador ordenador:ListaOrdenadores){

                fw.write(ordenador.getModelo() +","+ ordenador.getPortatil()+"," + ordenador.getPrecio()+ "\n");
            }

            fw.close();
        }catch(IOException ex){System.out.print(ex);}
       
    }
    public void CargarLista(){

        try{
            File fichero = new File("CATALOGO.csv");
            fichero.createNewFile();
            Scanner sc = new Scanner(fichero);
            sc.useDelimiter(",|\n");
            while (sc.hasNext()){
                String modelo = sc.next();  
                boolean portatil = Boolean.parseBoolean(sc.next()); // pasar de String a boolean
                double precio = Double.parseDouble(sc.next());      // pasar de String a double
                ListaOrdenadores.add(new Ordenador(modelo,portatil,precio));
            }
            sc.close();
        } catch (IOException ex){System.out.print("No hay un catalogo guardado");}
    }
    

    public String toString(){
        /* Para evitar la creacion de un nuevo String en memoria para cada iteracion  
         * del bucle usamos la clase StringBuilder que es mutable.
         */
        int contador=1;
        StringBuilder resultado = new StringBuilder(); 
        resultado.append("Catalogo Ordenadores:\n");

        for(Ordenador ordenador : ListaOrdenadores) {
            resultado.append(contador+".").append(ordenador.toString()).append("\n");
            contador++;
        }

        return resultado.toString();
    }
}