package unidad8.colecciones;

import java.util.Scanner;

public class Ejercicio4 {
	public static void main(String[] args) {
		Scanner teclado =new Scanner (System.in);
		Palabras mapa=new Palabras();
		String comando="";
		System.out.println();
		do {
			//String cmd = s.next("añadir:|lista|borrar$|borrar:|fin$"); <--Esta manera permite lista restringida o NoSuchElementException.
			System.out.print ("Introduzca comando: texto: frase a añadir | lista longitud_palabras | borrar | borrar: borrar y palabras a añadir | salir");
			comando=teclado.nextLine();
			String palabras[] =comando.split(" ");
			String resto=comando.substring(palabras[0].length()+1);
			switch (palabras[0]) {
				case "añadir:":
					mapa.addTexto(resto);					break;
				case "lista":
					System.out.println(mapa.get(Integer.parseInt(resto)));					break;
				case "borrar":
					mapa.eliminarTodo(); 					break;
				case "borrar:":
					mapa=new Palabras(resto);					break;
			}
		} while (!comando.equals("salir"));
		teclado.close();
	}
}
