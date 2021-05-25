package unidad8.ficheros;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Ejercicio6 {
	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		System.out.print("Para leer el quijote escoja 1 para version UTF-8 o 2 para Unicode: --> ");
		String dir="D:\\FP PROGR.WEB\\Programacion\\UD8 Mecanismos de Entrada y Salida\\Ejercicios\\";
		String file="El Quijote UTF8.txt";
		Charset code=StandardCharsets.UTF_8;
		switch (teclado.nextLine()) {
			case "1": //valores x defecto
				break;
			case "2":
				code= StandardCharsets.ISO_8859_1;;
				file="El Quijote Windows-1252.txt";
				break;
			default: System.out.println("\n Error al introducir la opcion"); System.exit(0);
		} //Si se quiere evitar el exit a continuacion if(!file.equals("")) {}
		try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(dir+file),code))) {
			String linea="";
			while ((linea=br.readLine())!=null) {System.out.println(linea);}
		} catch (IOException e) { System.out.println("Error al leer el fichero"); }
	}
}
