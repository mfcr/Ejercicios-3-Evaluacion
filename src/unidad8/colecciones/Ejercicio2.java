package unidad8.colecciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		System.out.print("Introduzca numero elementos:");
		int numElem=teclado.nextInt();
		Random rnd = new Random();
		ArrayList<Integer> listaAleatSinOrdenConRep =new ArrayList<Integer>();
		for (int i=0;i<numElem;i++) {
			listaAleatSinOrdenConRep.add(rnd.nextInt(101));
		}
		//Recorremos el array. usamos forEach y expresion lambda.
		System.out.println("\nLista con repetición: ");
		listaAleatSinOrdenConRep.forEach(n -> System.out.print(n+", "));
		//Creamos una lista sin repeticion desde la original
		LinkedHashSet<Integer> listaSinRep=new LinkedHashSet<Integer>();
		listaSinRep.addAll(listaAleatSinOrdenConRep);
		//Mostramos su contenido con un iterador.
		System.out.println("\nLista sin repetición: ");
		Iterator<Integer> it=listaSinRep.iterator();
		while (it.hasNext()) {
			System.out.print(it.next()+", ");
		}
		//Creamos una lista sin repeticion y ordenada.
		TreeSet<Integer> listaSinRepOrden=new TreeSet<>();
		listaSinRepOrden.addAll(listaAleatSinOrdenConRep);
		//Mostramos con otro tipo de blucle. For Mejorado
		System.out.println("\nLista sin repetición y ordenada: ");
		for (int i:listaSinRepOrden) {
			System.out.print(i+", ");
		}
		teclado.close();
	}

}
