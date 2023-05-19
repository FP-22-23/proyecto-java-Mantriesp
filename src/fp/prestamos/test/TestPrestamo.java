package fp.prestamos.test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import fp.common.Area;
import fp.common.Genero;
import fp.common.Persona;
import fp.prestamos.Prestamo;


public class TestPrestamo {
	
	public static void main(String[] args) {
		//Creación Tipo Base con Constructor 1
		Persona m = new Persona("MALE", "Manuel", "Triguero");
		List<Integer> l = new ArrayList<Integer>(Arrays.asList(50000, 2000, 0));
		Prestamo p = new Prestamo("ABC123", m, 2, true, false, 50000.0f, 10000.0f, 1, 12, true, Area.RURAL, LocalDate.of(1999, 3, 12), l);
		
		//Creación Tipo Base con Constructor 2
		Persona m2 = new Persona("MALE", "Juan", "Triguero");
		Prestamo p2 = new Prestamo("ABC124", m2, 2, false, true, 60000.0f, 12000.0f, 1, 12, true, Area.RURAL);
		
		//toString de los Viajes creados para comprobar que funcionan ambos
		System.out.println(p);
		System.out.println(p2);
		
		//compareTo y equals para verificar funcionamiento
		List<Integer> l2 = new ArrayList<Integer>(Arrays.asList(567000, 3000, 2000));
		p2.setListaActivos(l2);
		p2.setFechaPres(LocalDate.of(2003, 11, 24));
		System.out.println(p.compareTo(p2));
		System.out.println(p.equals(p2));
		System.out.println(p.getPersona().getGenero());
		
		//Metodo de la propiedad derivada
		System.out.println(p.getIngresoTotal());
		
		//Comprobar los checkers

			//Checker ingreso aplicante
		try {
			p.setIngApl(-150.0f);
		} catch(IllegalArgumentException e) {
			System.out.println("Excepción capturada:\n   " + e);			
		}
		
			//Checker plazo
		
		try {
			p.setPlazo(-10);
		} catch(IllegalArgumentException e) {
			System.out.println("Excepción capturada:\n   " + e);			
		}
		
			//Checker dependientes

		try {
			p.setDependientes(-1);
		} catch(IllegalArgumentException e) {
			System.out.println("Excepción capturada:\n   " + e);			
		}
		
			//Checker ingreso coaplicante
		
		try {
			p.setIngCoapl(-50.0f);
		} catch(IllegalArgumentException e) {
			System.out.println("Excepción capturada:\n   " + e);			
		}
		
	}
	
}
