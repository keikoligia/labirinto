import java.io.*;
import java.util.*;

public class ManipuladorDeArquivo
{
    private static char labirinto[][];
    private static Stack<Character> stack = new Stack<Character>();
    private int lin;
    private int col;
    private int numLinhas;
    private int numColunas;

    public  ManipuladorDeArquivo()
    {

    }

    public void AbrirArquivo(String arquivo) throws IOException {

        String lin;
        int col = 0;
        try
        {
            FileInputStream stream = new FileInputStream(arquivo);
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader br = new BufferedReader(reader);
            String linha1 = br.readLine();
            String linha2 = br.readLine();

            numLinhas = Integer.parseInt(linha1);
            numColunas = Integer.parseInt(linha2);

            labirinto = new char[numLinhas][numColunas];

            while ((lin = br.readLine()) != null) {
                labirinto[col] = lin.toCharArray();
                col++;
            }
        }
        catch (FileNotFoundException e)
        {
            System.err.println("FileNotFound: " + e.getMessage());
        }
        catch (IOException e)
        {
            System.err.println("IOException: " + e.getMessage());
        }
    }
    public static void displayArray()
    {
        for (int x = 0; x < labirinto.length; x++)
        {
            for (int y = 0; y < labirinto[x].length; y++)
            {
                System.out.print(labirinto[x][y]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public int getTamanho()
    {
        int tamanho = 0;
        tamanho = numLinhas * numColunas;

        return tamanho;
    }

    public String getBaixo()
    {
        int linha = lin + 1;
        return "("+ linha + "," + col + ")";
    }

    public String getCima()
    {
        int linha = lin - 1;
        return "(" + linha + "," + col + ")";
    }

    public String getDireita()
    {
        int coluna = col + 1;
        return "(" + lin + "," + coluna + ")";
    }

    public String getEsquerda()
    {
        int coluna = col - 1;
        return "(" + lin + "," + coluna + ")";
    }

    public String toString ()
    {
        return "";
    }

    // equals compara this e obj
    public boolean equals (Object obj)
    {
        if(this==obj)
            return true;

        if(obj==null)
            return false;

        if(this.getClass()!=obj.getClass())
            return false;

        ManipuladorDeArquivo man = (ManipuladorDeArquivo) obj;

        return true;
    }

    public int hashCode ()
    {
        int ret=666/*qualquer positivo*/;

        return ret;
    }

    // construtor de copia
    public ManipuladorDeArquivo (ManipuladorDeArquivo modelo) throws Exception
    {
        if(modelo == null)
            throw new Exception("Modelo ausente");
    }

    public Object clone ()
    {
        ManipuladorDeArquivo ret=null;

        try
        {
            ret = new ManipuladorDeArquivo(this);
        }
        catch(Exception erro)
        {}

        return ret;
    }
}