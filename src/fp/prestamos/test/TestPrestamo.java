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
		List<Integer> l2 = new ArrayList<>(Arrays.asList(20000,0,0));
		Prestamo p2 = new Prestamo("ABC124", m2, 2, false, true, 60000.0f, 12000.0f, 1, 12, true, Area.RURAL, LocalDate.of(1990, 4, 10), l2);
		
		//toString de los Viajes creados para comprobar que funcionan ambos
		System.out.println(p);
		System.out.println(p2);
		
		//compareTo y equals para verificar funcionamiento
		System.out.println(p.compareTo(p2));
		System.out.println(p.equals(p2));
		
		//Metodo de la propiedad derivada
		System.out.println(p.getIngresoTotal());
		
		//Comprobar los checkers
			//Checker "Fecha no puede ser posterior a 2010"
		p.setFechaPres(LocalDate.now());
			//Checker "El ingreso aplicante no puede ser menor a 0"
		p.setIngApl(-150.0f);
		
		


}
	

}
