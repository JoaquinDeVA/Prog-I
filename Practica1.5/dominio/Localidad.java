package dominio;

import java.io.Serializable;

public class Localidad implements Serializable {

    private String nombre;
    private int poblacion;

    public Localidad ( String nombre, int poblacion){

        this.nombre = nombre;
        this.poblacion = poblacion;
    }
    public String setNombre ( String nombre_){

        nombre=nombre_;
        return nombre;
    }
    public int setNumeroHabitantes(int numero){
        
        poblacion=numero;
        return poblacion;
    }
    public String getNombre(){

        return nombre;
    }
    public int getPoblacion(){
        
        return poblacion;
    }
    @Override
    public String toString(){
        return nombre +", poblacion: " + poblacion + " Habitantes";
    }
    
}
