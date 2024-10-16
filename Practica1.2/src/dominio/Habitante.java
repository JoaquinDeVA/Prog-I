package dominio;

import java.io.Serializable;
public class Habitante implements Serializable{
      
    private String nombre;  
    private String apellido1;
    private String apellido2;

    public Habitante(){
        
    }
    public Habitante(String nombre,String apellido1,String apellido2){

        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }
   public void setNombre(String nombre){
           
        this.nombre = nombre;   
    }
//como el nombre de la variable como parametro es el mismo nombre de la variable de la clase usamos this. para referirnos a la variable de la clase
    public void setApellido1(String apellido1){
            
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2){
            
        this.apellido2 = apellido2;
    }
    public String getNombre(){
            
        return nombre;
    }

    public String getApellido1(){
            
        return apellido1;
    }
    public String getApellido2(){
           
        return apellido2;
    }
    public String toString(){
            
        return nombre + " " + apellido1 + " " + apellido2;
    }
}
