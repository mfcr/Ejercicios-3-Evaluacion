package unidad8.colecciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio6 {
	public static void main(String[] args) {
		Map<String,ArrayList<Integer>> agenda=new TreeMap<String,ArrayList<Integer>>() ;
		Scanner teclado=new Scanner (System.in);
		String comando="";
		do {
			try {
				System.out.print("> ");
				comando=teclado.nextLine();
				String com1="", com2="";
				if (comando.indexOf(":")>0) {
					com1=comando.substring(0,comando.indexOf(":")).trim();
					com2=comando.substring(comando.indexOf(":")+1).trim();
				} else {
					com1=comando.trim();
				}
				switch (com1) {
					case ("buscar"):
						if (agenda.get(com2)!=null) {
							System.out.print(com2+": ");
							for (Integer num:agenda.get(com2)) {
								System.out.print(num+", ");
							}
							System.out.println();
						} else {
							System.out.println("No hay entrada para: "+com2);
						}
						break;
					case ("eliminar"):
						if (agenda.get(com2)!=null) {
							agenda.remove(com2);
						} else {
							System.out.println("No hay entrada para: "+com2);
						}
						break;
					case ("contactos"):
						for (Entry<String,ArrayList<Integer>> entrada: agenda.entrySet()) { 
							System.out.print(entrada.getKey()+": ");
							for (Integer num:entrada.getValue()) {
								System.out.print(num+", ");
							}
							System.out.println();
						}
					case ("salir"):
						break;
					default: //Nuevo nombre
						if (agenda.get(com1)!=null) {
							ArrayList<Integer> listaNums=agenda.get(com1);
							listaNums.add(Integer.parseInt(com2));
						} else {
							ArrayList<Integer> listaNums=new ArrayList<>();
							listaNums.add(Integer.parseInt(com2));
							agenda.put(com1,listaNums);
						}
				}
				
			} catch (Exception e) {
				System.out.println("Error al introducir los datos, revise el formato");
			}
		} while (!comando.equals("salir"));
		teclado.close();
	}
}
