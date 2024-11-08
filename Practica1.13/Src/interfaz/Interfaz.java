package interfaz;

import dominio.*;

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
        
        agenda.add(new Contacto(nombre,apellido,numeroDeTelefono,email));
        System.out.println("Contacto aniadido");
    }
    private void remove(String nombre,String apellido){
        
        if(agenda.borrarContacto(new Contacto(nombre,apellido))){
        
            System.out.println("Contacto borrado");
            return;
        }
        System.out.println("Contacto no encontrado");
    }
    private void modificar(String nombre,String apellido,String atributo,String nuevo){

        if(agenda.modificarContacto(new Contacto(nombre,apellido), atributo, nuevo)){
            
            System.out.println("Contacto modificado");
        } else{
           
            System.out.println("El contacto no existe o el atributo introducido no es correcto");
        }
    }
    private void setFavorito(String nombre,String apellido){

       if(agenda.cambiarFavorito(new Contacto(nombre,apellido))){
            System.out.println("Cambio ejecutado");
            return;
       }
       System.out.println("El contacto no existe");
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