package tp1.ej7;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class TestLinkedList {

    public static void main(String[] args) 
    {   
        int i;
        Integer n;
        LinkedList<Integer> lista = new LinkedList<>();
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        
        for(i=0;i<=2;i++)
        {
            System.out.println("ingrese numero: ");
            n=input.nextInt();
            lista.add(n);
        }
        System.out.println("Contenido de la lista enlazada: " + lista);
        ListIterator<Integer> iterador =lista.listIterator();
        while(iterador.hasNext())
        {
            Integer num = iterador.next();
            System.out.println(num);
        }
        input.close();
    }
}
