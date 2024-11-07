package dominio;

import java.io.Serializable;


public class Contacto implements Serializable{

	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;

	public Contacto(String nombre, String apellidos, String telefono, String email){
	
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
	}
	public Contacto(String nombre,String apellidos){
	
		this.nombre = nombre;
		this.apellidos= apellidos;
	}
    public Contacto(){

        nombre = "";
        apellidos = "";
    }
	
	public String getNombre(){
	
	return nombre;
	}
	public String getApellidos(){
	
	return apellidos;
	}
	public String getTelefono(){
	
	return telefono;
	}
	public String getEmail(){
	
	return email;
	}
	
	public Contacto SetNombre(String nombre){
	
	this.nombre = nombre;
	return this;
	}
	
	public Contacto setApellidos(String apellidos){
	
	this.apellidos=apellidos;
	return this;
	}
	public Contacto setTelefono (String telefono){
	
	this.telefono = telefono;
	return this;
	}
	public Contacto setEmail (String email){
	
	this.email = email;
	return this;
	}

	public String toString(){ 
	
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre: ").append(nombre)
		.append(", Apellidos: ").append(apellidos)
		.append("\n con el telefono: ")
		.append(telefono)
		.append(" y correo: ")
		.append(email);
		return sb.toString();
	}
	
	public boolean equals(Object o){
		
		if (o == null){
		
			return false;
		}
        if(this.getClass() != o.getClass()){
		
			return false;
		}
		Contacto contacto = (Contacto) o;	
		return nombre.equals(contacto.nombre) && apellidos.equals(contacto.apellidos);
	}
	public int hashCode(){
	
		return nombre.hashCode()*13+apellidos.hashCode();
	}
}