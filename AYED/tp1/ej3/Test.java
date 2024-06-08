package tp1.ej3;

public class Test 
{       
    public static void main(String[] args) 
        {  
            Estudiante [] estudiantes = {new Estudiante(), new Estudiante()};
            Profesor [] profesores = {new Profesor(), new Profesor(), new Profesor()};
            estudiantes[0].setNombre("Juan");
            estudiantes[0].setApellido("Perez");
            estudiantes[0].setComision(1);
            estudiantes[0].setEmail("juan@example.com");
            estudiantes[0].setDireccion("Calle 123");
        
            estudiantes[1].setNombre("Maria");
            estudiantes[1].setApellido("Gomez");
            estudiantes[1].setComision(2);
            estudiantes[1].setEmail("maria@example.com");
            estudiantes[1].setDireccion("Calle 456");

            profesores[0].setNombre("Pedro");
            profesores[0].setApellido("Gonzalez");
            profesores[0].setCatedra(2);
            profesores[0].setEmail("pedro@example.com");
            profesores[0].setFacultad("Facultad de Ciencias");

            profesores[1].setNombre("Ana");
            profesores[1].setApellido("Martinez");
            profesores[1].setCatedra(3);
            profesores[1].setEmail("ana@example.com");
            profesores[1].setFacultad("Facultad de Ingeniería");

            profesores[2].setNombre("Carlos");
            profesores[2].setApellido("Lopez");
            profesores[2].setCatedra(1);
            profesores[2].setEmail("carlos@example.com");
            profesores[2].setFacultad("Facultad de Letras");
    
    
        for(Profesor profesor: profesores)
        {
            System.out.println(profesor.tusDatos());
        }
        for(Estudiante estudiante: estudiantes){
            System.out.println(estudiante.tusDatos());
        }
        }
}
