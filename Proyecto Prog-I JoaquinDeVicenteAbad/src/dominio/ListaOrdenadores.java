package dominio;

import java.util.ArrayList;
import java.io.*;

public class ListaOrdenadores implements Serializable{

/* 
 *Clase ListaOrdenadores que es un arrayList del tipo Ordenador. 
 *
 *tenemos definido  un constructor que inicializa el array.
 *
 *Un metodo annadir que añade un ordenador al arrayList.
 *Un metodo eliminar que elimina un ordenador del arrayList dado su indice.
 * 
 *Una serie de metodos modificar que modifican respectivamente diferentes atributos 
 *dados el indice del arrayList.
 *
 *Un metodo Size que devuelve el tamaño de nuestro ArrayList.
 * 
 * El metodo toString.
 * 
 * Y los metodos leer y escribir que se encargan de la persistencia de los datos en un fichero CATALOGO.dat
 */
    private ArrayList<Ordenador> ListaOrdenadores;

    public ListaOrdenadores(){
    
        ListaOrdenadores = new ArrayList<>();
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
    public void modificarPortatil(int i){
        
        ListaOrdenadores.get(i).setPortatil();
    }
    public void modificarPrecio(int i,double precio){
        
        ListaOrdenadores.get(i).setPrecio(precio);
    }
    public int Size(){

        return ListaOrdenadores.size();
    }

    public String toString(){
        
        int contador=1;
        StringBuilder sb = new StringBuilder(); 
        sb.append("Catalogo Ordenadores:\n");

        for(Ordenador ordenador : ListaOrdenadores) {
            sb.append(contador).append(".").append(ordenador.toString()).append("\n");
            contador++;
        }
        return sb.toString();
    }
    public void leer(){
        //Lee los datos y inicializa catalogo como los datos del fichero o si falla en hacerlo lo inicializa en vacio
        ObjectInputStream oi;
        try{
            
            oi = new ObjectInputStream(new FileInputStream("CATALOGO.dat")); 
            ListaOrdenadores = (ArrayList<Ordenador>) oi.readObject();
            oi.close();
        } catch (Exception e){
            
            ListaOrdenadores = new ArrayList<>();
        }
    }
    public void escribir(){
        //Guarda el objeto
        ObjectOutputStream oo;
        try{
            
            oo= new ObjectOutputStream(new FileOutputStream("CATALOGO.dat"));
            oo.writeObject(ListaOrdenadores);
            oo.close();
        } 
        catch (Exception e){
            
            System.out.print("Error al guardar los datos en el fichero");
        }
    }
}