package interfaz;

import dominio.*;

import java.util.Scanner;

public class Interfaz {

    private Agenda agenda;
    private Scanner sc = new Scanner(System.in);
    
    public Interfaz(){

        agenda = Agenda.leer();
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
        " -remove para borrar con el siguiente formato: \n \t remove,<Nombre>,<Apellidos> \n -exit para cerrar la agenda\n"+
        " -modify para modificar con el siguiente formato: \n \t modify,<Nombre>,<Apellidos> (del contacto a modificar)"+
         ",<valor a modificar>,<valor nuevo> \n \t \tEJEMPLO: modify,Joaquin,de Vicente,telefono,123456789\n donde los valores modificable son:"+
         " nombre,apellidos,telefono,email");
    }
    private void aniadir(String nombre,String apellido,String numeroDeTelefono,String email ){
        agenda.add(new Contacto(nombre,apellido,numeroDeTelefono,email));
        System.out.println("Contacto aniadido");
    }
    private void remove(String nombre,String apellido){
        
        agenda.borrarContacto(new Contacto(nombre,apellido));
        System.out.println("Contacto borrado");
    }
    private void modificar(String nombre,String apellido,String atributo,String nuevo){

        if(atributo.equals("nombre") || atributo.equals("apellidos") || atributo.equals("telefono") || atributo.equals("email")){
            
            agenda.modificarContacto(new Contacto(nombre,apellido), atributo, nuevo);
            System.out.println("Contacto modificado");
        } else{
           
            System.out.println("ATRIBUTO NO VALIDO");
        }
    }
}