package tp5.ej3;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.listaAdy.AdjListGraph;

public class Mapa 
{
    Graph<String> mapaCiudades;

    public Mapa(Graph<String> grafo)
    {
        this.mapaCiudades= grafo;
    }
    
    public Graph<String> getMapaCiudades() {
        return mapaCiudades;
    }
    public void setMapaCiudades(Graph<String> mapaCiudades) {
        this.mapaCiudades = mapaCiudades;
    }
    
    public List<String> devolverCamino(String ciudad1,String ciudad2)
    {
        Graph<String> grafo = getMapaCiudades();
        Vertex<String> v = grafo.search(ciudad1);
        List<String> lista = new LinkedList<>();
        boolean[] marca = new boolean[grafo.getSize()];
        
        dfs2(grafo, v, ciudad2, marca, lista);
        
        return lista;
    }

    /*private boolean dfs(Graph<String> grafo ,Vertex<String> v,String objetivo,boolean[] marca,List<String> lista)
    {
        marca[v.getPosition()]=true;
        lista.add(v.getData());
        if(v.getData().equals(objetivo))
            return true;
        List<Edge<String>> adyacentes = grafo.getEdges(v);
        for (Edge<String> edge : adyacentes) 
        {
            int j = edge.getTarget().getPosition();
            if(!marca[j])
            {
                int tamaño =lista.size();
                if(dfs(grafo, edge.getTarget(), objetivo, marca, lista))
                    return true;    
                else
                    lista.subList(tamaño, lista.size()).clear();
            }
        }
        return false;
    }*/
    //este es mejor
    private boolean dfs2(Graph<String> grafo ,Vertex<String> v,String objetivo,boolean[] marca,List<String> lista)
    {
        marca[v.getPosition()]=true;
        if(v.getData().equals(objetivo))
        {
            lista.add(v.getData());
            return true;
        }
        List<Edge<String>> adyacentes = grafo.getEdges(v);
        for (Edge<String> edge : adyacentes) 
        {
            int j = edge.getTarget().getPosition();
            if(!marca[j])
            {
                if(dfs2(grafo, edge.getTarget(), objetivo, marca, lista))
                {
                    lista.addFirst(v.getData());
                    return true;
                }
                
            }
        }
        return false;
    }


    public List<String>devolverCaminoExceptuando(String ciudad1,String ciudad2,List<String> excepciones)
    {
        Graph<String> grafo = getMapaCiudades();
        Vertex<String> v = grafo.search(ciudad1);
        List<String> lista = new LinkedList<>();
        boolean[] marca = new boolean[grafo.getSize()];
        dfsExcepcion(grafo, v, ciudad2, marca, lista,excepciones);
        return lista;
    }
    private boolean dfsExcepcion(Graph<String> grafo ,Vertex<String> v,String objetivo,boolean[] marca,List<String> lista,List<String> excepciones)
    {
        marca[v.getPosition()]=true;
        if(v.getData().equals(objetivo))
        {
            lista.add(v.getData());
            return true;
        }
        List<Edge<String>> adyacentes = grafo.getEdges(v);
        for (Edge<String> edge : adyacentes) 
        {
            int j = edge.getTarget().getPosition();
            if(!marca[j])
            {
                if(!excepciones.contains(edge.getTarget().getData()))
                {
                    if(dfsExcepcion(grafo, edge.getTarget(), objetivo, marca, lista, excepciones))
                    {
                        lista.addFirst(v.getData());
                        return true;
                    }
                    
                }
            }
        }
        return false;
    }    
    /*public List<String> Dijkstra(Graph<String> grafo,Edge<String> adyacentes,Vertex<String> origen)
    {
        int[][] matriz = new int[grafo.getSize()][2];
        int[] conocidos = new int[grafo.getSize()];
        for(int i=0;i<grafo.getSize();i++)
        {
            matriz[i][0]=32000;
            matriz[i][1]=0;
        }
        matriz[origen.getPosition()][0]=0;
        List<Vertex<String>> vertices = grafo.getVertices();
        for (Vertex<String> vertice : vertices) 
        {
            
        }

    }*/

