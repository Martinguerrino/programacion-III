package tp1;

import java.util.Scanner;
public class ej1 {
    
    public static void impFor(int a,int b)
    {
        for(;a<=b;a++)
        {
            System.out.println(a);
        }
    }
    public static void impWhile(int a ,int b)
    {
        while(a<=b)
        {
            System.out.println(a);
            a++;
        }
    }
    public static void impNoIterativo(int a,int b)
    {
        if(a<=b)
        {
            System.out.println(a);
            impNoIterativo(a+1,b);
        }
    }


public static void main(String [] args)
{
    int a,b;
    Scanner input = new Scanner(System.in);
    System.out.println("ingrese el primer extremo");
    a= input.nextInt();
    System.out.println("ingrese el segundo extremo");
    b= input.nextInt();
    ej1.impNoIterativo(a,b);
    input.close();
    
}
}