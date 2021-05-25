package unidad8.ficheros;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio2 {

	public static void main(String[] args) {
		String file="D:\\FP PROGR.WEB\\Programacion\\UD8 Mecanismos de Entrada y Salida\\Ejercicios\\El Quijote UTF8.txt";
		try {
			long t1=System.nanoTime();
			//Caracter a caracter sin buffer.
			FileReader fis=new FileReader(file);
			//char leido=(char)fis.read();
			//while (leido>0) {
				//System.out.print(leido);
			//	leido=(char)fis.read();
			//}
			while (fis.read()>-1);
			System.out.println("Tiempo leyendo sin buffer: "+(System.nanoTime()-t1));
			t1=System.nanoTime();
			//Con Buffer
			BufferedReader br=new BufferedReader(new FileReader(file));
			//leido=(char)br.read();
			//while (leido>0) {
				//System.out.print(leido);
			//	leido=(char)br.read();
			//}
			while (br.read()>-1);
			System.out.println("Tiempo leyendo con buffer: "+(System.nanoTime()-t1));
			br.close();
			fis.close();
		} catch (IOException e) {
			System.out.print("Error al leer el fichero");
		}

		
	}

}
