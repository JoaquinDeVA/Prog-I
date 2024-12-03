package excepciones;


import dominio.*;
public class NoExisteException extends Exception{

    private Papeleta papeleta;
    private Candidato candidato;

    public NoExisteException(){

    }
    
    public NoExisteException(Candidato candidato){

        this.candidato = candidato;
    }

    




}