package fp.prestamos.test;

import java.util.Set;

import fp.prestamos.FactoriaPrestamos;
import fp.prestamos.Prestamo;
import fp.prestamos.Prestamos;

public class TestFactoriaPrestamos {

	public static void main(String[] args) {
        testCreacionPrestamos();
    }

    private static void testCreacionPrestamos() {
        System.out.println("\nTest de la creacion de prestamos");
        try {
            Prestamos prestamos = FactoriaPrestamos.leerPrestamos("data/prestamos.csv");
            System.out.println("  Prestamos: " + prestamos);
        } catch(Exception e) {
            System.out.println("Excepcion capturada: " + e);
        }
    }
}

