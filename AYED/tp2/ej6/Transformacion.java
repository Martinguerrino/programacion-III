package tp2.ej6;
//hago un recorrido posorden

import tp2.BinaryTree;

public class Transformacion 
{
    BinaryTree<Integer> arbol;
    public Transformacion(BinaryTree<Integer> arbol)
    {
        this.arbol = arbol;
    }
    public BinaryTree<Integer> suma()
    {
        BinaryTree<Integer> nuevo = new BinaryTree<Integer>();
        postOrden(this.arbol,nuevo);
        return nuevo;
    }

    private int postOrden(BinaryTree<Integer> viejo,BinaryTree<Integer> nuevo)
    {
        if(viejo.isLeaf())
        {
            nuevo.setData(0);
            return viejo.getData();
        }
        else
        {
            int dato=0;
            if(viejo.hasLeftChild())
            {
                BinaryTree<Integer> nodo = new BinaryTree<Integer>();
                nuevo.addLeftChild(nodo);
                dato += postOrden(viejo.getLeftChild(), nuevo.getLeftChild());
                
            }
            if(viejo.hasRightChild())
            {
                BinaryTree<Integer> nodo = new BinaryTree<Integer>();
                nuevo.addRightChild(nodo);
                dato += postOrden(viejo.getRightChild(), nuevo.getRightChild());
            }
            nuevo.setData(dato);
            return dato + viejo.getData();
        }
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

        Transformacion trans = new Transformacion(arbol);
        BinaryTree<Integer> nuevo = trans.suma();
        nuevo.printLevelTraversal();
    }
}
