package dominio;

import java.util.ArrayList;
import java.io.*;

public class Pais implements Serializable {
    
    private String nombre;
    private ArrayList<Provincia> provincias;
    
    public Pais(String nombre){

        this.nombre=nombre;
        provincias = new ArrayList<>(); 
    }
    public Pais add(Provincia provincia){
        
        provincias.add(provincia);
        return this;
    }
    public String getNombre() {
        
        return nombre;
    }
    public int getPoblacion(){
        
        int poblacion=0;
        for(Provincia provincia:provincias){
            
            poblacion+=provincia.getPoblacion();
        }
        return poblacion;
    }
    public ArrayList<Provincia> getProvincias(){
       
        return provincias;
    }
    public Provincia getProvincia(int i){
       
        return provincias.get(i);
    }
    public String toString(){
       
        int n=0;
        StringBuilder st = new StringBuilder();
        st.append("Pais: "+nombre+" Población: "+getPoblacion() +" habitantes\n ");
        for(Provincia provincia : provincias){
            
            st.append(n+") "+provincia.toString()+" ");
            n++;
        }
        return st.toString();
        
    }
    public int size(){
       
        return provincias.size();
    }
    public void grabar(){

        try{
        
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("pais.ser"));
            oo.writeObject(this);
            oo.close();
            System.out.println("Los datos se han guardado correctamente");
        } catch (Exception e){

            System.out.println("Error de escritura");
        }
    }
    public static Pais leer(){

        try{

            ObjectInputStream oi = new ObjectInputStream(new FileInputStream("pais.ser"));
            Pais p = (Pais)oi.readObject();
            oi.close();
            return p;
        } catch (Exception e){

            return new Pais("Espana");
        }

    }

}