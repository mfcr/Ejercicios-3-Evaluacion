package unidad8.colecciones;

import java.awt.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Colecciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<Integer> pila=new LinkedList<Integer>();
		pila.offer(1);
		pila.offer(10);
		pila.offer(11);
		pila.offer(21);
		pila.offer(4);
		pila.offer(6);
		pila.offer(7);
		System.out.print(duplicar(pila));
		
	}

	public static Deque<Integer> duplicar(Deque<Integer> pila) {
		ArrayList<Integer> aux = new ArrayList<Integer>();
		while (!pila.isEmpty())
			aux.add(pila.pop());
		aux.forEach(x->{pila.push(x); pila.push(x);});
		
		return pila;
	}


}
