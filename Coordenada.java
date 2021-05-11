public class Coordenada
{
    private int linha;
    private int coluna;

    public Coordenada(int x, int y)
    {
        this.linha = x;
        this.coluna = y;
    }

    public Coordenada() { }

    public Coordenada(Coordenada atual) { }

    public int getX() { return linha; }

    public int getY(){ return coluna; }

    public int hashCode()
    {
        int ret = 6;

        try
        {
            ret = ret * 7 + new Integer(this.linha).hashCode();
            ret = ret * 7 + new Integer(this.coluna).hashCode();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        if (ret<0) ret =- ret;

        return ret;
    }

    public String toString()
    {
        return "(" + String.valueOf(linha) + "," + String.valueOf(coluna) + ")";
    }

    public boolean equals(Object obj)
    {
        if(this==obj)
            return true;

        if(obj==null)
            return false;

        if(this.getClass()!=obj.getClass())
            return false;

        Coordenada coord = (Coordenada) obj;

       if(this.linha != coord.linha || this.coluna != coord.coluna)
            return false;

        return true;
    }
}
