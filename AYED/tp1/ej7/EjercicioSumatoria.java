package tp1.ej7;

import java.util.LinkedList;

public class EjercicioSumatoria {
    
    public static int sumarLinkedList(LinkedList<Integer> lista)
    {   int suma,elemento;
        if(lista.size()==1)
        {
            return lista.get(0);
        }
        else
        {   elemento=lista.pop();
            suma =elemento;
            suma+=sumarLinkedList(lista);  
            lista.add(elemento);
            
        }
        return suma;
    }
    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(2);
        lista.add(2);
        lista.add(2);
        lista.add(2);
        lista.add(2);
        lista.add(2);
        lista.add(2);
        for (Integer integer : lista) {
            System.out.println(integer);
        }
        
        int n = sumarLinkedList(lista);
        System.out.println(n);
        for (Integer integer : lista) {
            System.out.println(integer);
        }
    }
}
