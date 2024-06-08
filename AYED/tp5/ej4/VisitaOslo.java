package tp5.ej4;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.listaAdy.AdjListGraph;

public class VisitaOslo 
{
    public List<String> paseoEnBici(Graph<String> lugares,String destino, int maxTiempo,List<String> lugaresRestringidos)
    {
        Vertex<String> v = lugares.search("Ayuntamiento");
        List<String> lista = new LinkedList<>();
        boolean[] marca = new boolean[lugares.getSize()];
        dfsOslo(lugares,v,destino,marca,lista,lugaresRestringidos,maxTiempo);
        return lista;
    }
    private boolean dfsOslo(Graph<String> lugares ,Vertex<String> v,String objetivo,boolean[] marca,List<String> lista,List<String> restringidos,int tiempoAct)
    {
        marca[v.getPosition()]=true;
        if(v.getData().equals(objetivo))
        {
            lista.add(v.getData());
            return true;
        }
        List<Edge<String>> adyacentes = lugares.getEdges(v);
        for (Edge<String> edge : adyacentes) 
        {
            if(restringidos.contains(edge.getTarget().getData()))
                continue;
            int j = edge.getTarget().getPosition();
            
            if(!marca[j])
            {
                if(tiempoAct<edge.getWeight())
                {
                    
                    continue;
                }
                tiempoAct-=edge.getWeight();
                if(dfsOslo(lugares, edge.getTarget(), objetivo, marca, lista,restringidos,tiempoAct))
                {
                    lista.addFirst(v.getData());
                    return true;
                }
                tiempoAct+=edge.getWeight();
            }
        }
        return false;
    }
    public static void main(String[] args) 
    {
        Graph<String> grafo = new AdjListGraph<>();

        Vertex<String> Holmenkollen = grafo.createVertex("Holmenkollen");
        Vertex<String> GaleriaNacional = grafo.createVertex("Galería Nacional");
        Vertex<String> ParqueVigeland = grafo.createVertex("Parque Vigeland");
        Vertex<String> PalacioReal = grafo.createVertex("Palacio Real");
        Vertex<String> FolkMuseum = grafo.createVertex("FolkMuseum");
        Vertex<String> MuseoFram = grafo.createVertex("Museo Fram");
        Vertex<String> MuseoVikingo = grafo.createVertex("Museo Vikingo");
        Vertex<String> MuseoBarcoPolar = grafo.createVertex("Museo del Barco Polar");
        Vertex<String> ParqueBotanico = grafo.createVertex("Parque Botánico");
        Vertex<String> MuseoMunch = grafo.createVertex("Museo Munch");
        Vertex<String> Ayuntamiento = grafo.createVertex("Ayuntamiento");
        Vertex<String> AkkerBrigge = grafo.createVertex("Akker Brigge");
        Vertex<String> ElTigre = grafo.createVertex("El Tigre");
        Vertex<String> LaOpera = grafo.createVertex("La Opera");
        Vertex<String> FortalezaAkershus = grafo.createVertex("Fortaleza Akershus");

        // Conexiones bidireccionales con tiempos de viaje
        grafo.connect(Holmenkollen, ParqueVigeland, 30);
        grafo.connect(ParqueVigeland, Holmenkollen, 30);

        grafo.connect(ParqueVigeland, GaleriaNacional, 10);
        grafo.connect(GaleriaNacional, ParqueVigeland, 10);

        grafo.connect(ParqueVigeland, FolkMuseum, 20);
        grafo.connect(FolkMuseum, ParqueVigeland, 20);

        grafo.connect(ParqueBotanico, Ayuntamiento, 10);
        grafo.connect(Ayuntamiento, ParqueBotanico, 10);

        grafo.connect(PalacioReal, Ayuntamiento, 5);
        grafo.connect(Ayuntamiento, PalacioReal, 5);

        grafo.connect(PalacioReal, FolkMuseum, 5);
        grafo.connect(FolkMuseum, PalacioReal, 5);

        grafo.connect(FolkMuseum, MuseoFram, 5);
        grafo.connect(MuseoFram, FolkMuseum, 5);

        grafo.connect(MuseoFram, MuseoBarcoPolar, 5);
        grafo.connect(MuseoBarcoPolar, MuseoFram, 5);

        grafo.connect(MuseoVikingo, MuseoBarcoPolar, 5);
        grafo.connect(MuseoBarcoPolar, MuseoVikingo, 5);

        grafo.connect(FolkMuseum, AkkerBrigge, 30);
        grafo.connect(AkkerBrigge, FolkMuseum, 30);

        grafo.connect(MuseoVikingo, AkkerBrigge, 30);
        grafo.connect(AkkerBrigge, MuseoVikingo, 30);

        grafo.connect(Ayuntamiento, AkkerBrigge, 20);
        grafo.connect(AkkerBrigge, Ayuntamiento, 20);

        grafo.connect(GaleriaNacional, ParqueBotanico, 15);
        grafo.connect(ParqueBotanico, GaleriaNacional, 15);

        grafo.connect(ParqueBotanico, MuseoMunch, 1);
        grafo.connect(MuseoMunch, ParqueBotanico, 1);

        grafo.connect(Ayuntamiento, ElTigre, 15);
        grafo.connect(ElTigre, Ayuntamiento, 15);

        grafo.connect(ElTigre, MuseoMunch, 15);
        grafo.connect(MuseoMunch, ElTigre, 15);

        grafo.connect(ElTigre, LaOpera, 5);
        grafo.connect(LaOpera, ElTigre, 5);

        grafo.connect(LaOpera, FortalezaAkershus, 10);
        grafo.connect(FortalezaAkershus, LaOpera, 10);
        
        List<String> restringidos = new LinkedList<>();
        restringidos.add("Akker Brigge");
        restringidos.add("Palacio Real");
        VisitaOslo visita = new VisitaOslo();
        List<String> lista = visita.paseoEnBici(grafo, "Museo Vikingo", 70, restringidos);
        if(!lista.isEmpty())
        {
            for (String string : lista) {
                System.out.println(string);
            }
        }
        else
            System.out.println("no se puede llegar");
    }
}

