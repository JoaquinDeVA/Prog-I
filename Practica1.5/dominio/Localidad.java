package dominio;

public class Localidad {

    private String nombre;
    private int numeroDeHabitantes;

    public Localidad ( String nombre, int numeroDeHabitantes){

        this.nombre = nombre;
        this.numeroDeHabitantes = numeroDeHabitantes;
    }
    public void setNombre ( String nombre){

        this.nombre=nombre;
    }
    public void setNumeroHabitantes(int numero){
        
        numeroDeHabitantes=numero;
    }
    public String getNombre(){

        return nombre;
    }
    public int getNumeroHabitantes(){
        
        return numeroDeHabitantes;
    }
    @Override
    public String toString(){
        return nombre +": " + numeroDeHabitantes + " Habitantes";
    }
    
}
