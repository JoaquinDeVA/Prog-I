package excepciones;

import dominio.Contacto;

public class NoEncontradoException extends Exception {
 
    private Contacto c;

    public NoEncontradoException(){

    }
    public NoEncontradoException(Contacto c){

        this.c = c;
    }
    public Contacto getContacto(){

        return c;
    }

}
