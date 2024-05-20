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

	
	
		
	
	

}
