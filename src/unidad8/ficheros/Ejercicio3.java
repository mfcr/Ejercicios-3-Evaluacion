package unidad8.ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		String fichero="";
		if (args.length==0) {
			Scanner teclado=new Scanner(System.in);
			System.out.println("Introduzca el nobre de un fichero, ruta incluida:");
			System.out.print("> ");
			fichero=teclado.nextLine();
			teclado.close();
		} else {
			fichero=args[0];
		}
		FileReader fr=null;
		BufferedReader br=null;
		try {
			int caracteres=0;
			int palabras=0;
			int lineas=0;
			fr=new FileReader(fichero);
			br=new BufferedReader(fr); //br=new BufferedReader(new FileReader(fichero));
			String linea;
			while ((linea=br.readLine())!=null) {
				lineas++;
				String ArrPalabras[]=linea.split(" "); //OJO ("\\P{L}+")
				//for (String p:linea.split(" ")) { <--eliminamos String ArrPalabras[]=lineas.split(" ");
				for (String p:ArrPalabras) {
					palabras++;
					caracteres+=p.length();
				}
			}
			System.out.println("El fichero tiene "+lineas+" líneas, "+palabras+" palabras y "+caracteres+" caracteres.");
		} catch (IOException e) {
			System.out.println("Error al leer el fichero o este no existe");
		} finally { //Cierre en finally para asegurar que se cierra pase lo que pase,
			try {
				if (fr!=null) {fr.close();}
				if (br!=null) {br.close();}
			} catch (Exception e) {} //fr.close() obliga a bloque try catch
		}

	}

}
