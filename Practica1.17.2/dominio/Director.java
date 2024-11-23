package dominio;


public class Director extends Participante {
    
    public Director(String nombre){

        super(nombre);
    }
    
    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append(getNombre()).append(", Director");
        return sb.toString();
    }
}
