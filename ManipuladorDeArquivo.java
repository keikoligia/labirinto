import java.io.*;
import java.util.*;

public class ManipuladorDeArquivo
{
    private char labirinto[][];
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

    public int getTamanho()
    {
        int tamanho = 0;
        tamanho = numLinhas * numColunas;

        return tamanho;
    }

    public int getLabirintoLength() { return labirinto.length; }

    public int getNumLinhas() { return numLinhas; }

    public int getNumColunas() { return numColunas; }

    public char[][] getLabirinto() { return labirinto; }

    public void displayArray()
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

    public Coordenada acharEntrada() throws Exception
    {
        Coordenada coordenadaEntrada = null; //corrigir dps
    try
    {
        for1 : for (int x = 0; x < labirinto.length; x++)
        {
            for (int y = 0; y < labirinto[x].length; y++)
            {
                if(labirinto[x][y] == 'E')
                {
                    coordenadaEntrada = new Coordenada(x, y);
                    break for1;
                }
            }
        }
    }
    catch(Exception erro)
    { }
        return coordenadaEntrada;
    }

    public void conferirLabirinto()
    {
        byte qntsE = 0;
        byte qntsS = 0;

        try
        {
            for (int x = 0; x < labirinto.length; x++)
            {
                for (int y = 0; y < labirinto[x].length; y++)
                {
                    if (labirinto[x][y] == 'E')
                        qntsE++;

                    if (labirinto[x][y] == 'S')
                        qntsS++;
                }
            }

            if (qntsE != 1)
            {
                System.out.println("O labirinto possui estrutura errada.");
                System.exit(0);
            }
            if (qntsS != 1)
            {
                System.out.println("O labirinto possui estrutura errada.");
                System.exit(0);
            }
        }
        catch(Exception ex)
        { System.out.println("Labirinto danificado.");}
    }

    public String toString ()
    {
        return "";
    }

    public int hashCode()
    {
        int ret = 6;

        ret = ret * 7 + new Integer(lin).hashCode();
        ret = ret * 7 + new Integer(col).hashCode();
        ret = ret * 7 + new Integer(numColunas).hashCode();
        ret = ret * 7 + new Integer(numLinhas).hashCode();

        for (int x = 0; x < labirinto.length; x++)
        {
            for (int y = 0; y < labirinto[x].length; y++)
            {
                ret = ret * 7 + new Character(labirinto[x][y]).hashCode();
            }
        }

        if (ret<0) ret =- ret;

        return ret;
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