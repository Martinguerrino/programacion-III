package tp2.ej4;
import java.util.ArrayList;
import java.util.List;
import tp2.BinaryTree;
public class RedBinariaLlena 
{
    BinaryTree<Integer> arbol;
    public RedBinariaLlena(BinaryTree<Integer> arbol)
    {
        this.arbol = arbol;
    }
    public void setArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    public BinaryTree<Integer> getArbol() {
        return arbol;
    }
    public int retardoReenvio()
    {
        int suma=0,pase;
        int max =-3;
        List<Integer> lista = new ArrayList<>();
        Preorden(getArbol(),lista,suma);
        for (Integer nodo : lista) 
        {
            pase = nodo;
            if(max<pase)
            {
                max = pase;
            }
        }
        return max;
    }

    static void Preorden(BinaryTree<Integer> nodo, List<Integer> lista,int suma)
    {
        if(!nodo.isEmpty())
        {
            suma+=nodo.getData();
            if(nodo.hasLeftChild())
            {
            Preorden(nodo.getLeftChild(),lista,suma);
            }

            if(nodo.hasRightChild())
            {
            Preorden(nodo.getRightChild(),lista,suma);
            }
            if(nodo.isLeaf())
            {
                lista.add(suma);
            }
        }
    }

    public static void main(String[] args) 
    {
        BinaryTree<Integer> arbol = new BinaryTree<>(10);
        arbol.addLeftChild(new BinaryTree<>(5));
        arbol.addRightChild(new BinaryTree<>(0));
        arbol.getLeftChild().addLeftChild(new BinaryTree<>(3));
        arbol.getLeftChild().addRightChild(new BinaryTree<>(8));
        arbol.getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(7));
        arbol.getLeftChild().getRightChild().addRightChild(new BinaryTree<>(9));
        arbol.getRightChild().addLeftChild(new BinaryTree<>(12));
        arbol.getRightChild().addRightChild(new BinaryTree<>(18));  

        // Crear una instancia de RedBinariaLlena y establecer el árbol
        RedBinariaLlena Red = new RedBinariaLlena(arbol);

        System.out.println("el mayor retardo es " + Red.retardoReenvio());
    }
}
