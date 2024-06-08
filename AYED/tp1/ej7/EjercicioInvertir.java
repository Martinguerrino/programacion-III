package tp1.ej7;

import java.util.ArrayList;

public class EjercicioInvertir {

    public static void invertirArrayList(ArrayList<Integer> lista)
    {
        int n;
        if(lista.size()!=1)
        {
            n= lista.remove(0);
            invertirArrayList(lista);
            lista.add(n);
        }
        else
            return;

    }
    public static void main(String[] args) {
        
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        lista.add(6);
        lista.add(7);
        invertirArrayList(lista);
        for (Integer integer : lista) {
            System.out.println(integer);
        }
    }

}
