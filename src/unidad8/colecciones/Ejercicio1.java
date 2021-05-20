package unidad8.colecciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		System.out.println("Introduzca numero de elementos:");
		int num=teclado.nextInt();
		System.out.println("Introduzca los elementos uno a uno + intro:");
		Collection<String> lista=new LinkedHashSet<String>(); //No admite repeticion y orden de introduccion
		//Collection<String> lista=new HashSet<String>(); //No repeticion y no garantiza orden
		//Collection<String> lista=new LinkedHashSet<String>(); //No admite repeticion y orden alfabético
		//Collection<String> lista=new ArrayList<String>(); //Admite repeticion y orden introduccion = LinkedList
		for (int i=0;i<num;i++) {
			String nombre=teclado.next();
			//if (!lista.contains(nombre)) { //Caso de ArrayList-LinkedList control manual.
			//	lista.add(nombre);
			//}
			lista.add(nombre);
		}
		System.out.println("Has introducido: "+lista.toString());
		teclado.close();
	}
}
