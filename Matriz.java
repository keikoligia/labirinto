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

    public int getTamanho()
    {
        int tamanho = 0;
        tamanho = numLinhas * numColunas;

        return tamanho;
    }

    public char getBaixo(Coordenada coord)
    {
        lin = coord.getX();
        col = coord.getY();
        return labirinto[lin + 1][col];
    }

    public char getCima(Coordenada coord)
    {
        lin = coord.getX();
        col = coord.getY();
        return labirinto[lin - 1][col];
    }

    public char getDireita(Coordenada coord)
    {
        lin = coord.getX();
        col = coord.getY();
        return labirinto[lin][col + 1];
    }

    public char getEsquerda(Coordenada coord)
    {
        lin = coord.getX();
        col = coord.getY();
        return labirinto[lin][col - 1];
    }

    public void marcar(int linha, int coluna) throws Exception
    {
        if(labirinto[linha][coluna] != ' ')
            throw new Exception ("parâmetro incorreto");
        else
            labirinto[linha][coluna] = '*';
    }

    public void desmarcar(int linha, int coluna) throws Exception
    {
        if(labirinto[linha][coluna] != '*')
            throw new Exception ("parâmetro incorreto");
        else
            labirinto[linha][coluna] = ' ';
    }
}
