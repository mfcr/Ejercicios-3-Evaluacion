package unidad8.ficheros;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import Unidad7.*;
import Unidad7.Libros;
import Unidad7.OtrasPublicaciones;
import Unidad7.Publicaciones;
import Unidad7.Revistas;

public class Ejercicio8 {
	public static void main(String[] args) {
		ArrayList<Publicaciones> catalogo=new ArrayList<Publicaciones>();
		//1º en declaracio de clase Publicaciones añadir implemenmts Serializable.
		//2º crear un objeto de cualquier tipo Revista, OtrasPublicaciones,
		catalogo.add(new Libros("e32","La isla del tesoro 2ªParte",2001,new ArrayList<String>(Arrays.asList("R.S.Stevenson","su otro Primo"))));
		catalogo.add(new Revistas("R79","Vogue",2020,346,3,20)); //codigo,titulo,anyo,Nº,mes,dia.
		catalogo.add(new OtrasPublicaciones("o1","Tocata y fuga,Bach",1740,"CD"));
		catalogo.add(new OtrasPublicaciones("o2","La jungla de cristal",1740,"VHS"));
		//3º Guardar objetos.
		String nombrefichero="c:\\ddd\\fich.obj";
		Libros lib=new Libro();
		try (ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(nombrefichero))) {
			Iterator it=catalogo.iterator();
			while (it.hasNext()) {
				Publicaciones p=it.next();
				oos.writeObject(p);
				it.remove();
			}
		} catch (IOException e) {System.out.println("Error de escritura");}
		//4º Cargar
		try (ObjectInputStream ois=new ObjectInputStream(new FileInputStream(nombrefichero))) {
			Publicaciones p;
			while ((p=ois.readObject())!=null) {	catalogo.add(p);		}
		} catch (ClassNotFoundException ce) {System.out.println("Find e lectura del fichero"); } //????
		} catch (IOException e) {System.out.println("Error de lectura");}
	}
}
