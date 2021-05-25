package unidad8.ficheros;
import java.io.File;
import java.util.Scanner;


public class Ejercicio1 {

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
		File file=new File(fichero);
		if (file.exists()) {
			System.out.print("El fichero "+file.getName()+" existe ");
			if (file.isFile()) {
				System.out.println(" y es un fichero.");
				System.out.println("El fichero contiene "+file.length()+" bytes.");
			} else {
				System.out.println(" y es un directorio.");
				System.out.println("El directorio contiene "+file.list().length+" elementos.");
			}
			System.out.println("Permisos--> lectura: "+file.canRead()+", escritura: "+file.canWrite()+", ejecutar: "+file.canExecute());
			
		} else {
			System.out.println("El fichero introducido no existe.");
		}


	}

}
