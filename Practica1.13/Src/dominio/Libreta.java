package dominio;

import java.util.ArrayList;

import excepciones.ContactoDuplicadoException;
import excepciones.NoEncontradoException;
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
    public Libreta add(Contacto c) throws ContactoDuplicadoException{

        if(lista.contains(c)){

            throw new ContactoDuplicadoException(c);
        }
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
    public Libreta modificarContacto(Contacto contacto,String modificar,String valor) throws NoEncontradoException{

        if (lista.contains(contacto)){
            
            if(modificar.equals("nombre")){

                buscar(contacto).SetNombre(valor);
                return this;
            }
            else if(modificar.equals("apellidos")){

                buscar(contacto).setApellidos(valor);
                return this;
            }
            else if(modificar.equals("telefono")){

                buscar(contacto).setTelefono(valor);
                return this;
            }
            else if(modificar.equals("email")){

                buscar(contacto).setEmail(valor);
                return this;
            }
            return null;
        }
        throw new NoEncontradoException(contacto);
    }
    public Libreta borrarContacto(Contacto contacto) throws NoEncontradoException{
       
        int i = lista.indexOf(contacto);
        if (i != -1) {
            
            lista.remove(i);
            return this;
        }
        throw new NoEncontradoException(contacto); 
    }
    public int size(){

        return lista.size();
    }
    public Libreta cambiarFavorito(Contacto contacto) throws NoEncontradoException{

        Contacto c = buscar(contacto);
        if (c != null){
            
            c.setFavorito();
            return this;
        }
        throw new NoEncontradoException(contacto);
    }
    public String favoritos(){

        StringBuilder sb = new StringBuilder();
        sb.append("Contactos favoritos: \n");
        for(Contacto contacto : lista){
            if(contacto.getFavorito()){
                sb.append(contacto.toString());
            }
        }
        return sb.toString();
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
