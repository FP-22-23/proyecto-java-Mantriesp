package fp.prestamos.test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import fp.common.Area;
import fp.common.Persona;
import fp.prestamos.FactoriaPrestamos;
import fp.prestamos.Prestamo;
import fp.prestamos.Prestamos;

public class TestPrestamos {

	public static void main(String[] args) {
		
		Prestamos prestamos = FactoriaPrestamos.leerPrestamos("data/prestamos.csv");
		testExisteParaTodoGraduado(prestamos, true);
		testContarPrestamosConPlazoMayorOIgualQue(prestamos, 100);
		testCalcularMediaCantidadPrestamosParaAutonomos(prestamos, false);
		testSeleccionarPrestamosConIngresosSuperioresA(prestamos, 10000.0f);
		testAgruparPrestamosPorArea(prestamos);
		testAcumularPrestamosPorGenero(prestamos, Area.URBAN);
		testStreamExistePrestamoParaTodoGraduado(prestamos, false);
		testStreamContarPrestamosConPlazoMayorOIgualQue(prestamos, 365);
		testStreamSeleccionarPrestamosConIngresosSuperioresA(prestamos, 50000.0f);
		testStreamMaximoIngresoTotalPorArea(prestamos, Area.RURAL);
		testStreamSeleccionarPrestamosOrdenadosFecha(prestamos, LocalDate.of(2000, 1, 1));
		testStreamAgruparPrestamosPorDependientes(prestamos);
		testAgruparPrestamosPorPlazo(prestamos);
		testObtenerMaximosElementosPorArea(prestamos);
		testObtenerNMejoresElementosPorIngresoTotal(prestamos, 3);
		testObtenerClaveMayorIngreso(prestamos);
	}
		
	private static void testExisteParaTodoGraduado(Prestamos prestamos, Boolean graduado) {
		System.out.println("\n Test de existeParaTodoGraduado: ");
		try {
			System.out.println("¿Existe algun prestamo para alguien que su estado de graduado sea " + graduado + " ?: " + prestamos.existePrestamoParaTodoGraduado(graduado));
		} catch(Exception e) {
			System.out.println("Excepcion capturada: " + e);
		}
	}
	
	private static void testContarPrestamosConPlazoMayorOIgualQue(Prestamos prestamos, Integer plazo) {
		System.out.println("\n Test de contarPrestamosConPlazoMayorOIgualQue: ");
		try {
			System.out.println("¿Cuantos prestamos con plazo mayor a " + plazo + " meses hay?: " + prestamos.contarPrestamosConPlazoMayorOIgualQue(plazo));
		} catch(Exception e) {
			System.out.println("Excepcion capturada: " + e);
		}
	}
	
	private static void testCalcularMediaCantidadPrestamosParaAutonomos(Prestamos prestamos, Boolean autonomo) {
		System.out.println("\n Test de calcularMediaCantidadPrestamosParaAutonomos: ");
		try {
			System.out.println("¿Cual es la media de dinero en miles de dolares que tienen las personas que su estado de autonomo es " + autonomo + " ?: " + prestamos.calcularMediaCantidadPrestamosParaAutonomos(autonomo));
		} catch(Exception e) {
			System.out.println("Excepcion capturada: " + e);
		}
	}
	
	private static void testSeleccionarPrestamosConIngresosSuperioresA(Prestamos prestamos, Float ingApl) {
		System.out.println("\n Test de seleccionarPrestamosConIngresosSuperioresA: ");
		try {
			System.out.println("¿Que prestamos tienen un ingreso del aplicante mayor a " + ingApl + " ?: " + prestamos.seleccionarPrestamosConIngresosSuperioresA(ingApl));
		} catch(Exception e) {
			System.out.println("Excepcion capturada: " + e);
		}
	}
	
	private static void testAgruparPrestamosPorArea(Prestamos prestamos) {
		System.out.println("\n Test de agruparPrestamosPorArea: ");
		try {
			System.out.println("Una lista de los prestamos que existen agrupados en RURAL, URBAN y SEMIURBAN: " + prestamos.agruparPrestamosPorArea());
		} catch(Exception e) {
			System.out.println("Excepcion capturada: " + e);
		}
	}
	
	private static void testAcumularPrestamosPorGenero(Prestamos prestamos, Area area) {
		System.out.println("\n Test de acumularPrestamosPorGenero: ");
		try {
			System.out.println("¿Cuantas personas que residen en un area "+ area + " son autónomos y cuantos no? " + prestamos.acumularPrestamosPorGenero(area));
		} catch(Exception e) {
			System.out.println("Excepcion capturada: " + e);
		}
	}
	
