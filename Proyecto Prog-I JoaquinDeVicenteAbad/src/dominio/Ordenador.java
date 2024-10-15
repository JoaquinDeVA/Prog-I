package dominio;

import java.io.Serializable;

public class Ordenador implements Serializable {
    
//Clase Ordenador con su constructor de tres parametros sus setters,getters y metodo toString
    private String modelo;
    private boolean portatil;
    private double precio;

    public Ordenador(String modelo,boolean portatil,double precio){

        this.modelo = modelo;
        this.portatil = portatil;
        this.precio = precio;
    }

    public void setModelo(String modelo){
        
        this.modelo=modelo;
    }
    public void setPortatil(){
        //Como el constructor siempre define un valor cambia el valor por el contrario
        if(portatil == false){
            portatil = true;
        }else{
            portatil = false;
        }
    }
    public void setPrecio(double precio){
        
        this.precio=precio;
    }
    public String getModelo(){

        return modelo;
    }
    public boolean getPortatil(){
        
        return portatil;
    }
    public double getPrecio(){

        return precio;
    }


    public String toString(){
        
        return "{Modelo: "+modelo+", Portatil: "+portatil+", Precio: "+precio+"}";
    }

}

