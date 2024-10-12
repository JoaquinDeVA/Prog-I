package dominio;

public class Ordenador {
    
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
    public void setPortatil(boolean portatil){
        
        this.portatil=portatil;
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
        
        return "{Modelo: "+modelo+" Portatil: "+portatil+" Precio: "+precio+"}";
    }

}

