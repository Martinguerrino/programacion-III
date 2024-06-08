package tp3.ej2;

import java.util.LinkedList;
import java.util.List;

import tp1.ej8.Queue;
import tp3.GeneralTree;

public class RecorridosAG 
{
    
    //Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
    //pasados como parámetros, recorrido en preorden.
    public List<Integer> numerosImparesMayoresQuePreoOrden(GeneralTree<Integer> arbol,int n)
    {
        List<Integer> lista = new LinkedList<>();
        preOrden(arbol, lista, n);
        return lista;
    }

    private void preOrden(GeneralTree<Integer> arbol,List<Integer> lista,int n)
    {
        if(arbol.getData()%2!=0 && arbol.getData()> n)
        {
            lista.add(arbol.getData());
        }
        List<GeneralTree<Integer>> children = arbol.getChildren();
        for (GeneralTree<Integer> child : children) 
        {
            preOrden(child,lista,n);
    }
    }

    public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> arbol,int n)
    {
        List<Integer> lista = new LinkedList<>();
        InOrden(arbol, lista, n);
        return lista;
    }
    private void InOrden(GeneralTree<Integer> arbol,List<Integer> lista,int n)
    {
        
        List<GeneralTree<Integer>> hijosDerechos=null;
        if(arbol.hasChildren())
        {
            GeneralTree<Integer> hijoIzq = arbol.getChildren().get(0);
            if(hijoIzq.getData()%2!=0 && hijoIzq.getData()>n)
            {
                lista.add(hijoIzq.getData());
            }
            hijosDerechos=arbol.getChildren().subList(1, arbol.getChildren().size());
        }
        if(arbol.getData()%2!=0 && arbol.getData()> n)
        {
            lista.add(arbol.getData());
        }
        if(hijosDerechos!= null)
        {
            for (GeneralTree<Integer> hijo : hijosDerechos) 
            {
                InOrden(hijo, lista, n);
            }
        }
        
    }


    public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> arbol,Integer n)
    {
        List<Integer> lista= new LinkedList<>();
        PostOrden(arbol, lista, n);
        return lista;

    }
    public void PostOrden(GeneralTree<Integer> arbol,List<Integer> lista,Integer n)
    {
        if(arbol.hasChildren())
        {
            List<GeneralTree<Integer>> hijos = arbol.getChildren();
            for (GeneralTree<Integer> hijo : hijos) {
                PostOrden(hijo, lista, n);
            }
        }
        if(arbol.getData()%2!=0 && arbol.getData()>n)
        {
            lista.add(arbol.getData());
        }
    }

    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> arbol,Integer n)
    {
        List<Integer> lista = new LinkedList<>();
        PorNiveles(arbol, lista, n);
        return lista;

    }

    private void PorNiveles(GeneralTree<Integer> arbol, List<Integer> lista,Integer n)
    {
        GeneralTree<Integer> aux;
        Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
        cola.enqueue(arbol);
        while(!cola.isEmpty())
        {
            aux = cola.dequeue();
            if(aux.getData()%2!=0 && aux.getData()>n)
            {
                lista.add(aux.getData());
            }
            for (GeneralTree<Integer> hijo : aux.getChildren()) 
            {
                cola.enqueue(hijo);
            }
        }
    }

    public static void main(String[] args) 
    {
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);
        List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
        children2.add(new GeneralTree<Integer>(21));
        children2.add(new GeneralTree<Integer>(22));
        children2.add(new GeneralTree<Integer>(23));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(3, children2);
        List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
        children3.add(new GeneralTree<Integer>(31));
        children3.add(new GeneralTree<Integer>(32));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(3, children3);
        List<GeneralTree<Integer>> children = new LinkedList<GeneralTree<Integer>>();
        children.add(a1);
        children.add(a2);
        children.add(a3);
        GeneralTree<Integer> a = new GeneralTree<>(0, children);


        a.PorNiveles();
        System.out.println("espacio");
        RecorridosAG recorrido = new RecorridosAG();
        List<Integer> lista =recorrido.numerosImparesMayoresQuePorNiveles(a, 2);
        for (Integer integer : lista) {
            System.out.println(integer);
        }
        
    }
}
