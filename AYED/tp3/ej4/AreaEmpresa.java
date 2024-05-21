package tp3.ej4;

public class AreaEmpresa 
{
    String id;
    int tardanza;

    public AreaEmpresa(String id,int tardanza)
    {
        this.id=id;
        this.tardanza=tardanza;
    }
    public String getId() 
    {
        return id;
    }
    public int getTardanza() 
    {
        return tardanza;
    }
    public void setId(String id) 
    {
        this.id = id;
    }
    public void setTardanza(int tardanza) 
    {
        this.tardanza = tardanza;
    }
}
