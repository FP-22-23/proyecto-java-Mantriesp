package fp.common;

public class Persona {
	
	private Genero genero;
	private String nombre;
	private String apellido;
	
	public Persona(Genero genero, String nombre, String apellido) {
		this.genero = genero;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Genero getGenero() {
		return genero;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	@Override
	public String toString() {
		return "Persona [genero=" + genero + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	

}
