package fp.prestamos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import fp.common.Area;
import fp.common.Persona;
import fp.utiles.Checkers;

public class Prestamo implements Comparable<Prestamo>{
	
	private String prestamoId;
	private Persona persona;
	private Integer dependientes;
	private Boolean graduado;
	private Boolean autonomo;
	private Float ingApl;
	private Float ingCoapl;
	private Integer cantidadPrestamos;
	private Integer plazo;
	private Boolean histCred;
	private Area area;
	private LocalDate fechaPres;
	private List<Integer> listaActivos;
	
	
	//Constructor1
	
    public Prestamo(String prestamoId, Persona persona, Integer dependientes, Boolean graduado,
            Boolean autonomo, Float ingApl, Float ingCoapl, Integer cantidadPrestamos,
            Integer plazo, Boolean histCred, Area area, LocalDate fechaPres, List<Integer> listaActivos) {
    		checkIngApl(ingApl);
    		checkPlazo(plazo);
    		checkDependientes(dependientes);
    		checkIngresoCoaplicante(ingCoapl);
    		this.prestamoId = prestamoId;
    		this.persona = persona;
    		this.dependientes = dependientes;
    		this.graduado = graduado;
    		this.autonomo = autonomo;
    		this.ingApl = ingApl;
    		this.ingCoapl = ingCoapl;
    		this.cantidadPrestamos = cantidadPrestamos;
    		this.plazo = plazo;
    		this.histCred = histCred;
    		this.area = area;
    		this.fechaPres = fechaPres;
    		this.listaActivos = listaActivos;

}
	//Constructor2
	
    public Prestamo(String prestamoId, Persona persona, Integer dependientes, Boolean graduado,
            Boolean autonomo, Float ingApl, Float ingCoapl, Integer cantidadPrestamos,
            Integer plazo, Boolean histCred, Area area) {
    		checkIngApl(ingApl);
    		checkIngresoCoaplicante(ingCoapl);
    		checkPlazo(plazo);
    		checkDependientes(dependientes);
    		this.prestamoId = prestamoId;
    		this.persona = persona;
    		this.dependientes = dependientes;
    		this.graduado = graduado;
    		this.autonomo = autonomo;
    		this.ingApl = ingApl;
    		this.ingCoapl = ingCoapl;
    		this.cantidadPrestamos = cantidadPrestamos;
    		this.plazo = plazo;
    		this.histCred = histCred;
    		this.area = area;
    		fechaPres = null;
    		listaActivos = null;
    }
    //Restricciones
    
    public void checkIngApl(Float ingApl) {
    	Checkers.check("El ingreso del aplicante no puede ser menor que 0", ingApl >= 0);
    }
    
    public void checkPlazo(Integer plazo) {
    	Checkers.check("El plazo no puede ser menos de 0 meses", plazo >= 0);
    }
    
    public void checkDependientes(Integer dependientes) {
    	Checkers.check("No se pueden tener menos de 0 personas dependientes", dependientes >= 0);
    }
    
    public void checkIngresoCoaplicante(Float ingCoapl) {
    	Checkers.check("El ingreso del coaplicante no puede ser menor que 0", ingCoapl >= 0);
    }
	
	//Getters y Setters
	public String getPrestamoId() {
		return prestamoId;
	}
	public void setPrestamoId(String prestamoId) {
		this.prestamoId = prestamoId;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public Integer getDependientes() {
		return dependientes;
	}
	public void setDependientes(Integer dependientes) {
		checkDependientes(dependientes);
		this.dependientes = dependientes;
	}
	public Boolean getGraduado() {
		return graduado;
	}
	public void setGraduado(Boolean graduado) {
		this.graduado = graduado;
	}
	public Boolean getAutonomo() {
		return autonomo;
	}
	public void setAutonomo(Boolean autonomo) {
		this.autonomo = autonomo;
	}
	public Float getIngApl() {
		return ingApl;
	}
	public void setIngApl(Float ingApl) {
		checkIngApl(ingApl);
		this.ingApl = ingApl;
	}
	public Float getIngCoapl() {
		return ingCoapl;
	}
	public void setIngCoapl(Float ingCoapl) {
		checkIngresoCoaplicante(ingCoapl);
		this.ingCoapl = ingCoapl;
	}
	public Integer getCantidadPrestamos() {
		return cantidadPrestamos;
	}
	public void setCantidadPrestamos(Integer cantidadPrestamos) {
		this.cantidadPrestamos = cantidadPrestamos;
	}
	public Integer getPlazo() {
		return plazo;
	}
	public void setPlazo(Integer plazo) {
		checkPlazo(plazo);
		this.plazo = plazo;
	}
	public Boolean getHistCred() {
		return histCred;
	}
	public void setHistCred(Boolean histCred) {
		this.histCred = histCred;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public LocalDate getFechaPres() {
		return fechaPres;
	}
	
	public void setFechaPres(LocalDate fechaPres) {
		this.fechaPres = fechaPres;
	}
	
	public List<Integer> getListaActivos() {
		return listaActivos;
	}

	public void setListaActivos(List<Integer> listaActivos) {
		this.listaActivos = listaActivos;
	}

	//Propiedad derivada
    public Float getIngresoTotal() {
        return getIngApl() + getIngCoapl();
    }
	@Override
	public int hashCode() {
		return Objects.hash(fechaPres, prestamoId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prestamo other = (Prestamo) obj;
		return Objects.equals(fechaPres, other.fechaPres) && Objects.equals(prestamoId, other.prestamoId);
	}
	
    @Override
    public int compareTo(Prestamo p) {
        int resultado = this.fechaPres.compareTo(p.getFechaPres());
        if (resultado == 0) {
            resultado = this.dependientes - p.getDependientes();
        }
        return resultado;
    }
	
	
	@Override
	public String toString() {
		return "Prestamo [prestamoId=" + prestamoId + ", persona=" + persona + ", dependientes=" + dependientes
				+ ", graduado=" + graduado + ", autonomo=" + autonomo + ", ingApl=" + ingApl + ", ingCoapl=" + ingCoapl
				+ ", cantidadPrestamos=" + cantidadPrestamos + ", plazo=" + plazo + ", histCred=" + histCred + ", area="
				+ area + ", fechaPres=" + fechaPres  + ", listaActivos=" + listaActivos + "]";
	}

	
	
	
	

}
