package fp.prestamos;

import java.time.LocalDate;
import java.util.Objects;

import fp.common.Area;
import fp.common.Genero;

public class Prestamo implements Comparable<Prestamo>{
	
	private String prestamoId;
	private Genero genero;
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
	private Boolean presAcept;
	//Constructor1
	
    public Prestamo(String prestamoId, Genero genero, Integer dependientes, Boolean graduado,
            Boolean autonomo, Float ingApl, Float ingCoapl, Integer cantidadPrestamos,
            Integer plazo, Boolean histCred, Area area, LocalDate fechaPres, Boolean presAcept) {
    		checkFechaPres(fechaPres);
    		checkIngApl(ingApl);
    		this.prestamoId = prestamoId;
    		this.genero = genero;
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
    		this.presAcept = presAcept;

}
	//Constructor2
	
    public Prestamo(String prestamoId, Genero genero, Integer dependientes, Boolean graduado,
            Boolean autonomo, Float ingApl, Float ingCoapl, Integer cantidadPrestamos,
            Integer plazo, Boolean histCred, Area area, Boolean presAcept) {
    		this(prestamoId, genero, dependientes, graduado, autonomo, ingApl, ingCoapl, cantidadPrestamos,
    			plazo, histCred, area, null, presAcept);
    }
    	//Restricciones
    
    private void checkFechaPres(LocalDate fechaPres) {
        if (fechaPres.getYear() > 2010) {
            throw new IllegalArgumentException("La fecha de préstamo no puede ser posterior a 2010.");
        }
    }
    
    public void checkIngApl(Float ingApl) {
        if (ingApl < 0) {
            throw new IllegalArgumentException("El ingreso aplicante no puede ser menor que 0.");
        }
      }

	
	//Getters y Setters
	public String getPrestamoId() {
		return prestamoId;
	}
	public void setPrestamoId(String prestamoId) {
		this.prestamoId = prestamoId;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public Integer getDependientes() {
		return dependientes;
	}
	public void setDependientes(Integer dependientes) {
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
		checkIngApl(ingApl);
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
		checkFechaPres(fechaPres);
		return fechaPres;
	}
	public void setFechaPres(LocalDate fechaPres) {
		checkFechaPres(fechaPres);
		this.fechaPres = fechaPres;
	}
	public Boolean getPresAcept() {
		return presAcept;
	}
	public void setPresAcept(Boolean presAcept) {
		this.presAcept = presAcept;
	}
    public Float getIngresoTotal() {
        return ingApl + ingCoapl;
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
		return "Prestamo [prestamoId=" + prestamoId + ", genero=" + genero + ", dependientes=" + dependientes
				+ ", graduado=" + graduado + ", autonomo=" + autonomo + ", ingApl=" + ingApl + ", ingCoapl=" + ingCoapl
				+ ", cantidadPrestamos=" + cantidadPrestamos + ", plazo=" + plazo + ", histCred=" + histCred + ", area="
				+ area + ", fechaPres=" + fechaPres + ", presAcept=" + presAcept + "]";
	}

	
	
	
	

}
