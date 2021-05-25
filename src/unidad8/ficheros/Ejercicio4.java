package unidad8.ficheros;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {
	public static void main(String[] args) {
		String fichero="";
		if (args.length==0) {
			Scanner teclado=new Scanner(System.in);
			System.out.println("Introduzca el nobre de un fichero, ruta incluida:");	System.out.print("> ");
			fichero=teclado.nextLine();
			teclado.close();
		} else {	fichero=args[0];	}
		//De este modo no hace falta br.close().
		try (BufferedReader br=new BufferedReader(new FileReader(fichero))) {
			int caracteres=0;			int palabras=0;			int lineas=0; 		String linea="";
			while ((linea=br.readLine())!=null) {
				lineas++;
				for (String p:linea.split("\\P{L}+")) {		palabras++;		caracteres+=p.length();	}
			}
			//Guardamos fichero en ruta idem 
			String nuevoFichero=fichero.substring(0,fichero.lastIndexOf("\\"))+"\\guardadoBinario.bin";
			try (DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(new FileOutputStream(nuevoFichero,true)))) {
				dos.writeUTF(nuevoFichero); dos.writeInt(lineas); dos.writeInt(palabras); dos.writeInt(caracteres);
			} catch (IOException e) { System.out.println("Error al guardar el fichero con los resultados"); } 

			//try (BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(nuevoFichero,true))) {
			//	bos.write(("El fichero "+nuevoFichero+" tiene "+lineas+" líneas, "+palabras+" palabras y "+caracteres+" caracteres.").getBytes());
			//	System.out.println("Guardado resultados");
			//} catch (IOException e) { System.out.println("Error al guardar el fichero con los resultados"); } 
		} catch (IOException e) {
			System.out.println("Error al leer el fichero o este no existe");
		}
	}
}
