package tp2;
import tp1.ej8.Queue;
public class BinaryTree<T> 
{
    private T data;
    private BinaryTree<T> leftChild;   
    private BinaryTree<T> rightChild;
    
    public BinaryTree() 
    {
        super();
    }
    public BinaryTree(T data) 
    {
        this.data = data;
    }

    public T getData() 
    {
        return data;
    }

    public void setData(T data) 
    {
        this.data = data;
    }

    public BinaryTree<T> getLeftChild() 
    {
        return leftChild;
    }
    public BinaryTree<T> getRightChild() 
    {
        return rightChild;
    }

    public void addLeftChild(BinaryTree<T> child)
    {
        this.leftChild = child;
    }

    public void addRightChild(BinaryTree<T> child) 
    {
        this.rightChild = child;
    }

    public void removeLeftChild() 
    {
        this.leftChild = null;
    }
    public void removeRightChild() 
    {
        this.rightChild = null;
    }

    public boolean isEmpty()
    {
        return (this.isLeaf() && this.getData() == null);
    }

    public boolean isLeaf() 
    {
        return (!this.hasLeftChild() && !this.hasRightChild());
    }
    public boolean hasLeftChild() 
    {
        return this.leftChild!=null;
    }

    public boolean hasRightChild() 
    {
        return this.rightChild!=null;
    }

    public int contarHojas()
    {
        int hojas =0;
        if(isLeaf())
            hojas+=1;
        if(this.hasLeftChild())
            hojas += this.getLeftChild().contarHojas();
        
        if(this.hasRightChild())
            hojas += this.getRightChild().contarHojas();
        
        return hojas;
    }

    public BinaryTree<T> espejo()
    {
        BinaryTree<T> espejo= new BinaryTree<>();
        if(this != null)
        {
            espejo.setData(this.getData());
            espejo.leftChild=this.hasRightChild() ? this.rightChild.espejo():null;
            espejo.rightChild=this.hasLeftChild() ? this.leftChild.espejo():null;
        }
        return espejo;
    }
    public void printLevelTraversal(int piso, int techo) 
    {
        int nivel =0;
        BinaryTree<T> ab = null;
        Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
        cola.enqueue(this);
        cola.enqueue(null);
        while (!cola.isEmpty()) 
        {
            ab = cola.dequeue();
            if (ab != null) 
            {
                if(piso<=nivel && techo>=nivel)
                System.out.print(ab.getData()+ " ");
                if (ab.hasLeftChild()) 
                {
                    cola.enqueue(ab.getLeftChild());
                }
                if (ab.hasRightChild()) 
                {
                    cola.enqueue(ab.getRightChild());
                }
            } 
        else if (!cola.isEmpty()) 
        {
            nivel++;
            System.out.println();
            cola.enqueue(null);
        }
        }
    }
    public void printLevelTraversal() 
    {
        BinaryTree<T> ab = null;
        Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
        cola.enqueue(this);
        cola.enqueue(null);
        while (!cola.isEmpty()) 
        {
            ab = cola.dequeue();
            if (ab != null) 
            {
                System.out.print(ab.getData()+" ");
                if (ab.hasLeftChild()) 
                {
                    cola.enqueue(ab.getLeftChild());
                }
                if (ab.hasRightChild()) 
                {
                    cola.enqueue(ab.getRightChild());
                }
            } 
            else if (!cola.isEmpty()) 
            {
                System.out.println();
                cola.enqueue(null);
            }
        }
    }



    @Override 
    public String toString() 
    {
        return this.getData().toString();
    }



}
