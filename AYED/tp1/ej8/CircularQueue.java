package tp1.ej8;


public class CircularQueue<T> extends Queue<T>{
    public CircularQueue(){
        super();
    }
    public  T shift()
    {
        T dato;
        dato = dequeue();
        enqueue(dato);
        return dato;
    }

}
