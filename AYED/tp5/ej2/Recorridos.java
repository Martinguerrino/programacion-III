package tp5.ej2;

import java.util.LinkedList;
import java.util.List;

import tp1.ej8.Queue;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.listaAdy.AdjListGraph;

public class Recorridos<T>
{
    public List<T> dfs(Graph<T> grafo)
    {
        System.out.println("pase por aca");
        boolean marca[] = new boolean[grafo.getSize()];
        List<T> lista = new LinkedList<>();
        for(int i=0;i<grafo.getSize();i++)
        {
            if(!marca[i])
            {
                System.out.println("largo con: "+ grafo.getVertex(i).getData());
                System.out.println("pase por aca");
                dfs(i,grafo,marca,lista);
            }
        }
        return lista;
    }

    private void dfs(int i, Graph<T> grafo , boolean[] marca,List<T> lista)
    {
        marca[i]=true;
        Vertex<T> v = grafo.getVertex(i);
        System.out.println("pase por aca y el dato es "+ v.getData());
        lista.add(v.getData());
        List<Edge<T>> adyacentes = grafo.getEdges(v);
        for (Edge<T> edge : adyacentes) 
        {
            int j = edge.getTarget().getPosition();
            if(!marca[j])
                dfs(j, grafo, marca,lista);
        }
    }

    public List<T> bfs(Graph<T> grafo)
    {
        boolean[] marca = new boolean[grafo.getSize()];
        List<T> lista = new LinkedList<>();
        for(int i=0;i<grafo.getSize();i++)
        {
            if(!marca[i])
            {
                bfs(i,grafo,marca,lista);
            }
        }
        return lista;
    }

    private void bfs(int i, Graph<T> grafo , boolean[] marca, List<T> lista)
    {
        Queue<Vertex<T>> cola = new Queue<>();
        cola.enqueue(grafo.getVertex(i));
        marca[i]=true;
        
        while(!cola.isEmpty())
        {
            Vertex<T> v = cola.dequeue();
            lista.add(v.getData());
            List<Edge<T>> adyacentes = grafo.getEdges(v);
            for (Edge<T> edge : adyacentes) 
            {
                int j = edge.getTarget().getPosition();
                if(!marca[j])
                {
                    
                    marca[j]= true;
                    cola.enqueue(edge.getTarget());
                }
            }

        }
    }

    public static void main(String[] args) 
    {
        /*
        Graph<String> ciudades = new AdjListGraph<>();
        Vertex<String> v1 = ciudades.createVertex("Buenos Aires");
        Vertex<String> v2 = ciudades.createVertex("Santiago");
        Vertex<String> v3 = ciudades.createVertex("Asunción");
        Vertex<String> v4 = ciudades.createVertex("Caracas");
        Vertex<String> v5 = ciudades.createVertex("Madrid");
        ciudades.connect(v1, v2, 3); //"Buenos Aires", "Santiago"
        ciudades.connect(v1, v3, 6); //"Buenos Aires", "Asunción"
        ciudades.connect(v2, v5, 4); //"Santiago", "Madrid"
        ciudades.connect(v5,v2);
        ciudades.connect(v4,v5);*/
        
        Graph<String> ciudades = new AdjListGraph<>();
        Vertex<String> v1 = ciudades.createVertex("New York");
        Vertex<String> v2 = ciudades.createVertex("Los Angeles");
        Vertex<String> v3 = ciudades.createVertex("Chicago");
        Vertex<String> v4 = ciudades.createVertex("Houston");
        Vertex<String> v5 = ciudades.createVertex("Phoenix");
        Vertex<String> v6 = ciudades.createVertex("Philadelphia");
        Vertex<String> v7 = ciudades.createVertex("San Antonio");
        ciudades.connect(v1, v2, 5); //"New York", "Los Angeles"
        ciudades.connect(v1, v3, 2); //"New York", "Chicago"
        ciudades.connect(v2, v4, 4); //"Los Angeles", "Houston"
        ciudades.connect(v3, v5, 7); //"Chicago", "Phoenix"
        ciudades.connect(v4, v6, 3); //"Houston", "Philadelphia"
        ciudades.connect(v5, v7, 1); //"Phoenix", "San Antonio"
        ciudades.connect(v6, v1, 6); //"Philadelphia", "New York"
        ciudades.connect(v7, v3, 8); //"San Antonio", "Chicago*/
        /*
        Graph<String> ciudades = new AdjListGraph<>();
        Vertex<String> v1 = ciudades.createVertex("Buenos Aires");
        Vertex<String> v2 = ciudades.createVertex("Santiago");
        Vertex<String> v3 = ciudades.createVertex("Asunción");
        Vertex<String> v4 = ciudades.createVertex("Caracas");
        Vertex<String> v5 = ciudades.createVertex("Madrid");
        Vertex<String> v6 = ciudades.createVertex("Lima");
        Vertex<String> v7 = ciudades.createVertex("Bogotá");
        Vertex<String> v8 = ciudades.createVertex("México D.F.");
        Vertex<String> v9 = ciudades.createVertex("São Paulo");
        Vertex<String> v10 = ciudades.createVertex("Rio de Janeiro");

        ciudades.connect(v1, v2, 3); //"Buenos Aires", "Santiago"
        ciudades.connect(v1, v3, 6); //"Buenos Aires", "Asunción"
        ciudades.connect(v1, v6, 5); //"Buenos Aires", "Lima"
        ciudades.connect(v2, v5, 4); //"Santiago", "Madrid"
        ciudades.connect(v2, v7, 2); //"Santiago", "Bogotá"
        ciudades.connect(v3, v4, 7); //"Asunción", "Caracas"
        ciudades.connect(v4, v9, 8); //"Caracas", "São Paulo"
        ciudades.connect(v5, v8, 9); //"Madrid", "México D.F."
        ciudades.connect(v6, v10, 4); //"Lima", "Rio de Janeiro"
        ciudades.connect(v7, v1, 3); //"Bogotá", "Buenos Aires"
        ciudades.connect(v8, v6, 5); //"México D.F.", "Lima"
        ciudades.connect(v9, v2, 6); //"São Paulo", "Santiago"
        ciudades.connect(v10, v4, 7); //"Rio de Janeiro", "Caracas"
        ciudades.connect(v10, v5, 3); //"Rio de Janeiro", "Madrid"
        */
        
        
        
        Recorridos<String> rec = new Recorridos<>();
        List<String> lista = rec.dfs(ciudades);
        for (String string : lista) {
            System.out.println(string);
        }
        
    }
}
