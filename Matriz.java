public class Matriz
{
    private int numLinhas;
    private int numColunas;
    private int lin;
    private int col;

    public int getTamanho()
    {
        int tamanho = 0;
        tamanho = numLinhas * numColunas;

        return tamanho;
    }

    public String getBaixo()
    {
        return "("+ Integer.parseInt(String.valueOf(lin+1)) + "," + col + ")";
    }

    public String getCima()
    {
        return "(" + Integer.parseInt(String.valueOf(lin-1)) + "," + col + ")";
    }

    public String getDireita()
    {
        return "(" + lin + "," + Integer.parseInt(String.valueOf(col+1)) + ")";
    }

    public String getEsquerda()
    {
        return "(" + lin + "," + Integer.parseInt(String.valueOf(col-1)) + ")";
    }
}
