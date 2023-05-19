package fp.prestamos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.common.Area;


public class Prestamos {

	private Set<Prestamo> prestamos;
	
	//C1
	
	public Prestamos() {
		this.prestamos = new HashSet<>();
	}
	
	//C2
	
	public Prestamos(Set<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}
	
	//Operaciones get, set, add y remove:
	
    public Set<Prestamo> getPrestamos() {
        return prestamos;
    }
    
    public void setPrestamos(Set<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
	
	public void añadirPrestamo(Prestamo prestamo) {
		this.prestamos.add(prestamo);
	}
	
    public void quitarPrestamo(Prestamo prestamo) {
        this.prestamos.remove(prestamo);
    }
    
    public int obtenerCantidadPrestamos() {
        return prestamos.size();
    }    
    
    // Tratamientos secuenciales
    public boolean existePrestamoParaTodoGraduado(Boolean graduado) {
        for (Prestamo p : prestamos) {
            if (p.getGraduado().equals(graduado)) {
                return true;
            }
        }
        return false;
    }

    public int contarPrestamosConPlazoMayorOIgualQue(int plazo) {
        int contador = 0;
        for (Prestamo p : prestamos) {
            if (p.getPlazo() >= plazo) {
                contador++;
            }
        }
        return contador;
    }

    public double calcularMediaCantidadPrestamosParaAutonomos(Boolean autonomo) {
        double sum = 0;
        int contador = 0;
        for (Prestamo p : prestamos) {
            if (p.getAutonomo().equals(autonomo)) {
                sum += p.getCantidadPrestamos();
                contador++;
            }
        }
        return (contador == 0) ? 0 : sum / contador;
    }

    public List<Prestamo> seleccionarPrestamosConIngresosSuperioresA(float ingresos) {
        List<Prestamo> seleccion = new ArrayList<>();
        for (Prestamo p : prestamos) {
            if (p.getIngApl() > ingresos || p.getIngCoapl() > ingresos) {
                seleccion.add(p);
            }
        }
        return seleccion;
    }

    public Map<Area, Set<Prestamo>> agruparPrestamosPorArea() {
        Map<Area, Set<Prestamo>> mapa = new HashMap<>();
        for (Prestamo p : prestamos) {
            if (!mapa.containsKey(p.getArea())) {
                mapa.put(p.getArea(), new HashSet<>());
            }
            mapa.get(p.getArea()).add(p);
        }
        return mapa;
    }

    public Map<Boolean, Integer> acumularPrestamosPorGenero(String genero) {
        Map<Boolean, Integer> mapa = new HashMap<>();
        for (Prestamo p : prestamos) {
            if (p.getPersona().getGenero().equals(genero)) {
                boolean aut = p.getAutonomo();
                mapa.put(aut, mapa.getOrDefault(aut, 0) + 1);
            }
        }
        return mapa;
    }
    
	// HashCode:

	@Override
	public int hashCode() {
		return Objects.hash(prestamos);
	}
	
	//Criterio de igualdad:

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prestamos other = (Prestamos) obj;
		return Objects.equals(prestamos, other.prestamos);
	}
	
	//Representacion como cadena:

	@Override
	public String toString() {
		return "Prestamos [prestamos=" + prestamos + "]";
	}
	
}
