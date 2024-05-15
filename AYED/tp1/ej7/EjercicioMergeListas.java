package tp1.ej7;
import java.util.ArrayList;
import java.util.Iterator;
public class EjercicioMergeListas {

    public static ArrayList<Integer> mergeListas(ArrayList<Integer> lista1,ArrayList<Integer> lista2)
    {
        Integer elemento2;
        ArrayList<Integer> listaM= new ArrayList<>();
        Iterator<Integer> iterador2 = lista2.iterator(); 
        elemento2 = iterador2.hasNext()?iterador2.next():null;  
        for (Integer elemento : lista1) 
        {
            while(elemento2!=null && elemento>elemento2)
            {
                listaM.add(elemento2);
                elemento2 = iterador2.hasNext()?iterador2.next():null;
            }
            listaM.add(elemento);
        }
        if(elemento2!=null)
            listaM.add(elemento2);
        iterador2.forEachRemaining(numero -> listaM.add(numero));
        return listaM;
    }
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        ArrayList<Integer> lista1 = new ArrayList<>();
        ArrayList<Integer> listaM = new ArrayList<>();
        lista.add(1);
        lista.add(3);
        lista.add(4);
        lista.add(9);
        lista.add(15);
        lista.add(20);
        lista.add(22);

        lista1.add(2);
        lista1.add(3);
        lista1.add(3);
        lista1.add(5);
        lista1.add(6);
        lista1.add(7);
        lista1.add(23);
        lista1.add(27);
        lista1.add(30);
        lista1.add(33);

        listaM=mergeListas(lista,lista1);
        System.out.println("tamaño de la lista1:"+lista.size()+"tamaño de la lista2:"+lista1.size()+"tamaño de la listaM:"+listaM.size());
        for (Integer integer : listaM) {
            System.out.println(integer);
        }
    }
}
