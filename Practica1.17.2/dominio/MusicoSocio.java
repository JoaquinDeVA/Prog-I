package dominio;

public class MusicoSocio extends Participante{
    
    private String instrumento;
    private int numSocio;

    public MusicoSocio(String nombre,String instrumento, int numSocio){

        super(nombre);
        this.instrumento = instrumento;
        this.numSocio = numSocio;
    }
    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append(getNombre()).append(", ").append(instrumento).append(", ").append("Numero de socio: ").append(numSocio);
        return sb.toString();
    }
}
