package tp1.ej7;

import java.util.LinkedList;
import java.util.List;

public class EjercicioSucesion {    

    public static List<Integer> calcularSucesion (Integer n)
    {
        LinkedList<Integer> lista = new LinkedList<>();
        boolean par = n%2==0;
        lista.add(n);
        if(n==1)
        {
            return lista;
        }
        if(par)
        {
                n=n/2;
        }
        else
        {
            n=3*n + 1;
        }
        lista.addAll(calcularSucesion(n));
        return lista;
    }
    public static void main(String[] args) {
        Integer n=6;
        List<Integer> lista = new LinkedList<>();
        lista = calcularSucesion(n);
        System.out.println("numeros");
        for (Integer integer : lista) {
            System.out.println(integer);
        }
    }

}
