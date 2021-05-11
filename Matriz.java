public class Matriz
{
    private int numLinhas;
    private int numColunas;
    private int lin;
    private int col;
    private char[][] labirinto;

    public Matriz(char[][] lab)
    {
        this.labirinto = lab;
    }

    public Matriz(){ }

    public char getBaixo(Coordenada coord) throws Exception
    {
        try
        {
            lin = coord.getX();
            col = coord.getY();
        }
        catch (Exception erro)
        {
            System.out.println("erro no método getBaixo");
        }
        return labirinto[lin + 1][col];
    }

    public char getCima(Coordenada coord) throws Exception
    {
        try
        {
            lin = coord.getX();
            col = coord.getY();
        }
        catch (Exception erro)
        {
            System.out.println("erro no método getCima");
        }
        return labirinto[lin - 1][col];
    }

    public char getDireita(Coordenada coord) throws Exception
    {
        try
        {
            lin = coord.getX();
            col = coord.getY();
        }
        catch (Exception erro)
        {
            System.out.println("erro no método getDireita");
        }
        return labirinto[lin][col + 1];

    }

    public char getEsquerda(Coordenada coord) throws Exception
    {
        try
        {
            lin = coord.getX();
            col = coord.getY();
        }
        catch (Exception erro)
        {
            System.out.println("erro no método getEsquerda");
        }        
        return labirinto[lin][col - 1];
    }

    public void marcar(int linha, int coluna) throws Exception
    {
        if(labirinto[linha][coluna] != ' ')
            throw new Exception ("parâmetro incorreto no metodo marcar " + linha + " ," + coluna);
        else
            labirinto[linha][coluna] = '*';
    }

    public void desmarcar(int linha, int coluna) throws Exception
    {
        if(labirinto[linha][coluna] != '*')
            throw new Exception ("parâmetro incorreto no metodo desmarcar " + linha + " ," + coluna);
        else
            labirinto[linha][coluna] = ' ';
    }

    public boolean equals(Object obj) 
    {
        if(this==obj)
            return true;

        if(obj==null)
            return false;

        if(this.getClass()!=obj.getClass())
            return false;

        Matriz mat = (Matriz) obj;

        if(this.numColunas != mat.numColunas)
            return false;

        if(this.numLinhas != mat.numLinhas)
            return false;

        if(this.col != mat.col)
            return false;

        if(this.lin != mat.lin)
            return false;

        if(this.labirinto != mat.labirinto)
            return false;

        return true;
    }
    public int hashcode()
    {
        int ret = 6;

        try
        {
            ret = ret * 7 + new Integer(this.numLinhas).hashCode();
            ret = ret * 7 + new Integer(this.numColunas).hashCode();
            ret = ret * 7 + new Integer(this.lin).hashCode();
            ret = ret * 7 + new Integer(this.col).hashCode();
            ret = ret * 7 + new Matriz(this.labirinto).hashCode();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        if (ret<0) ret =- ret;

        return ret;
    }

    public Matriz (Matriz modelo) throws Exception
    {
        if(modelo == null)
            throw new Exception("Modelo ausente");

        this.numLinhas = modelo.numLinhas;
        this.numColunas = modelo.numColunas;
        this.lin = modelo.lin;
        this.col = modelo.col;
        this.labirinto = modelo.labirinto;
    }
    public Object clone ()
    {
        Matriz ret = null;

        try
        {
            ret = new Matriz(this);
        }
        catch(Exception erro)
        {}

        return ret;
    }
}