    //fijarme que la lista siguiente sea menor a la actual
    public List<String> caminoMasCorto(String ciudad1,String ciudad2)
    {
        Graph<String> grafo = getMapaCiudades();
        Vertex<String> v = grafo.search(ciudad1);
        List<String> lista = new LinkedList<>();
        boolean[] marca = new boolean[grafo.getSize()];
        int peso=0,pesoMin=1000;
        dfsCorto(grafo, v, ciudad2, marca, lista,peso,pesoMin);
        
        return lista;
    }
    /*private boolean dfsCorto(Graph<String> grafo ,Vertex<String> v,String objetivo,boolean[] marca,List<String> lista,int peso,int pesoMin)
    {
        
        if(v.getData().equals(objetivo)&& peso<pesoMin)//si el peso es menor al camino minimo
        {
            lista.clear();
            lista.add(v.getData());//arranco nueva lista y devuelvo que es un nuevo minimo con el true
            return true;
        }
        else if(v.getData().equals(objetivo))
            return false;//si lo encontre pero no es el minimo camino mando false para no cambiar el pesoMin
        marca[v.getPosition()]=true;//marco que visite el nodo
        boolean encontre = false;
        List<Edge<String>> adyacentes = grafo.getEdges(v);//lista de aristas
        for (Edge<String> edge : adyacentes) 
        {
            if(edge.getTarget().getData().equals("Caracas"))
            {
                System.out.println("segundo camino desde asuncion");
            }
            int j = edge.getTarget().getPosition();//consigo posicion del nodo apuntado
            if(!marca[j])//me fijo si fue visitado
            {
                peso+=edge.getWeight();//sumo peso del camino actual
                //podria devolver en vez de boolean el peso min
                if(dfsCorto(grafo, edge.getTarget(), objetivo, marca, lista,peso,pesoMin))//entro en la funcion
                {
                    
                    lista.addFirst(v.getData());//en caso de encontrar camino minimo agrego nodo a la lista
                    pesoMin= peso;//cambio el peso minimo para todos los demas caminos
                    encontre=true;//problema encontrar como pasar pesoMin
                }
                peso-=edge.getWeight();//resto peso del camino actual para el siguiente arista
                System.out.println("paso por reduccion de peso");
                //quiero volver por ultima vez cuando haya visto el ultimo camino
                //como se cual es el ultimo camino? cuando es la ultima arista
                //debo desmarcar una vez que vuelvo el nodo actual
                //cuando lo encuentro tengo que volver y armar la lista y armar una lista con la siguiente arista
                //fijarme ambos pesos y el que tenga menor pasa a ser la lista ganadora
                //puedo a medida que avanzo contar el peso y armar la lista, si el peso es menor armo una nueva:listo
                //volviendo debo desmarcar lo que marque :listo
                //como hago para marcar el peso minimo:listo

                
            }
            
        }
        marca[v.getPosition()]=false;//desmarco nodo
        return encontre;
    }*/
    private int dfsCorto(Graph<String> grafo ,Vertex<String> v,String objetivo,boolean[] marca,List<String> lista,int peso,int pesoMin)
    {
        
        if(v.getData().equals(objetivo)&& peso<pesoMin)//si el peso es menor al camino minimo
        {
            lista.clear();
            lista.add(v.getData());//arranco nueva lista y devuelvo que es un nuevo minimo con el true
            return peso;
        }
        else if(v.getData().equals(objetivo))
            return 0;//si lo encontre pero no es el minimo camino mando false para no cambiar el pesoMin
        marca[v.getPosition()]=true;//marco que visite el nodo
        int resul=0;
        boolean encontre=false;
        List<Edge<String>> adyacentes = grafo.getEdges(v);//lista de aristas
        for (Edge<String> edge : adyacentes) 
        {
            
            int j = edge.getTarget().getPosition();//consigo posicion del nodo apuntado
            if(!marca[j])//me fijo si fue visitado
            {   
                

                peso+=edge.getWeight();//sumo peso del camino actual
                //podria devolver en vez de boolean el peso min
                resul = dfsCorto(grafo, edge.getTarget(), objetivo, marca, lista,peso,pesoMin);
                if(resul!=0)//entro en la funcion
                {
                    lista.addFirst(v.getData());//en caso de encontrar camino minimo agrego nodo a la lista
                    pesoMin= resul;//cambio el peso minimo para todos los demas caminos
                    encontre=true;

                }
                
                peso-=edge.getWeight();//resto peso del camino actual para el siguiente arista

                
            }
            
        }
        
        if(encontre)
        {
            resul=pesoMin;
        }
        marca[v.getPosition()]=false;//desmarco nodo
        return resul;
    }

