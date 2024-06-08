package tp5.ej6;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.listaAdy.AdjListGraph;

public class BuscadorDeCaminos 
{
    Graph<String> bosque;
    public BuscadorDeCaminos(Graph<String> bosque)
    {
        this.bosque = bosque;
    }
    public Graph<String> getBosque() {
        return bosque;
    }
    public void setBosque(Graph<String> bosque) {
        this.bosque = bosque;
    }
    public List <List<String>> recorridosMasSeguro()
    {
        Graph<String> bosque = this.getBosque();
        Vertex<String> v = bosque.search("Casa Caperucita");
        boolean[] marca = new boolean[bosque.getSize()];
        List<List<String>> listaCaminos= dfsCaperucita(bosque,v,marca);
        return listaCaminos;
    }
//podria hacer que llame a un for de los adyacentes de la Casa caperusita y ahi llamar la funcion y que me devuelvan caminos
    private List<List<String>> dfsCaperucita(Graph<String> bosque,Vertex<String> v,boolean[] marca)
    {
        if(v.getData().equals("Casa Abuelita"))
        {
            List<String> listaChica = new LinkedList<>();
            listaChica.add(v.getData());
            List<List<String>> lista = new LinkedList<>();//en caso de encontrar devuelvo la lista de listas
            lista.add(listaChica);
            return  lista;
        }
        marca[v.getPosition()]=true;
        List<List<String>> listaListas=new LinkedList<>();
        List<Edge<String>> adyacentes = bosque.getEdges(v);
        for (Edge<String> edge : adyacentes) 
        {
            if(edge.getWeight()>=5)
                continue;
            //estoy en el nodo y tengo que agregar a mi lista de listas la lista de listas de mis adyacentes
            if(!marca[edge.getTarget().getPosition()])
            {
                List<List<String>>posiblesCaminos = dfsCaperucita(bosque, edge.getTarget(),  marca);
                if(posiblesCaminos!=null)
                {
                
                    for (List<String> lista : posiblesCaminos) 
                    {
                        lista.addFirst(v.getData());
                    }
                    listaListas.addAll(posiblesCaminos);
                }
            }
        }
        marca[v.getPosition()]=false;
        if(listaListas.isEmpty())
            return null;
        return listaListas;
    }
    /*
     * private boolean dfsCaperucita(Graph<String> bosque,Vertex<String> v,List<List<String>> listaCaminos, List<String> camino,boolean[] marca)
    {
        if(v.getData().equals("Casa Abuelita"))
        {
            camino.add(v.getData());
            return true;
        }
        marca[v.getPosition()]=true;
        List<Edge<String>> adyacentes = bosque.getEdges(v);
        for (Edge<String> edge : adyacentes) 
        {
            if(edge.getWeight()>=5)
                continue;
            if(dfsCaperucita(bosque, edge.getTarget(), listaCaminos, camino, marca))
            {
                camino.addFirst(v.getData());
            }
        }
        marca[v.getPosition()]=false;
        return false;
    }
     */
    public static void main(String[] args) 
    {
        Graph<String> graph = new AdjListGraph<>();

        Vertex<String> casaCaperucita = graph.createVertex("Casa Caperucita");
        Vertex<String> claro1 = graph.createVertex("Claro1");
        Vertex<String> claro2 = graph.createVertex("Claro2");
        Vertex<String> claro3 = graph.createVertex("Claro3");
        Vertex<String> claro4 = graph.createVertex("Claro4");
        Vertex<String> claro5 = graph.createVertex("Claro5");
        Vertex<String> casaAbuelita = graph.createVertex("Casa Abuelita");

        graph.connect(casaCaperucita, claro1, 3);
        graph.connect(claro1, casaCaperucita, 3);

        graph.connect(casaCaperucita, claro2, 4);
        graph.connect(claro2, casaCaperucita, 4);

        graph.connect(casaCaperucita, claro3, 4);
        graph.connect(claro3, casaCaperucita, 4);

        graph.connect(claro2, claro1, 4);
        graph.connect(claro1, claro2, 4);

        graph.connect(claro2, claro5, 11);
        graph.connect(claro5, claro2, 11);

        graph.connect(claro1, claro5, 3);
        graph.connect(claro5, claro1, 3);

        graph.connect(claro3, claro5, 15);
        graph.connect(claro5, claro3, 15);

        graph.connect(claro2, claro4, 10);
        graph.connect(claro4, claro2, 10);

        graph.connect(casaAbuelita, claro5, 4);
        graph.connect(claro5, casaAbuelita, 4);

        graph.connect(claro4, casaAbuelita, 9);
        graph.connect(casaAbuelita, claro4, 9);

        BuscadorDeCaminos buscador = new BuscadorDeCaminos(graph);
        List<List<String>> listaCaminos = buscador.recorridosMasSeguro();
        if(listaCaminos!=null)
        {
        for (List<String> lista : listaCaminos) {
            System.out.println("arranco un camino");
            for (String camino : lista) {
                System.out.println(camino);
            }
        }
        }
        else
            System.out.println("no llegue");
    }
}
