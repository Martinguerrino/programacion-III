package tp3.ej7;

import java.util.LinkedList;
import java.util.List;

import tp3.GeneralTree;

public class Caminos 
{

    GeneralTree<Integer> arbol;
    public Caminos(GeneralTree<Integer> arbol)
    {
        this.arbol=arbol;
    }
	public GeneralTree<Integer> getArbol() {
		return arbol;
	}
	public void setArbol(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}
    public List<Integer> caminoAHojaMasLejana ()
    {
        List<Integer> camino = new LinkedList<>();
        List<Integer> caminomax=new LinkedList<>();
		recorrido3(this.getArbol(),camino,caminomax);
		return caminomax;

    }
	//2 liSTAS UNA ACTUAL Y OTRA MAX
    private void recorrido3(GeneralTree<Integer>arbol,List<Integer> listaActual,List<Integer> listaMax)
	{
		listaActual.add(arbol.getData());
		List<Integer> listaAux=new LinkedList<>();
		listaAux.addAll(listaActual);
		for (GeneralTree<Integer> hijo : arbol.getChildren()) 
		{
			//necesito un auxiliar para manejar el camino del hijo anterior poder sacarlo
			recorrido3(hijo, listaActual, listaMax);
			if(listaActual.size()>listaMax.size())
			{
				listaMax.clear();
				listaMax.addAll(listaActual);
			}
			listaActual.clear();
			listaActual.addAll(listaAux);
		}
    }

	public static void main(String[] args) {
		GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> a24 = new GeneralTree<Integer>(24);
		a24.addChild(new GeneralTree<Integer>(241));
		List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
		children2.add(new GeneralTree<Integer>(21));
		children2.add(new GeneralTree<Integer>(22));
		children2.add(new GeneralTree<Integer>(23));
		
		GeneralTree<Integer> a2 = new GeneralTree<Integer>(2, children2);
		List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
		children3.add(new GeneralTree<Integer>(31));
		children3.add(new GeneralTree<Integer>(32));
		children3.add(a24);
		GeneralTree<Integer> a3 = new GeneralTree<Integer>(3, children3);
		List<GeneralTree<Integer>> childen = new LinkedList<GeneralTree<Integer>>();
		childen.add(a1);childen.add(a2);childen.add(a3);
		GeneralTree<Integer> a = new GeneralTree<Integer>(0, childen);
		a.PorNiveles();
		Caminos camino = new Caminos(a);
		List<Integer> caminoLargo=camino.caminoAHojaMasLejana();
		for (Integer integer : caminoLargo) {
			System.out.println(integer);
		}
	}
}
