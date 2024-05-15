package tp1.ej9;

import java.util.Scanner;

public class TestBalanceo {

    public static void main(String[] args) 
    {
        caracteresS caracs = new caracteresS();
        Scanner input = new Scanner(System.in);
        caracs.setcaracteresS();
        if(caracs.balanceado())
            System.out.println("balanceado");
        else
            System.out.println("no balanceado");
        input.close();
    }
}
