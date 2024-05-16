package tp2.ej5;

import tp1.ej8.Queue;
import tp2.BinaryTree;

public class ProfundidadDeArbolBinario 
{
    BinaryTree<Integer> arbol;
    public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol)
    {
        this.arbol=arbol;
    }
    public int sumaElementosProfundidad(int prof)
    {
        int nivel = 0,suma=0;
        BinaryTree<Integer> nodo = null;
        Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
        cola.enqueue(arbol);
        cola.enqueue(null);
        while(!cola.isEmpty())
        {
            nodo = cola.dequeue();
            if(nodo != null)
            {
                if(nivel == prof)
                {
                    suma+=nodo.getData();
                }
                else 
                {
                    if(nodo.hasLeftChild())
                    {
                    cola.enqueue(nodo.getLeftChild());
                    }
                    if(nodo.hasRightChild())
                    {
                    cola.enqueue(nodo.getRightChild());
                    }
                }

            }
            else if(!cola.isEmpty())
            {
                nivel++;
                cola.enqueue(null);
            }
        }
        return suma;
    }

    public static void main(String[] args) 
    {
        BinaryTree<Integer> arbol = new BinaryTree<>(10);
        arbol.addLeftChild(new BinaryTree<>(5));
        arbol.addRightChild(new BinaryTree<>(15));
        arbol.getLeftChild().addLeftChild(new BinaryTree<>(3));
        arbol.getLeftChild().addRightChild(new BinaryTree<>(8));
        arbol.getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(7));
        arbol.getLeftChild().getRightChild().addRightChild(new BinaryTree<>(9));
        arbol.getRightChild().addLeftChild(new BinaryTree<>(12));
        arbol.getRightChild().addRightChild(new BinaryTree<>(18));

        ProfundidadDeArbolBinario arbolBinario = new ProfundidadDeArbolBinario(arbol);
        int suma = arbolBinario.sumaElementosProfundidad(2);
        System.out.println(suma);
    }
}
