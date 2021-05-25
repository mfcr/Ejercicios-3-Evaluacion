package unidad8.ficheros;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio5 {
	public static void main(String[] args) {
		String fichero="D:\\FP PROGR.WEB\\Programacion\\UD8 Mecanismos de Entrada y Salida\\Ejercicios\\guardadoBinario.bin";
		String ficherosalida="D:\\FP PROGR.WEB\\Programacion\\UD8 Mecanismos de Entrada y Salida\\Ejercicios\\guardadoTexto.txt";
		String texto="";
		try (DataInputStream dis=new DataInputStream(new BufferedInputStream(new FileInputStream(fichero)))) {
			while (true) {
				texto=dis.readUTF()+", "+dis.readInt()+", "+dis.readInt()+", "+dis.readInt()+"\n";
			}
		} catch (EOFException e) { //Cuando llega al fin del fichero readUTF o readINT lanzan error EOF. 
			try (BufferedWriter bw=new BufferedWriter(new FileWriter(ficherosalida,true))) { //de este modo se rellena todo el fichero a la vez y no se sobreescribe. Si se quisiera ir línea a línea
				//se abriría el escritor antes del while, depsues de forrmar la línea se haria el write y aqui cierre de recursos.
				bw.write(texto);
			} catch (IOException ex) { System.out.println("Error al guardar txt. ");			}
		} catch (IOException e) {
			System.out.println("error eleyendo el fichero binario");
		}
	}
}
