package entities;


import javax.xml.bind.annotation.XmlType;


@XmlType(propOrder = {
		"id",
	    "nombre",
	    "descripcion",
	    "stock",
	})
public class Articulo{

	private int id;
	private String nombre;
	private String descripcion;
	private int stock;
	private double precio;
	
	public Articulo() {
		
	}
	
	public Articulo( String nombre, String descripcion, int stock, double precio) {
		this.id = id++;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precio = precio;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Articulo))
			return false;
		Articulo other = (Articulo) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Articulo [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", stock=" + stock
				+ ", precio=" + precio + "]";
	}
	
}
