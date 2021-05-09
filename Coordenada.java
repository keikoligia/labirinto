public class Coordenada
{
    private int linha;
    private int coluna;

    public Coordenada(int x, int y)
    {
        this.linha = x;
        this.coluna = y;
    }
/*
    public Coordenada(char coordenada)
    {
        linha = coordenada;
        coluna = coordenada[0][1];
    }*/

    public Coordenada()
    {

    }

    public int getX() { return linha; }

    public int getY(){
        return coluna;
    }

    public String toString()
    {
        return "(" + String.valueOf(linha) + "," + String.valueOf(coluna) + ")";
    }
}