    public List<String>caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto)
    {
        Graph<String> grafo = getMapaCiudades();
        Vertex<String> v = grafo.search(ciudad1);
        List<String> lista = new LinkedList<>();
        boolean[] marca = new boolean[grafo.getSize()];
        dfsSinC(grafo, v, ciudad2, marca, lista,tanqueAuto);
        return lista;
    }

    private boolean dfsSinC(Graph<String> grafo ,Vertex<String> v,String objetivo,boolean[] marca,List<String> lista,int tanque)
    {
        marca[v.getPosition()]=true;
        if(v.getData().equals(objetivo))
        {
            lista.add(v.getData());
            return true;
        }
        int tanqueAct=tanque;
        List<Edge<String>> adyacentes = grafo.getEdges(v);
        for (Edge<String> edge : adyacentes) 
        {
            int j = edge.getTarget().getPosition();
            tanqueAct=tanque-edge.getWeight();
            if(!marca[j]&&tanqueAct>0)
            {
                if(dfsSinC(grafo, edge.getTarget(), objetivo, marca, lista,tanqueAct))
                {
                    lista.addFirst(v.getData());
                    return true;
                }
                
            }
        }
        return false;
    }
    public List<String> caminoConMenorCargaCombustible(String ciudad1, String ciudad2, int tanqueAuto)
    {
        Graph<String> grafo = getMapaCiudades();
        Vertex<String> v = grafo.search(ciudad1);
        List<String> lista = new LinkedList<>();
        boolean[] marca = new boolean[grafo.getSize()];
        int[] cargas = new int[1];
        cargas[0]=0;
        int carga =0;
        int cargasMin=3000;
        dfsConCarga(grafo, v, ciudad2, marca, lista,tanqueAuto,tanqueAuto,carga,cargasMin);
        return lista;
    }
    private int dfsConCarga(Graph<String> grafo ,Vertex<String> v,String objetivo,boolean[] marca,List<String> lista,int tanqueAct,int tanqueLleno,int cargas,int cargasMin)
    {
        if(v.getData().equals(objetivo)&& cargas<cargasMin)//si el peso es menor al camino minimo
        {
            lista.clear();
            lista.add(v.getData());//arranco nueva lista y devuelvo que es un nuevo minimo con el true
            return cargas;
        }
        else if(v.getData().equals(objetivo))
            return 0;//si lo encontre pero no es el minimo camino mando false para no cambiar el pesoMin
        marca[v.getPosition()]=true;//marco que visite el nodo
        int resul=0;
        boolean encontre=false;
        int tanqueViaje =tanqueAct;
        List<Edge<String>> adyacentes = grafo.getEdges(v);//lista de aristas
        for (Edge<String> edge : adyacentes) 
        {
            
            int j = edge.getTarget().getPosition();//consigo posicion del nodo apuntado
            if(!marca[j])//me fijo si fue visitado
            {   
                if(tanqueLleno<edge.getWeight())
                {
                    
                    continue;
                }
                if(tanqueAct<edge.getWeight())
                {
                    tanqueViaje=tanqueLleno;
                    cargas++;
                }
                tanqueViaje-=edge.getWeight();
                resul = dfsConCarga(grafo, edge.getTarget(), objetivo, marca, lista,tanqueViaje,tanqueLleno,cargas,cargasMin);
                if(resul!=0)//entro en la funcion
                {
                    lista.addFirst(v.getData());//en caso de encontrar camino minimo agrego nodo a la lista
                    encontre=true;
                    cargasMin=resul;

                }
                
                tanqueViaje=tanqueAct;
                
            }
            
        }
        
        if(encontre)
        {
            resul=cargasMin;
        }
        marca[v.getPosition()]=false;//desmarco nodo
        return resul;
    }
    
    public static void main(String[] args) 
    {
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
        Mapa map = new Mapa(ciudades);
        List<String> excepciones = new LinkedList<>();
        excepciones.add("Santiago");
        excepciones.add("Madrid");
        excepciones.add("Tokio");
        List<String> lista = map.caminoConMenorCargaCombustible("Lima", "Madrid",10);
        if(!lista.isEmpty())
        {
            for (String p : lista) 
            {
                
                System.out.println(p);
            }
        }
        else System.out.println("no se puede llegar");
    }
}
