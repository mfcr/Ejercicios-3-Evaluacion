package unidad8.colecciones;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Palabras {
	//Estructura que soporta las listas con la logitud como clave
	private TreeMap<Integer,Set<String>> listasPalabras;
	public Palabras() { //Constructor vacio
		listasPalabras =new TreeMap<Integer,Set<String>>();
	}
	public Palabras(String texto) { //Constructor con texto a añadir
		this();
		addTexto(texto);
	}
	public void addTexto(String Texto) {
		String palabras[]=Texto.split(" ");
		for (String palabra:palabras) {
			add(palabra);//Añadimos una a una las palabras
		}
		//Scanner s = new Scanner(texto); //<--Otra opcion
		//s.useDelimiter("\\P{L}+");
		//while (s.hasNext())
		//	add(s.next());
		//s.close();
	}
	public void add(String palabra) {
		int longitud=palabra.length();
		Set<String> estaLista=listasPalabras.get(longitud); //Recogemos el valor (set) de esa longotud.
		if (estaLista==null) { //Primera palabra de esta longitud.
			estaLista=new TreeSet<String>();
			estaLista.add(palabra);
			listasPalabras.put(longitud,estaLista); //Añadimos la entrada
		} else { //Ya hay palabras.
			estaLista.add(palabra);
		}
	}
	public Set<String> get(int longitud) {
		//return Collections.unmodifiableSet(listasPalabras.get(longitud));
		return listasPalabras.get(longitud);
	}
	public void eliminarTodo() {
		listasPalabras.clear();
	}
}
