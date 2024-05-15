package tp1.ej3;

public class Profesor {
    private String nombre;
    private String apellido;
    private int catedra;
    private String email;
    private String facultad;

    public String getApellido() {
        return apellido;
    }
    public int getCatedra() {
        return catedra;
    }
    public String getEmail() {
        return email;
    }
    public String getFacultad() {
        return facultad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setCatedra(int catedra) {
        this.catedra = catedra;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String  tusDatos()
    {
        return "nombre: "+ getNombre() +" "+ getApellido() + ", facultad: "+getFacultad()+", email: "+getEmail()+
        "catedra: "+getCatedra();
    } 


}
