package tp1.ej8;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Queue<T> extends Sequence<T> {
    private List<T> data;
    public Queue() 
    {
        data = new ArrayList<>();
    }

    public void enqueue(T dato)
    {
        data.add(dato);
    }
    
    public T dequeue()
    {
        T dato=null;
        if(!isEmpty(data))
        {   
            Iterator<T> iterador = data.iterator();
            while(iterador.hasNext())
                dato=iterador.next();
            return dato;
        }
        else
        {
            throw new ArithmeticException("La data esta vacia");
        }

    }
    public T head()
    {
        return data.get(0);
    }

    public boolean isEmpty()
    {
        return super.isEmpty(data);
    }

    public int size()
    {
        return super.size(data);
    }

    public String toString()
    {
        String datos = "";
        for (T t : data) {
            datos+=t+" ";
        }
        return datos;
    }


}