	private static void testStreamExistePrestamoParaTodoGraduado(Prestamos prestamos, Boolean graduado) {
		System.out.println("\n Test método 1 BLOQUE I: ");
		try {
			System.out.println("¿Existe algun prestamo para alguien que su estado de graduado sea " + graduado + " ?: " + prestamos.streamExistePrestamoParaTodoGraduado(graduado));
		} catch(Exception e) {
			System.out.println("Excepcion capturada: " + e);
		}
	}
	
	private static void testStreamContarPrestamosConPlazoMayorOIgualQue(Prestamos prestamos, Integer plazo) {
		System.out.println("\n Test método 2 BLOQUE I: ");
		try {
			System.out.println("¿Cuantos prestamos con plazo mayor a " + plazo + " meses hay?: " + prestamos.streamContarPrestamosConPlazoMayorOIgualQue(plazo));
		} catch(Exception e) {
			System.out.println("Excepcion capturada: " + e);
		}
	}
	
	private static void testStreamSeleccionarPrestamosConIngresosSuperioresA(Prestamos prestamos, Float ingApl) {
		System.out.println("\n Test método 3 BLOQUE I: ");
		try {
			System.out.println("¿Que prestamos tienen un ingreso del aplicante mayor a " + ingApl + " ?: " + prestamos.streamSeleccionarPrestamosConIngresosSuperioresA(ingApl));
		} catch(Exception e) {
			System.out.println("Excepcion capturada: " + e);
		}
	}
	
	private static void testStreamMaximoIngresoTotalPorArea(Prestamos prestamos, Area area) {
		System.out.println("\n Test método 4 BLOQUE I: ");
		try {
			System.out.println("Cual es el ingreso total máximo en el area " + area + " ?: " + prestamos.streamMaximoIngresoTotalPorArea(area));
		} catch(Exception e) {
			System.out.println("Excepcion capturada: " + e);
		}
	}
	
	private static void testStreamSeleccionarPrestamosOrdenadosFecha(Prestamos prestamos, LocalDate fecha) {
		System.out.println("\n Test método 5 BLOQUE I: ");
		try {
			System.out.println("Lista de prestamos ordenados por plazo que se solicitaron antes de " + fecha + " : " + prestamos.streamSeleccionarPrestamosOrdenadosFecha(fecha));
		} catch(Exception e) {
			System.out.println("Excepcion capturada: " + e);
		}
	}
	
	private static void testStreamAgruparPrestamosPorDependientes(Prestamos prestamos) {
		System.out.println("\n Test método 1 BLOQUE II: ");
		try {
			System.out.println("¿Cuantas personas tienen personas dependientes de ellos?: " + prestamos.agruparPrestamosPorDependientes());
		} catch(Exception e) {
			System.out.println("Excepcion capturada: " + e);
		}
	}
	
	private static void testAgruparPrestamosPorPlazo(Prestamos prestamos) {
		System.out.println("\n Test método 2 BLOQUE II: ");
		try {
			System.out.println("¿Cuantas personas tienen los determinados meses de plazo para pagar el préstamo?: " + prestamos.agruparPrestamosPorPlazo());
		} catch(Exception e) {
			System.out.println("Excepcion capturada: " + e);
		}
	}
	
	private static void testObtenerMaximosElementosPorArea(Prestamos prestamos) {
		System.out.println("\n Test método 3 BLOQUE II: ");
		try {
			System.out.println("¿Quien es la persona en el area con más ingresos?: " + prestamos.obtenerMaximosElementosPorArea());
		} catch(Exception e) {
			System.out.println("Excepcion capturada: " + e);
		}
	}
	
	private static void testObtenerNMejoresElementosPorIngresoTotal(Prestamos prestamos, int n) {
		System.out.println("\n Test método 4 BLOQUE II: ");
		try {
			System.out.println("¿Quienes son las "+ n + " personas que mas ingresos totales tienen por dependientes?: " + prestamos.obtenerNMejoresElementosPorDependientes(n));
		} catch(Exception e) {
			System.out.println("Excepcion capturada: " + e);
		}
	}
	
	private static void testObtenerClaveMayorIngreso(Prestamos prestamos) {
		System.out.println("\n Test método 5 BLOQUE II: ");
		try {
			System.out.println("El mayor ingreso total de los prestamos con su respetivo año: " + prestamos.obtenerClaveMayorIngreso());
		} catch(Exception e) {
			System.out.println("Excepcion capturada: " + e);
		}
	}
	

}
