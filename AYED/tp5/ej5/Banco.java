package tp5.ej5;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.listaAdy.AdjListGraph;

public class Banco 
{
    public List<Persona> carteraJubilados(Graph<Persona> personas,Persona empleado,int distancia)
    {
        Vertex<Persona> v = personas.search(empleado);
        List<Persona> lista = new LinkedList<>();
        boolean[] marca = new boolean[personas.getSize()];
        dfsJubilados(personas,v,marca,lista,distancia);
        return lista;
    }
    private void dfsJubilados(Graph<Persona> personas, Vertex<Persona> v , boolean[] marca,List<Persona> lista,int distancia)
    {
        marca[v.getPosition()]=true;
        if(v.getData().getPuesto().equals("Jubilado")&&!v.getData().getCobro())
        {
            v.getData().setCobro(true);
            lista.add(v.getData());
        }
        List<Edge<Persona>> adyacentes = personas.getEdges(v);
        for (Edge<Persona> edge : adyacentes) 
        {
            if(distancia<edge.getWeight())
                continue;
            if(!marca[edge.getTarget().getPosition()])
            {
                distancia-=edge.getWeight();
                dfsJubilados(personas,edge.getTarget(),marca,lista,distancia);
                distancia+=edge.getWeight();
            }
        }
    }
    public static void main(String[] args) {
        Graph<Persona> grafo = new AdjListGraph<>();

        // Crear personas
        Persona p1 = new Persona("Juan", "Calle A", "Empleado", false);
        Persona p2 = new Persona("Maria", "Calle B", "Jubilado", false);
        Persona p3 = new Persona("Pedro", "Calle C", "Empleado", false);
        Persona p4 = new Persona("Ana", "Calle D", "Jubilado", false);
        Persona p5 = new Persona("Luis", "Calle E", "Jubilado", false);
        Persona p6 = new Persona("Sofia", "Calle F", "Jubilado", false);
        Persona p7 = new Persona("Carlos", "Calle G", "Empleado", false);
        Persona p8 = new Persona("Marta", "Calle H", "Jubilado", false);
        Persona p9 = new Persona("Laura", "Calle I", "Jubilado", false);
        Persona p10 = new Persona("Pablo", "Calle J", "Empleado", false);

        // Crear vértices en el grafo
        Vertex<Persona> v1 = grafo.createVertex(p1);
        Vertex<Persona> v2 = grafo.createVertex(p2);
        Vertex<Persona> v3 = grafo.createVertex(p3);
        Vertex<Persona> v4 = grafo.createVertex(p4);
        Vertex<Persona> v5 = grafo.createVertex(p5);
        Vertex<Persona> v6 = grafo.createVertex(p6);
        Vertex<Persona> v7 = grafo.createVertex(p7);
        Vertex<Persona> v8 = grafo.createVertex(p8);
        Vertex<Persona> v9 = grafo.createVertex(p9);
        Vertex<Persona> v10 = grafo.createVertex(p10);

        // Conectar vértices con pesos
        grafo.connect(v1, v2, 10);  // Juan - Maria
        grafo.connect(v2, v3, 15);  // Maria - Pedro
        grafo.connect(v3, v4, 20);  // Pedro - Ana
        grafo.connect(v4, v5, 25);  // Ana - Luis
        grafo.connect(v5, v6, 30);  // Luis - Sofia
        grafo.connect(v6, v7, 35);  // Sofia - Carlos
        grafo.connect(v7, v8, 40);  // Carlos - Marta
        grafo.connect(v8, v9, 45);  // Marta - Laura
        grafo.connect(v9, v10, 50); // Laura - Pablo
        grafo.connect(v10, v1, 55); // Pablo - Juan

        // Conexiones adicionales para hacerlo más complejo
        grafo.connect(v1, v5, 12);  // Juan - Luis
        grafo.connect(v2, v6, 14);  // Maria - Sofia
        grafo.connect(v3, v7, 16);  // Pedro - Carlos
        grafo.connect(v4, v8, 18);  // Ana - Marta
        grafo.connect(v5, v9, 20);  // Luis - Laura
        grafo.connect(v6, v10, 22); // Sofia - Pablo
        grafo.connect(v7, v1, 24);  // Carlos - Juan
        grafo.connect(v8, v2, 26);  // Marta - Maria
        grafo.connect(v9, v3, 28);  // Laura - Pedro
        grafo.connect(v10, v4, 30); // Pablo - Ana

        Banco banco = new Banco();
        List<Persona> lista = banco.carteraJubilados(grafo, p10, 60);
        for (Persona persona : lista) {
            System.out.println(persona.getNombre());
        }
    }
}
