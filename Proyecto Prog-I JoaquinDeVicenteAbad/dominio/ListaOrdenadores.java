package dominio;

import java.util.ArrayList;
import java.util.List;

public class ListaOrdenadores{

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

    public String toString(){

        int contador=1;
        StringBuilder resultado = new StringBuilder();
        resultado.append("Catalogo Ordenadores:\n");

        for (Ordenador ordenador : ListaOrdenadores) {
            resultado.append(contador+".").append(ordenador.toString()).append("\n");
            contador++;
        }

        return resultado.toString();
    }
}