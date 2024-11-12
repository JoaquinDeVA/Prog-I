package interfaz;

import dominio.*;
import excepciones.*;
import java.util.Scanner;

public class Interfaz {

    private Libreta agenda;
    private Scanner sc = new Scanner(System.in);
    
    public Interfaz(){

        agenda = Libreta.leer();
    }
    public void InterfazUsuario(){

        help();
        while (true){
        
            System.out.println("Introduzca la instruccion: ");
            String[] instr = procesarPeticion();
        
            if(instr[0].equals("help")){

                help();
            }
            else if(instr[0].equals("add")){

                aniadir(instr[1],instr[2],instr[3],instr[4]);
            }
            else if(instr[0].equals("list")){

                list();
            }
            else if(instr[0].equals("remove")){

                remove(instr[1],instr[2]);
            }
            else if(instr[0].equals("modify")){

                modificar(instr[1],instr[2],instr[3],instr[4]);
            }
            else if(instr[0].equals("search")){
                
                buscar(instr[1],instr[2]);
            }
            else if(instr[0].equals("setFavorite")){

                setFavorito(instr[1],instr[2]);
            }
            else if(instr[0].equals("favorites")){

                favoritos();
            }
            else if (instr[0].equals("exit")){
                
                agenda.guardar();
                break;
            } else{System.out.println("\n INSTRUCCION NO VALIDA\n"); help();}
        }
    }
    private String[]  procesarPeticion(){

        String[] resul;
        String instr = sc.nextLine();
        resul = instr.split(",");        

        return resul;        
    }

    private void list(){

        System.out.println(agenda.toString());
    }
    private void help(){

        System.out.println("Instrucciones disponibles: \n -help para este menu de ayuda \n -list para mostrar por pantalla los contactos \n"
        +" -add para aniadir con el siguiente formato: \n \t add,<Nombre>,<Apellidos>,<NumeroDeTelefono>,<Email> \n"+
        " -remove para borrar con el siguiente formato: \n \t remove,<Nombre>,<Apellidos> \n" +
        " -modify para modificar con el siguiente formato: \n \t modify,<Nombre>,<Apellidos> (del contacto a modificar)"+
         ",<valor a modificar>,<valor nuevo> \n \t \tEJEMPLO: modify,Joaquin,de Vicente,telefono,123456789 Valores modificables:"+
         " nombre,apellidos,telefono,email" + "\n -search para buscar un contacto Con el siguiente formato: \n \t search,<Nombre>,<Apellidos>"+
         "\n -setFavorite para cambiar a favorito o no un contacto con el siguiente formato \n\t setFavorite,<Nombre>,<Apellidos>"
         +"\n -favorites para imprimir por pantalla los contactos favoritos"+"\n -exit para cerrar la agenda");
    }
    private void aniadir(String nombre,String apellido,String numeroDeTelefono,String email ){
        
        try{
            
            agenda.add(new Contacto(nombre,apellido,numeroDeTelefono,email));
            System.out.println("Contacto aniadido");
        } catch (ContactoDuplicadoException e){

            System.out.println("\n El contacto: " + e.getContacto().getNombre() + " " +e.getContacto().getApellidos() + " ya existe" );
        }
    }
    private void remove(String nombre,String apellido){
        
        try{
            
            agenda.borrarContacto(new Contacto(nombre,apellido));
        } catch(NoEncontradoException e){ 
            
            System.out.println("El contacto: " + e.getContacto().getNombre() + " " + e.getContacto().getApellidos()+" no se ha encontrado");
        }
    }
    private void modificar(String nombre,String apellido,String atributo,String nuevo){

        try{
            
            Libreta libreta = agenda.modificarContacto(new Contacto(nombre,apellido), atributo, nuevo);
            if(libreta == null){

                System.out.println("El atributo a modificar es incorrecto");
            }
        } catch (NoEncontradoException e){
           
            System.out.println("El contacto: "+e.getContacto().getNombre() + " " + e.getContacto().getApellidos() + " no existe ");
            System.out.println("¿Desea añadirlo? Y/N");
            if(sc.next().equals("Y")){
                sc.nextLine();
                System.out.println("introduzca su numero de telefono y despues su correo");
                String telefono = sc.next();
                String correo = sc.next();
                try{

                    agenda.add( new Contacto(e.getContacto().getNombre(),e.getContacto().getApellidos(),telefono,correo));
                }catch(ContactoDuplicadoException excepcion){}
            }
        }
    }
    private void setFavorito(String nombre,String apellido){

        try{
            
            agenda.cambiarFavorito(new Contacto(nombre,apellido));
            System.out.println("Cambio ejecutado");
        }catch (NoEncontradoException e){
            System.out.println("El contacto: "+e.getContacto().getNombre() + " " + e.getContacto().getApellidos() + " no existe ");
            System.out.println("¿Desea añadirlo? Y/N");
            if(sc.next().equals("Y")){
                
                System.out.println("introduzca su numero de telefono y despues su correo");
                String telefono = sc.next();
                String correo = sc.next();
                try{

                    agenda.add( new Contacto(e.getContacto().getNombre(),e.getContacto().getApellidos(),telefono,correo));
                }catch(ContactoDuplicadoException excepcion){}
                sc.nextLine();
            }
        }
    }
    private void favoritos(){

       System.out.println(agenda.favoritos());
    }
    private void buscar(String nombre, String apellidos){

        Contacto c = agenda.buscar(new Contacto(nombre,apellidos));
        if(c == null){

            System.out.println("El contacto no esta registrado");
            return;
        }

        System.out.println("El contacto esta registrado en la agenda");
        System.out.println(c.toString());
        }
}