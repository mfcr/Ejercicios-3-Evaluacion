package unidad8.colecciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio7 {
	public static void main(String[] args) {
		Scanner teclado =new Scanner(System.in);
		Collection <Integer> numeros1=new ArrayList<Integer>();
		Collection <Integer> numeros2=new ArrayList<Integer>();
		System.out.print("Introduzca 2 numeros para el tamaño ");
		int num1=teclado.nextInt();
		int num2=teclado.nextInt();
//En realidad de este modo no haria falta meter los set en 2 lineas.
// posible error si usuario mete mas/menos numeros en cada linea
// se colocaria erróneamente
//otra opcion: String numeros[]=teclado.nextline().split(" ");
//control num introducidos y en bucle for numeros1.add(Integer.parseInt(numeros[i])). 
		for (int i=0;i<num1;i++) {
			numeros1.add(teclado.nextInt());
		}
		for (int i=0;i<num2;i++) { 
			numeros2.add(teclado.nextInt());
		}
		//Queremos la union de ambos set --> los repetidos.
		numeros1.retainAll(numeros2);  //Elimina de numeros1 todos los elementos que no esten en numeros2
		System.out.println(numeros1);
		numeros1.forEach(x->System.out.print(x+" "));
		teclado.close();
	}

}
