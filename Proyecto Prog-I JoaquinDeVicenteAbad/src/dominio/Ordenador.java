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
        portatil = !portatil;
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
        
        StringBuilder sb = new StringBuilder();
        sb.append("{Modelo: ").append(modelo)
        .append(", Portatil: ").append(portatil)
        .append(", Precio: ").append(precio).append("}");
        return sb.toString();
    }

}

