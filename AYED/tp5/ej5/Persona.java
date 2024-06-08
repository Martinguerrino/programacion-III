package tp5.ej5;

public class Persona 
{
    String nombre;
    String domicilio;
    String puesto;
    boolean cobro;

    public Persona(String nombre, String domicilio, String puesto, boolean cobro)
    {
        this.nombre=nombre;
        this.domicilio=domicilio;
        this.puesto=puesto;
        this.cobro= cobro;
    }
    public String getDomicilio() {
        return domicilio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public String getPuesto() {
        return puesto;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    public void setCobro(boolean cobro) {
        this.cobro = cobro;
    }
    public boolean getCobro()
    {
        return cobro;
    }
    
}
