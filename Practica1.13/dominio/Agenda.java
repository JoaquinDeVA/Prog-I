package dominio;

import java.util.ArrayList;
import java.io.*;

public class Agenda implements Serializable{
    
    ArrayList<Contacto> lista;

    public Agenda() {
        lista = new ArrayList<>();
    }
    public Contacto buscar(Contacto c){

        int p = lista.indexOf(c);
        if(p == -1){
        
            return null;
        }
        return lista.get(p);
    }
    public Agenda add(Contacto c){

        lista.add(c);
        return this;
    }
    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append("Contactos: \n");
        for (Contacto contacto : lista) {
         
            sb.append(contacto.toString()).append("\n");
            
        }
    
        return sb.toString();
    }
    public void modificarContacto(Contacto contacto,String modificar,String valor){

        if(modificar.equals("nombre")){

            buscar(contacto).SetNombre(valor);
        }
        else if(modificar.equals("apellidos")){

            buscar(contacto).setApellidos(valor);
        }
        else if(modificar.equals("telefono")){

            buscar(contacto).setTelefono(valor);
        }
        else if(modificar.equals("email")){

            buscar(contacto).setEmail(valor);
        }
    }
    public void borrarContacto(Contacto contacto){

        lista.remove(contacto);
    }
    public int size(){

        return lista.size();
    }
    public static Agenda leer(){

        try{
           
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream ("AGENDA.dat"));
            Agenda agenda = (Agenda) oi.readObject();
            oi.close();
            return agenda;
        
        }catch (Exception e){

            return new Agenda();
        }
    }
    public void guardar(){

        try{

            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream ("AGENDA.dat"));
            oo.writeObject(this);
            oo.close();
        }catch (Exception e){
            
            System.out.println("Error de guardado");
        }

    }
}
