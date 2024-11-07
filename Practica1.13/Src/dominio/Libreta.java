package dominio;

import java.util.ArrayList;
import java.io.*;

public class Libreta implements Serializable{
    
    ArrayList<Contacto> lista;

    public Libreta() {
        lista = new ArrayList<>();
    }
    public Contacto buscar(Contacto c){

        int p = lista.indexOf(c);
        if(p == -1){
        
            return null;
        }
        return lista.get(p);
    }
    public Libreta add(Contacto c){

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
    public boolean modificarContacto(Contacto contacto,String modificar,String valor){

        if (lista.contains(contacto)){
            
            if(modificar.equals("nombre")){

                buscar(contacto).SetNombre(valor);
                return true;
            }
            else if(modificar.equals("apellidos")){

                buscar(contacto).setApellidos(valor);
                return true;
            }
            else if(modificar.equals("telefono")){

                buscar(contacto).setTelefono(valor);
                return true;
            }
            else if(modificar.equals("email")){

                buscar(contacto).setEmail(valor);
                return true;
            }
        }
        return false;
    }
    public boolean borrarContacto(Contacto contacto){
       
        int i = lista.indexOf(contacto);
        if (i != -1) {
            
            lista.remove(i);
            return true;
        }
        return false;
    }
    public int size(){

        return lista.size();
    }
    public static Libreta leer(){

        try{
           
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream ("AGENDA.dat"));
            Libreta agenda = (Libreta) oi.readObject();
            oi.close();
            return agenda;
        
        }catch (Exception e){

            return new Libreta();
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
