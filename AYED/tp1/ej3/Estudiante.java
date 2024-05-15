package tp1.ej3;
public class Estudiante {
    private String nombre;
    private String apellido;
    private int comision;
    private String email;
    private String direccion;

    public String getApellido() {
        return apellido;
    }
    public int getComision() {
        return comision;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getEmail() {
        return email;
    }
    public String getNombre() {
        return nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setComision(int comision) {
        this.comision = comision;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean equals(Estudiante alumno)
    {
        if((alumno.getApellido() == this.apellido &&
        alumno.getNombre() == this.nombre &&
        alumno.getDireccion() == this.direccion &&
        alumno.getEmail() == this.email &&
        alumno.getComision() == this.comision) ||  (this == alumno) )
            return true;
        else
            return false;
    }

    public String  tusDatos()
    {
        return "nombre: "+ getNombre() +" "+ getApellido() + ", comision: "+getComision()+", email: "+getEmail()+
        "direccion: "+getDireccion();
    } 

}
