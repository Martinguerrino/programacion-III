package tp1.ej7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import tp1.ej3.Estudiante;
public class TestArrayList 
{
    public static ArrayList<Estudiante> NuevosEstudiantes()
    {
        ArrayList<Estudiante> lista = new ArrayList<>();
        Estudiante alumno1 = new Estudiante();
        Estudiante alumno2 = new Estudiante();
        Estudiante alumno3 = new Estudiante();
        alumno1.setNombre("Juan");
        alumno1.setApellido("Perez");
        alumno1.setComision(1);
        alumno1.setEmail("juan@example.com");
        alumno1.setDireccion("Calle 123");


        alumno2.setNombre("Maria");
        alumno2.setApellido("Gomez");
        alumno2.setComision(2);
        alumno2.setEmail("maria@example.com");
        alumno2.setDireccion("Calle 456");


        alumno3.setNombre("Jose");
        alumno3.setApellido("paez");
        alumno3.setComision(2);
        alumno3.setEmail("jose@example.com");
        alumno3.setDireccion("Calle 136");
        lista.add(alumno1);
        lista.add(alumno2);
        lista.add(alumno3);
        return lista;
    }
    public static ArrayList<Estudiante> Copia(ArrayList<Estudiante> lista)
    {
        ArrayList<Estudiante> lista1 = new ArrayList<>();
        
        for (Estudiante estudiante : lista) 
        {
            Estudiante alumno = new Estudiante();
            alumno.setApellido(estudiante.getApellido());
            alumno.setNombre(estudiante.getNombre());
            alumno.setComision(estudiante.getComision());
            alumno.setDireccion(estudiante.getDireccion());
            alumno.setEmail(estudiante.getEmail());
            lista1.add(alumno);
        }
        return lista1;
    }
    public static void impresion(ArrayList<Estudiante> lista,ArrayList<Estudiante> lista1)
    {
        Iterator<Estudiante> iterador = lista.iterator();
        Iterator<Estudiante> iterador1 = lista1.iterator();
        System.out.println("lista original");
        while(iterador.hasNext())
        {
            System.out.println("elemento");
            System.out.println(iterador.next().tusDatos());
        }
        System.out.println("lista copia");
        while(iterador1.hasNext())
        {
            System.out.println("elemento");
            System.out.println(iterador1.next().tusDatos());
        }
    }
    public static void cambiarNombres(ArrayList<Estudiante> lista)
    {
        Iterator<Estudiante> iterador = lista.iterator();
        Scanner input = new Scanner(System.in);
        while(iterador.hasNext())
        {
            iterador.next().setNombre(input.nextLine());
        }
        input.close();
        
    }
    public static void agregarAlumno(ArrayList<Estudiante> vector)
    {   boolean esta = false;
        Estudiante alumno = new Estudiante();
        alumno.setNombre("Juan");
        alumno.setApellido("Perez");
        alumno.setComision(1);
        alumno.setEmail("juan@example.com");
        alumno.setDireccion("Calle 123");
        for ( Estudiante estudiante : vector) {
            if(estudiante.equals(alumno))
                {
                    esta=true;
                    break;
                }
        }
        if(!esta)
        {
            System.out.println("se agrega alumno");
            vector.add(alumno);
        }
        

    }
    public static void ejerciciodye()
    {
        ArrayList<Estudiante> vector1 = new ArrayList<>();
        ArrayList<Estudiante> vector2 = new ArrayList<>();
        vector1 = NuevosEstudiantes();
        vector2 = Copia(vector1);
        impresion(vector1, vector2);
        /*cambiarNombres(vector1);
        cambiarNombres(vector2);
        impresion(vector1, vector2);*/
        agregarAlumno(vector1);
        System.out.println("lista posiblemente cambiada");
        for (Estudiante estudiante : vector1) {
            System.out.println(estudiante.tusDatos());
        }
    }
    public static boolean esCapicua(ArrayList<Integer> lista)
    {   
        int izq = 0;
        int der = lista.size()-1;
        while(izq<der)
        {
            if(!(lista.get(izq)==(lista.get(der))))
            {
                return false;
            }
            izq++;
            der--;
        }
        return true;
    }
    public static void main(String[] args) 
    {   ArrayList<Integer> vector = new ArrayList<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(3);
        vector.add(3);
        vector.add(2);
        vector.add(1);
        /*int i;
        Integer n;
        ArrayList<Integer> vector = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        for(i=0;i<=2;i++)
        {
            System.out.println("ingrese numero: ");
            n=input.nextInt();
            vector.add(n);
        }
        input.close();
        for (Integer num : vector) 
        {   
            System.out.println("elemento: ");
            System.out.println(num);
        }
        vector.forEach(num ->System.out.println(num));
        */
        /*ejerciciodye();*/
        if(esCapicua(vector))
            System.out.println("es capicua");
        else
            System.out.println("no es capicua");
    }
}
