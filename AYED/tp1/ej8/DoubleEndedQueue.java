package tp1.ej8;
public class DoubleEndedQueue<T> extends Queue<T> {
    public DoubleEndedQueue(){
        super();
    }
    public void enqueueFirst(T dato)
    {
        T n;
        if(!super.isEmpty())
        {
            n= dequeue();
            enqueue(dato);
            enqueue(n);
        }
        else
        {
            enqueue(dato);
        }

    }

}
