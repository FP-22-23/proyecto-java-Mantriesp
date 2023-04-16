package fp.prestamos.test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import fp.common.Area;
import fp.common.Persona;
import fp.prestamos.Prestamo;
import fp.prestamos.Prestamos;

public class TestPrestamos {
	private static Persona persona1 = new Persona("Male", "Juan", "Gonzalez");
	private static Persona persona2 = new Persona("Female", "Angela", "Lopez");
	private static Persona persona3 = new Persona("Male", "Pablo", "Garcia");
	private static Persona persona4 = new Persona("Female", "Laura", "Martinez");
	private static Persona persona5 = new Persona("Male", "Javier", "Sanchez");
	private static Persona persona6 = new Persona("Female", "Ana", "Fernandez");
	private static Persona persona7 = new Persona("Male", "David", "Jimenez");
	private static Persona persona8 = new Persona("Female", "Lucia", "Ruiz");
	private static Persona persona9 = new Persona("Male", "Carlos", "Moreno");
	private static Persona persona10 = new Persona("Female", "Sara", "Navarro");
	
	private static List<Integer> listaActivos1 = Arrays.asList(1000, 2500, 5000);
	private static List<Integer> listaActivos2 = Arrays.asList(1500, 3000, 6000);
	private static List<Integer> listaActivos3 = Arrays.asList(1200, 2800, 5500);
	private static List<Integer> listaActivos4 = Arrays.asList(2000, 4000, 8000);
	private static List<Integer> listaActivos5 = Arrays.asList(800, 1800, 3500);
	private static List<Integer> listaActivos6 = Arrays.asList(900, 2000, 4000);
	private static List<Integer> listaActivos7 = Arrays.asList(1100, 2400, 4500);
	private static List<Integer> listaActivos8 = Arrays.asList(1400, 3200, 6000);
	private static List<Integer> listaActivos9 = Arrays.asList(1300, 3000, 5800);
	private static List<Integer> listaActivos10 = Arrays.asList(1700, 3800, 7000);
	
	private static Prestamo prestamo1 = new Prestamo("P001", persona1, 0, false, true, 2000f, 1000f, 1, 12, true, Area.RURAL, LocalDate.of(1999, 3, 15), listaActivos1);
	private static Prestamo prestamo2 = new Prestamo("P002", persona2, 1, true, false, 1500f, 500f, 2, 24, false, Area.SEMIURBAN, LocalDate.of(1998, 4, 20), listaActivos2);
	private static Prestamo prestamo3 = new Prestamo("P003", persona3, 2, true, true, 1500f, 500f, 1, 12, true, Area.URBAN, LocalDate.of(1997, 5, 12), listaActivos3);
	private static Prestamo prestamo4 = new Prestamo("P004", persona4, 0, true, false, 2000f, 1000f, 3, 24, false, Area.SEMIURBAN, LocalDate.of(1996, 2, 8), listaActivos4);
	private static Prestamo prestamo5 = new Prestamo("P005", persona5, 1, true, true, 2500f, 1200f, 2, 18, true, Area.RURAL, LocalDate.of(1995, 11, 3), listaActivos5);
	private static Prestamo prestamo6 = new Prestamo("P006", persona6, 3, false, false, 3000f, 1500f, 1, 6, false, Area.URBAN, LocalDate.of(1994, 9, 15), listaActivos6);
	private static Prestamo prestamo7 = new Prestamo("P007", persona7, 2, false, true, 1800f, 900f, 2, 12, false, Area.RURAL, LocalDate.of(1993, 1, 7), listaActivos7);
	private static Prestamo prestamo8 = new Prestamo("P008", persona8, 0, true, false, 2200f, 1100f, 3, 24, false, Area.SEMIURBAN, LocalDate.of(1992, 3, 1), listaActivos8);
	private static Prestamo prestamo9 = new Prestamo("P009", persona9, 1, true, true, 2800f, 1300f, 2, 18, true, Area.SEMIURBAN, LocalDate.of(1991, 12, 12), listaActivos9);
	private static Prestamo prestamo10 = new Prestamo("P010", persona10, 2, false, false, 3500f, 1700f, 1, 6, true, Area.URBAN, LocalDate.of(1990, 7, 28), listaActivos10);
	
