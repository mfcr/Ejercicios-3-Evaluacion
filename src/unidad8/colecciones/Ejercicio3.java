package unidad8.colecciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Ejercicio3 {
	public static void main(String[] args) {
		Scanner teclado=new Scanner (System.in);
		System.out.println("Introduzca una frase:");
		String frase=teclado.nextLine();
		String palabras[]=frase.split(" ");
		//Este no es el ejercicio. es mas parecido al 2.
		Collection<String> conRep=new ArrayList<String>();
		Collection<String> sinRep=new LinkedHashSet<String>();
		Collection<String> sinRepOrd=new TreeSet<String>();
		for (String palabra:palabras) {
			conRep.add(palabra);	sinRep.add(palabra);	sinRepOrd.add(palabra);
		}
		System.out.println("Todo lo introducido: " +conRep);
		System.out.println("Palabras sin repetir: "+sinRep);
		System.out.println("Sin repetir y ordenadas: "+sinRepOrd);
		System.out.println();
		//Este si.
		Collection <String> rep=new LinkedHashSet<>();
		Collection <String> noRep=new LinkedHashSet<>();
		for (String palabra:palabras) {
			if (!noRep.add(palabra)) //método add devuelve false si no se añadió
				rep.add(palabra);
			//Alternativa si !noRep.contains(palabra) {rep.add(p)} else {noRep.add(p)}
		}
		System.out.println("Todas las palabras: "+noRep);
		System.out.println("Palabras repetidas: "+rep);
		noRep.removeAll(rep);
		System.out.println("Palabras no repetidas: "+noRep);
		teclado.close();
	}
}
