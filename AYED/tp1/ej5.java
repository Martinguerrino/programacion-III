package tp1;

public class ej5 
{       private static Resultado resul;
        public static class Resultado
        {   
            private int min;
            private int max;
            private float prom;

            public int getMax() {
                return max;
            }
            public int getMin() {
                return min;
            }
            public float getProm() {
                return prom;
            }
            public void setMax(int max) {
                this.max = max;
            }
            public void setMin(int min) {
                this.min = min;
            }
            public void setProm(float prom) {
                this.prom = prom;
            }

        }
        public static int [] maxMinProm1(int [] vector)
        {   int min,max,sumatoria,cant,prom;
            int [] resultado=new int[3];
            sumatoria = 0;
            min=10000;
            max=-1;
            cant=0;
            for (int elemento : vector) 
            {
                if(elemento<min)
                    min=elemento;
                if(elemento>max)
                    max=elemento;
                sumatoria+=elemento;
                cant+=1;
            }
            prom=sumatoria / cant;
            resultado[0]=min;
            resultado[1]=max;
            resultado[2]=prom;
            return resultado;
        }
    public static Resultado maxMinProm2(int [] vector)
    {   int min,max,sumatoria,cant;
        float prom;
        Resultado res = new Resultado();
        sumatoria = 0;
        min=10000;
        max=-1;
        cant=0;
        for (int elemento : vector) 
        {
            if(elemento<min)
                min=elemento;
            if(elemento>max)
                max=elemento;
            sumatoria+=elemento;
            cant+=1;
        }
        prom=(float)sumatoria / cant;
        res.setMax(max);
        res.setMin(min);
        res.setProm(prom);
        return res;
    }
    public static void maxMinProm3(int [] vector,Resultado res)
    {   int min,max,sumatoria,cant;
        float prom;
        sumatoria = 0;
        min=10000;
        max=-1;
        cant=0;
        for (int elemento : vector) 
        {
            if(elemento<min)
                min=elemento;
            if(elemento>max)
                max=elemento;
            sumatoria+=elemento;
            cant+=1;
        }
        prom=(float)sumatoria / cant;
        res.setMax(max);
        res.setMin(min);
        res.setProm(prom);
    }
    

    public static void maxMinProm4(int [] vector)
    {
        int min,max,sumatoria,cant;
        float prom;
        sumatoria = 0;
        min=10000;
        max=-1;
        cant=0;
        for (int elemento : vector) 
        {
            if(elemento<min)
                min=elemento;
            if(elemento>max)
                max=elemento;
            sumatoria+=elemento;
            cant+=1;
        }
        prom=(float)sumatoria / cant;
        resul.setMax(max);
        resul.setMin(min);
        resul.setProm(prom);
    }
    public static void main(String[] args) 
    {
        int [] vector = {3,5,6,7,8,9,0,1,3,4,5,15};
    /*  int [] vectorResultado = new int[3];
        vectorResultado=maxMinProm1(vector);
        for (int f : vectorResultado) {
            System.out.println(f);
        }*/  
        /*Resultado resultado = maxMinProm2(vector);*/
        /*Resultado resultado = new Resultado();
        maxMinProm3(vector, resultado);
        System.out.println("el maximo es: ");
        System.out.println(resultado.getMax());
        System.out.println("el minimo es: ");
        System.out.println(resultado.getMin());
        System.out.println("el promedio es: ");
        System.out.println(resultado.getProm());
        */
        resul=new Resultado();
        maxMinProm4(vector);
        System.out.println("el maximo es: ");
        System.out.println(resul.getMax());
        System.out.println("el minimo es: ");
        System.out.println(resul.getMin());
        System.out.println("el promedio es: ");
        System.out.println(resul.getProm());
    }
}
