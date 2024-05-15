package tp2.ej3;
import java.util.LinkedList;
import java.util.List;

import tp1.ej8.Queue;

import java.util.ArrayList;
import tp2.BinaryTree;
public class ContadorArbol 
{
    private BinaryTree<Integer> arbol;
    public void setArbol(BinaryTree<Integer> arbol) 
    {
        this.arbol = arbol;
    }
    public BinaryTree<Integer> getArbol() 
    {
        return arbol;
    }
    
    public List<Integer> numerosParesInOrden()
    {
        List<Integer> lista = new ArrayList<>();
        InOrden(getArbol(),lista);
        return lista;
    }
    private static void InOrden(BinaryTree<Integer> arbol,List<Integer> lista)
    {
        if(arbol.getData() != null)
        {
        if(arbol.hasLeftChild())
            InOrden(arbol.getLeftChild(),lista);

        if(arbol.getData() % 2 == 0)
            lista.add(arbol.getData());

        if(arbol.hasRightChild())
            InOrden(arbol.getRightChild(),lista);
        }
    }
    public  List<Integer> numerosParesPosOrden()
    {
        List<Integer> lista = new ArrayList<>();
        PosOrden(getArbol(),lista);
        return lista;

    }
    private static void PosOrden(BinaryTree<Integer> arbol,List<Integer> lista)
    {
        if(arbol.getData() != null)
        {
            if(arbol.hasLeftChild())
            {
                PosOrden(arbol.getLeftChild(),lista);
            }
            if(arbol.hasRightChild())
            {
                PosOrden(arbol.getRightChild(),lista);
            }
            if(arbol.getData() % 2 == 0)
                lista.add(arbol.getData());
        }
    }

    public static void main(String[] args) {
        // Crear un árbol de ejemplo
        BinaryTree<Integer> arbol = new BinaryTree<>(10);
        arbol.addLeftChild(new BinaryTree<>(5));
        arbol.addRightChild(new BinaryTree<>(14));
        arbol.getLeftChild().addLeftChild(new BinaryTree<>(3));
        arbol.getLeftChild().addRightChild(new BinaryTree<>(8));
        arbol.getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(7));
        arbol.getLeftChild().getRightChild().addRightChild(new BinaryTree<>(9));
        arbol.getRightChild().addLeftChild(new BinaryTree<>(12));
        arbol.getRightChild().addRightChild(new BinaryTree<>(18));

        // Crear una instancia de ContadorArbol y establecer el árbol
        ContadorArbol contadorArbol = new ContadorArbol();
        contadorArbol.setArbol(arbol);  
        // Evaluar el método numerosParesInOrden y mostrar los resultados
        List<Integer> lista = contadorArbol.numerosParesPosOrden();
        for (Integer integer : lista) {
            System.out.println(integer);
        }
        System.out.println("espaciooooooo");
        List<Integer> lista2 = contadorArbol.numerosParesInOrden();
        for (Integer integer : lista2) {
            System.out.println(integer);
        }
        
}
}