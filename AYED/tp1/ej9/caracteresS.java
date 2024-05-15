package tp1.ej9;

import java.util.Scanner;

public class caracteresS {
    String caracs;
    public caracteresS()
    {
        caracs=new String();
    }
    public void setcaracteresS()
    {
        
        Scanner input = new Scanner(System.in);
        caracs=input.nextLine();
        while(!(permitido(caracs)))
        {
            System.out.println("caracteres invalodos ingrese nuevamente:"); 
            caracs= input.nextLine();
        }  
        input.close();
    }
    public boolean permitido(String caracs)
    {
        return !caracs.matches("[^\\{\\}\\[\\]\\(\\)]+");
    }
    public boolean balanceado()
    {
        if(caracs.length()%2!=0)
            return false;
        else
        {
            char pc,uc;
            for(int i =0, j = caracs.length()-1;i<j;i++,j--)
            {
                pc=caracs.charAt(i);
                uc=caracs.charAt(j);
                switch(pc)
                {
                    case '{':
                        if(uc!='}')
                        {
                            return false;
                        }
                        break;

                    case '[':
                        if(uc!=']')
                        {
                            return false;
                        }
                        break;

                    case '(':
                        if(uc!=')')
                        {
                            return false;
                        }
                        break;
                    
                    default:
                            return false;
                }
            }
            return true;
    }   }

    
}
