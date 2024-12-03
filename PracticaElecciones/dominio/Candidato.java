package dominio;


public class Candidato {

    private int votos;
    private String nombre;

    public Candidato(String nombre){

        this.nombre = nombre;
        votos = 0;
    }

    public void incrementarVotos(){

        votos++;
    }
    public void resetearVotos(){

        votos = 0;
    }
    public String getNombre(){

        return nombre;
    }
    public int getVotos(){

        return votos;
    }
    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append("El candidato: ").append(nombre).append(". Tiene ").append(votos).append(" votos");
        return sb.toString(); 
    }
    public boolean equals(Object o){

        if( o == null){

            return false;
        }
        if(!o.getClass().equals(this.getClass())){

            return false;
        }
        Candidato candidato = (Candidato) o;

        return nombre.equals(candidato.getNombre());
    }
    public int hashCode(){

        return nombre.hashCode();   
    }
}
