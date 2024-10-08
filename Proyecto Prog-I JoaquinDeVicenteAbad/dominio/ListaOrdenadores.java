package dominio;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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
                boolean portatil = Boolean.parseBoolean(sc.next());
                double precio = Double.parseDouble(sc.next());
                ListaOrdenadores.add(new Ordenador(modelo,portatil,precio));
            }
            sc.close();
        } catch (IOException ex){System.out.print("No hay un catalogo guardado");}
    }
    

    public String toString(){

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