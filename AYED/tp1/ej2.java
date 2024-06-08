package tp1;
import java.util.Scanner;
public class ej2 {

    public static int[] arregloN(int n)
    {
        int i;
        int [] vector = new int[n];
        for (i=0;i<vector.length;i++)
            vector[i]=n*(i+1);
        
        return vector;
    }

    public static void main(String[] args) 
    {
        int n;
        int[] vector;
        Scanner input = new Scanner(System.in);
        System.out.println("ingrese dimension del arreglo: ");
        n=input.nextInt();
        vector= ej2.arregloN(n);
        for (int i : vector) 
        {
            System.out.println(i);
        }
        input.close();

    }
}
