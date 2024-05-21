package tp3.ej4;

import java.util.LinkedList;
import java.util.List;

import tp1.ej8.Queue;
import tp3.GeneralTree;

public class AnalizadorArbol 
{
    public int devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol)
    {
        GeneralTree<AreaEmpresa> aux;
		int cantmax=-1;
        int cantniv=0;
        int cant=0;
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		while(!cola.isEmpty())
		{
			aux = cola.dequeue();
			if(aux!= null)
			{
            
                System.out.println(aux.getData().tardanza);
                cantniv+=aux.getData().tardanza;
                cant++;
                for (GeneralTree<AreaEmpresa> hijo : aux.getChildren()) 
                {
                    cola.enqueue(hijo);
                }
			}
			else
			{
				
                System.out.println("cantidad total del nivel "+cantniv);
                System.out.println("cantidad de nodos del nivel "+ cant);
                cantniv/=cant;
                if(cantmax<cantniv)
                {
                    cantmax=cantniv;
                }
                if(!cola.isEmpty())
                {
                cola.enqueue(null);
                cantniv=0;
                cant=0;
                }
			}
		}
        return cantmax;
    }

    public static void main(String[] args) 
    {
        GeneralTree<AreaEmpresa> a1 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("1", 1));
        List<GeneralTree<AreaEmpresa>> children2 = new LinkedList<GeneralTree<AreaEmpresa>>();
        children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("21", 21)));
        children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("22", 22)));
        children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("23", 23)));
        GeneralTree<AreaEmpresa> a2 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("2", 2), children2);
        List<GeneralTree<AreaEmpresa>> children3 = new LinkedList<GeneralTree<AreaEmpresa>>();
        children3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("31", 31)));
        children3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("32", 32)));
        GeneralTree<AreaEmpresa> a3 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("3", 3), children3);
        List<GeneralTree<AreaEmpresa>> childen = new LinkedList<GeneralTree<AreaEmpresa>>();
        childen.add(a1);childen.add(a2);childen.add(a3);
        GeneralTree<AreaEmpresa> a = new GeneralTree<AreaEmpresa>(new AreaEmpresa("0", 0), childen);
        AnalizadorArbol analiz=new AnalizadorArbol();
        System.out.println(analiz.devolverMaximoPromedio(a));
    }
}
