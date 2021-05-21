package unidad8.colecciones;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio8 {
	public static void main(String[] args) {
		Scanner teclado=new Scanner (System.in);
		Map<String,ArrayList<String>> juego=new LinkedHashMap<String,ArrayList<String>>();
		String linea="";
		do {
			//LinkedHashMap guarda orden de inserción.
			linea=teclado.nextLine();
			//Asumimos que si se vuelve a repetir usuario, añadimos elementos en lugar de eliminar los viejos
			String user=linea.split(":")[0].trim();
			String cartas[];
			//Habria que mejorarlo cambiando el bucle.
			if (!user.equals("fin")) {
				cartas=linea.split(":")[1].toUpperCase().trim().split(" ");
				ArrayList<String> cartasUser=new ArrayList<String> ();
				if (juego.containsKey(user)) {
					cartasUser.addAll(juego.get(user));
				}
				for (String c:cartas) {
					cartasUser.add(c);
				}
				juego.put(user,cartasUser); //put machaca los valores anteriores.
			}
		} while(!linea.equals("fin"));
		juego.forEach((x,y) -> System.out.println(x+": "+calculaValor(y)));
	}
	public static int calculaValor(ArrayList<String> valores) {
		Map<String,Integer> rangos =new TreeMap<String,Integer>();
		rangos.put("2",2);	rangos.put("3",3);	rangos.put("4",4);	rangos.put("5",5);	rangos.put("6",6);	rangos.put("7",7);	
		rangos.put("8",8);	rangos.put("9",9);	rangos.put("10",10);	rangos.put("J",11);	rangos.put("Q",12); rangos.put("K",13);	rangos.put("A",14);		
		Map<String,Integer> palos =new TreeMap<String,Integer>();
		palos.put("S",4);	palos.put("H",3);	palos.put("D",2);	palos.put("C",1);
		int resultado=0;
		for (String valor:valores) {
			String palo=valor.substring(valor.length()-1);
			String carta=valor.substring(0,valor.length()-1);
			resultado+=rangos.get(carta)*palos.get(palo);
		}
		return resultado;
	}
}

