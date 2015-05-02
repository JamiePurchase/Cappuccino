package engine;

public class Debug
{
    private boolean active;
    
    public Debug(boolean value)
    {
        setActive(value);
    }
    
    public void setActive(boolean value)
    {
        active = value;
    }
    
    public void output(String data)
    {
        if(active) {System.out.println(data);}
    }
}