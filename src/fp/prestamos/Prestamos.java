package fp.prestamos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collector;
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
	
	//C3 (A partir de Stream)
	
    public Prestamos(Stream<Prestamo> prestamoStream) {
        this.prestamos = prestamoStream.collect(Collectors.toSet());
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

    public Map<Boolean, Integer> acumularPrestamosPorGenero(Area area) {
        Map<Boolean, Integer> mapa = new HashMap<>();
        for (Prestamo p : prestamos) {
            if (p.getArea().equals(area)) {
                boolean aut = p.getAutonomo();
                mapa.put(aut, mapa.getOrDefault(aut, 0) + 1);
            }
        }
        return mapa;
    }
    
    //Tratamientos Secuenciales con Streams
    
    	//BLOQUE 1
    
    public boolean streamExistePrestamoParaTodoGraduado(Boolean graduado) {
    	return prestamos.stream()
    			.anyMatch(p->p.getGraduado().equals(graduado));
    }
    
    public int streamContarPrestamosConPlazoMayorOIgualQue(int plazo) {
    	Long res = prestamos.stream().filter(p->p.getPlazo() >= plazo).count();
    	return res.intValue();
    }
    
    public List<Prestamo> streamSeleccionarPrestamosConIngresosSuperioresA(float ingresos) {
    	return prestamos.stream().filter(p -> p.getIngresoTotal() > ingresos)
    			.collect(Collectors.toList());
    }
    
    public Prestamo streamMaximoIngresoTotalPorArea(Area area) {
    	return prestamos.stream().filter(p -> p.getArea().equals(area))
    			.max(Comparator.comparing(Prestamo::getIngresoTotal)).get();	
    }
    
    public List<Prestamo> streamSeleccionarPrestamosOrdenadosFecha(LocalDate fecha) {
    	return prestamos.stream().filter(p -> p.getFechaPres().isAfter(fecha))
    			.sorted(Comparator.comparingInt(Prestamo::getPlazo))
    			.collect(Collectors.toList());
    }
    
    	//BLOQUE 2
    
    public Map<Integer, Long> agruparPrestamosPorDependientes() {
        return prestamos.stream()
                .collect(Collectors.groupingBy(Prestamo::getDependientes, Collectors.counting()));
    }
    
    public Map<Integer, Integer> agruparPrestamosPorPlazo() {
        return prestamos.stream()
                .collect(Collectors.groupingBy(Prestamo::getPlazo,
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
    }
    
    public Map<Area, Prestamo> obtenerMaximosElementosPorArea() {
        Map<Area, Prestamo> res = prestamos.stream()
                .collect(Collectors.groupingBy(Prestamo::getArea,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Prestamo::getArea)),
                                optPrestamo -> optPrestamo.orElse(null))));

        return res;
    }

    public SortedMap<Integer, List<Prestamo>> obtenerNMejoresElementosPorDependientes(int n) {
        Comparator<Prestamo> comparador = Comparator.comparing(Prestamo::getIngresoTotal);

        Map<Integer, List<Prestamo>> agrupados = prestamos.stream()
                .collect(Collectors.groupingBy(Prestamo::getDependientes));

        SortedMap<Integer, List<Prestamo>> sortedMap = new TreeMap<>(agrupados);
        sortedMap.replaceAll((clave, lista) -> lista.stream()
                .sorted(comparador)
                .limit(n)
                .collect(Collectors.toList()));

        return sortedMap;
    }
    
    public Map<Integer, Float> obtenerClaveMayorIngreso() {
        Optional<Prestamo> prestamoOptional = prestamos.stream()
                .max(Comparator.comparing(Prestamo::getIngresoTotal));
        
        if (prestamoOptional.isPresent()) {
            Prestamo prestamo = prestamoOptional.get();
            Map<Integer, Float> resultado = new HashMap<>();
            resultado.put(prestamo.getFechaPres().getYear(), prestamo.getIngresoTotal());
            return resultado;
        } else {
            throw new IllegalStateException("La lista de préstamos está vacía");
        }
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
