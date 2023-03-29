package fp.prestamos.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fp.common.Area;
import fp.common.Genero;
import fp.prestamos.Prestamo;


public class TestPrestamos {
	
	public static void main(String[] args) {
		//Creación Tipo Base con Constructor 1
		Prestamo p = new Prestamo("ABC123", Genero.MALE, 2, true, false, 50000.0f, 10000.0f, 1, 12, true, Area.RURAL, LocalDate.of(1999, 3, 12), true);
		
		//Creación Tipo Base con Constructor 2
		Prestamo p2 = new Prestamo("ABC124", Genero.FEMALE, 2, false, true, 60000.0f, 12000.0f, 1, 12, true, Area.RURAL, LocalDate.of(1990, 4, 10), false);
		
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
