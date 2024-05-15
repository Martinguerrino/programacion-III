package tp1.ej8;


import java.util.List;

public abstract class Sequence<T> {

    public int size(List<T> lista)
    {
        return lista.size();
    }
    public boolean isEmpty(List<T> lista)
    {
        return lista.isEmpty();
    }
}
