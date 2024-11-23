package dominio;


public abstract class Participante {
    
    private String nombre;

    public Participante(String nombre){

        this.nombre = nombre;
    }
    protected String getNombre(){

        return nombre;
    }
    public abstract String toString();

}
