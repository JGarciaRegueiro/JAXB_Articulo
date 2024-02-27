package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import entities.Articulo;
import entities.ArticuloDao;

public class Main {

	public static void main(String[] args) {
		JAXBContext context;
		List<Articulo> listArticulos = new ArrayList<>();
		listArticulos.add(new Articulo("articulo1","descripcion1",1,10));
		listArticulos.add(new Articulo("articulo2","descripcion2",2,20));
		listArticulos.add(new Articulo("articulo3","descripcion3",3,30));
		
		ArticuloDao adao = new ArticuloDao(listArticulos);
		
		try {
			context = JAXBContext.newInstance(ArticuloDao.class);
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			e.printStackTrace();			
			return;
		}
		
		Marshaller m;
		
		try {
			
			m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			m.marshal(adao, new File("articulos.xml"));
			System.out.println("Done");
			
		} catch (JAXBException e) {
			System.out.println("Error convertiendo el objeto a formato XML");
			e.printStackTrace();
		}
		
		Unmarshaller u;
		
		try {
			u = context.createUnmarshaller();
			
			File file = new File("articulos.xml");
			if(file.exists()) {
				Object o = u.unmarshal(file);
				ArticuloDao result = (ArticuloDao) o;
				System.out.println(">" + result.toString());
			} else {
				System.err.println("No se ha encontrado el archivo");
			}
			
		} catch(JAXBException e) {
			e.printStackTrace();
		}
	}

}
