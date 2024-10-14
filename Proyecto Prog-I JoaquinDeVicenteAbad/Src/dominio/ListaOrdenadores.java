package dominio;

import java.util.ArrayList;
import java.io.Serializable;

public class ListaOrdenadores implements Serializable{

/* 
 *Clase ListaOrdenadores que es un arrayList del tipo Ordenador. 
 *
 *tenemos definido  un constructor vacio.
 *
 *Un metodo annadir que añade un ordenador al arrayList.
 *Un metodo eliminar que elimina un ordenador del arrayList.
 * 
 *Una serie de metodos modificar que modifican respectivamente diferentes atributos 
 *dados el indice del arrayList.
 *
 *Un metodo Size que devuelve el tamaño de nuestro ArrayList.
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