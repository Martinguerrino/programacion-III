package tp3;

import java.util.List;

import tp1.ej8.Queue;
import tp2.BinaryTree;

import java.util.LinkedList;


public class GeneralTree<T> {

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();

	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}

	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}

	public boolean hasChildren() {
		return children != null && !children.isEmpty();
	}

	public boolean isEmpty() {
		return this.data == null && !hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren()) {
			List<GeneralTree<T>> children = this.getChildren();
			if (children.contains(child))
				children.remove(child);
		}
	}

	public void preOrden() {
		System.out.println(getData());
		List<GeneralTree<T>> children = this.getChildren();
		for (GeneralTree<T> child: children) {
		child.preOrden();
		}
		}

	public void InOrden()
	{
		List<GeneralTree<T>> hijosDerechos = null;
		if(this.hasChildren())
		{
			System.out.println(this.getChildren().get(0).getData());
			hijosDerechos = this.getChildren().subList(1, this.getChildren().size());
		}
		System.out.println(this.getData());
		if(hijosDerechos!=null)
		{
			for (GeneralTree<T> hijo : hijosDerechos) {
				hijo.InOrden();
			}
		}
	}

	public void PostOrden()
	{
		if(this.hasChildren())
		{
			for (GeneralTree<T> hijo : this.getChildren()) {
				hijo.PostOrden();
			}
		}
		System.out.println(this.getData());
	}

	public void PorNiveles()
	{
		GeneralTree<T> aux;
		int nivel=0;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		System.out.println("nivel 0");
		cola.enqueue(this);
		cola.enqueue(null);
		while(!cola.isEmpty())
		{
			aux = cola.dequeue();
			if(aux!= null)
			{
			System.out.println(aux.getData());
			for (GeneralTree<T> hijo : aux.getChildren()) {
				cola.enqueue(hijo);
			}
			}
			else
			{
				if(!cola.isEmpty())
				{
				cola.enqueue(null);
				nivel++;
				System.out.println("nivel "+ nivel);
				}
			}
		}
	}
	
	public int altura()
	{
		int camino = 0;
		int caminoHijoMax=-1;
		if(this.hasChildren())
		{
			System.out.println("paso por aca");
			camino++;
			for (GeneralTree<T> hijo : this.getChildren()) 
			{
				int caminoHijo = hijo.altura();
				caminoHijoMax = (caminoHijo>caminoHijoMax)?caminoHijo:caminoHijoMax;
			}
			camino+=caminoHijoMax;
		}
		return camino;
	}

	public int nivel(T dato)
	{
		int camino = 0;
		camino = this.busqueda(dato);
		if(camino!=-1)
			return camino;
		else 
			{
				System.out.println("no esta");
				return -3;
			} 	
		
	}
	private int busqueda(T dato)
	{	
		if(this.getData()== dato)
		{
			return 0;
		}
		else
		{
			if(this.hasChildren())
			{
				for (GeneralTree<T> hijo : this.getChildren()) 
				{	
					int camino = hijo.busqueda(dato);
					if(camino!=-1)
					{
						camino++;
						return camino;
					}
				}
				
			}
			return -1;
		}
	}
	

	public int ancho()
	{
		int cant = 0;
		int cantMax=0;
		GeneralTree<T> aux;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		while(!cola.isEmpty())
		{
			aux = cola.dequeue();
			if(aux!= null)
			{
			cant++;
			for (GeneralTree<T> hijo : aux.getChildren()) {
				cola.enqueue(hijo);
			}
			}
			else
			{
				if(!cola.isEmpty())
				{
					if(cant>cantMax)
					{
						cantMax=cant;
					}
					cola.enqueue(null);
					
					cant=0;
				}
			}
		}
		return cantMax;
	}

	
	public boolean EsAncestro(T a, T b)
	{
		System.out.println(getData());
		if(this.getData()==a)
		{
			boolean esB=BusquedaDescendiente(b);
			if(esB)
				return true;
		}
		for (GeneralTree<T> child:this.getChildren()) 
		{
			boolean es =child.EsAncestro(a,b);
			if(es)
			{
				return true;
			}
		}
		return false;
		
	}
	public boolean BusquedaDescendiente(T b)
	{
		System.out.println(getData());
		if(this.getData()==b)
		{
			return true;
		}
		List<GeneralTree<T>> children = this.getChildren();
		for (GeneralTree<T> child: children) 
		{
			boolean es= child.BusquedaDescendiente(b);
			if(es)
			{
				return true;
			}
		}
		return false;
		
	}
	
	public static void main(String[] args) 
	{
		GeneralTree<String> a1 = new GeneralTree<String>("1");
		List<GeneralTree<String>> children2 = new LinkedList<GeneralTree<String>>();
		children2.add(new GeneralTree<String>("21"));
		children2.add(new GeneralTree<String>("22"));
		children2.add(new GeneralTree<String>("23"));
		GeneralTree<String> a2 = new GeneralTree<String>("2", children2);
		List<GeneralTree<String>> children3 = new LinkedList<GeneralTree<String>>();
		children3.add(new GeneralTree<String>("31"));
		children3.add(new GeneralTree<String>("32"));
		GeneralTree<String> a3 = new GeneralTree<String>("3", children3);
		List<GeneralTree<String>> childen = new LinkedList<GeneralTree<String>>();
		childen.add(a1);childen.add(a2);childen.add(a3);
		GeneralTree<String> a = new GeneralTree<String>("0", childen);
		a.PorNiveles();
		System.out.println(a.EsAncestro("0", "2"));
	}
	
		
	
	

}
