package entities;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="inventario")
public class ArticuloDao {

	private List<Articulo> listaArticulos;
	
	public ArticuloDao() {
		
	}
	
	public ArticuloDao(List<Articulo> listaArticulos) {
		this.listaArticulos = listaArticulos;
	}
	
	@XmlElementWrapper(name = "articulos")
	@XmlElement(name = "articulo")
	public List<Articulo> getArticulos() {
	    return listaArticulos;
	}
	
	public void setArticulos(List<Articulo> articulos) {
	    this.listaArticulos = articulos;
	}

	@Override
	public String toString() {
		return "ArticuloDao [listaArticulos=" + listaArticulos + "]";
	}

	
	
}
