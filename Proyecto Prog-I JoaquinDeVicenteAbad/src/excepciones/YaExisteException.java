package excepciones;

import dominio.Ordenador;

public class YaExisteException extends Exception{
 
    private Ordenador ordenador;

    public YaExisteException(){

    }

    public YaExisteException(Ordenador ord){
        ordenador = ord;
    }
    public Ordenador getOrdenador(){
        
        return ordenador;
    }
}