	private static Prestamos prestamos = new Prestamos();

	public static void main(String[] args) {
		testConstructor();
		testExisteParaTodoGraduado();
		testContarPrestamosConPlazoMayorOIgualQue();
		testCalcularMediaCantidadPrestamosParaAutonomos();
		testSeleccionarPrestamosConIngresosSuperioresA();
		testAgruparPrestamosPorArea();
		testAcumularPrestamosPorGenero();
	}
	
	private static void testConstructor() {
		System.out.println("Test del Constructor");
		try {
			prestamos = new Prestamos();
			prestamos.añadirPrestamo(prestamo1);
			prestamos.añadirPrestamo(prestamo2);
			prestamos.añadirPrestamo(prestamo3);
			prestamos.añadirPrestamo(prestamo4);
			prestamos.añadirPrestamo(prestamo5);
			prestamos.añadirPrestamo(prestamo6);
			prestamos.añadirPrestamo(prestamo7);
			prestamos.añadirPrestamo(prestamo8);
			prestamos.añadirPrestamo(prestamo9);
			prestamos.añadirPrestamo(prestamo10);
			
			System.out.println("Prestamos: " + prestamos + "\n");
		} catch(Exception e) {
			System.out.println("Excepcion capturada: " + e);
		}
	}
	
	private static void testExisteParaTodoGraduado() {
		System.out.println("\n Test de existeParaTodoGraduado: ");
		try {
			System.out.println("¿Existe algun prestamo para alguien que no este graduado?: " + prestamos.existePrestamoParaTodoGraduado(false));
		} catch(Exception e) {
			System.out.println("Excepcion capturada: " + e);
		}
	}
	
	private static void testContarPrestamosConPlazoMayorOIgualQue() {
		System.out.println("\n Test de contarPrestamosConPlazoMayorOIgualQue: ");
		try {
			System.out.println("¿Cuantos prestamos con plazo mayor a 10 meses hay?: " + prestamos.contarPrestamosConPlazoMayorOIgualQue(10));
		} catch(Exception e) {
			System.out.println("Excepcion capturada: " + e);
		}
	}
	
	private static void testCalcularMediaCantidadPrestamosParaAutonomos() {
		System.out.println("\n Test de calcularMediaCantidadPrestamosParaAutonomos: ");
		try {
			System.out.println("¿Cual es la media de prestamos que tienen los autonomos?: " + prestamos.calcularMediaCantidadPrestamosParaAutonomos(true));
		} catch(Exception e) {
			System.out.println("Excepcion capturada: " + e);
		}
	}
	
	private static void testSeleccionarPrestamosConIngresosSuperioresA() {
		System.out.println("\n Test de seleccionarPrestamosConIngresosSuperioresA: ");
		try {
			System.out.println("¿Que prestamos tienen un ingreso del aplicante mayor a 2000?: " + prestamos.seleccionarPrestamosConIngresosSuperioresA(2000f));
		} catch(Exception e) {
			System.out.println("Excepcion capturada: " + e);
		}
	}
	
	private static void testAgruparPrestamosPorArea() {
		System.out.println("\n Test de agruparPrestamosPorArea: ");
		try {
			System.out.println("Una lista de los prestamos que existen agrupados en RURAL, URBAN y SEMIURBAN: " + prestamos.agruparPrestamosPorArea());
		} catch(Exception e) {
			System.out.println("Excepcion capturada: " + e);
		}
	}
	
	private static void testAcumularPrestamosPorGenero() {
		System.out.println("\n Test de acumularPrestamosPorGenero: ");
		try {
			System.out.println("¿Hay algun hombre autonomo que tenga prestamo?, en ese caso, ¿Cuantos?: " + prestamos.acumularPrestamosPorGenero("Male"));
		} catch(Exception e) {
			System.out.println("Excepcion capturada: " + e);
		}
	}
}
