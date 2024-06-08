package tp3.ej6;

import java.util.LinkedList;
import java.util.List;

import tp3.GeneralTree;

public class RedDeAguaPotable 
{
    GeneralTree<Double> red;
    
    public RedDeAguaPotable(GeneralTree<Double> red)
    {
        this.red= red;
    }
    public void setRed(GeneralTree<Double> red) {
        this.red = red;
    }
    public GeneralTree<Double> getRed() {
        return red;
    }
    public double minimoCaudal(double caudal)
    {
        return minimoCaudal2(caudal, this.getRed());
    }
    private double minimoCaudal2(double caudal,GeneralTree<Double> arbol)
    {
        System.out.println(caudal);
        double caudalHijos = caudal/arbol.getChildren().size();
        double min = caudal;
        if(this.getRed().hasChildren())
        {
            System.out.println("cantidad hijos "+arbol.getChildren().size());
            for (GeneralTree<Double> hijo : arbol.getChildren()) 
            {
                double caudalRecorrido= minimoCaudal2(caudalHijos,hijo);
                if(min>caudalRecorrido)
                {
                    min=caudalRecorrido;
                }
            }
        }
        return min;
    }
    public static void main(String[] args) 
    {
        GeneralTree<Double> a1 = new GeneralTree<Double>(1.0);
        GeneralTree<Double> a32 = new GeneralTree<Double>(1.0);
        a32.addChild(new GeneralTree<Double>(21.0));
        a32.addChild(new GeneralTree<Double>(21.0));
        GeneralTree<Double> a4 = new GeneralTree<Double>(1.0);
		List<GeneralTree<Double>> children2 = new LinkedList<GeneralTree<Double>>();
		children2.add(new GeneralTree<Double>(21.0));
		children2.add(new GeneralTree<Double>(22.0));
		
		GeneralTree<Double> a2 = new GeneralTree<Double>(2.0, children2);
		List<GeneralTree<Double>> children3 = new LinkedList<GeneralTree<Double>>();
		children3.add(new GeneralTree<Double>(31.0));
		children3.add(a32);
        children3.add(new GeneralTree<Double>(21.0));
        children3.add(new GeneralTree<Double>(21.0));
		GeneralTree<Double> a3 = new GeneralTree<Double>(3.0, children3);
		List<GeneralTree<Double>> childen = new LinkedList<GeneralTree<Double>>();
		childen.add(a1);childen.add(a2);childen.add(a3);childen.add(a4);
		GeneralTree<Double> a = new GeneralTree<Double>(0.0, childen);
		a.PorNiveles();

        RedDeAguaPotable red = new RedDeAguaPotable(a);
        System.out.println(red.minimoCaudal(1000.0));
    }
}
