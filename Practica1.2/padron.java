import presentacion.InterfazUsuario;

public class padron {   
    public void main(String[] args) {

        String [] datosMostrar = new String[1];
        datosMostrar[0] = args[0];
        if (args[0].equalsIgnoreCase("mostrar")) {
            datosMostrar[0] = args[0];
            InterfazUsuario.ejecutar(datosMostrar);
        } else {
            InterfazUsuario.ejecutar(args);
        }
        
            
 
//       new Comprobacion().realizarComprobacion();
 //la invocacion de habitante necesitara de parametros del constructor   
 //       Habitante persona = new Habitante("juan","perez","Abad");
 //       System.out.println(persona.nombre + " " + persona.apellido1 + " " + persona.apellido2);

        
    }
}
