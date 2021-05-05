public class Caminho<Coordenada>
{
    private Pilha<Coordenada> caminho;
    private Pilha<Fila<Coordenada>> possibilidades;
    private Fila<Coordenada> fila;

    Matriz matriz = new Matriz();
    int capacidade = matriz.getTamanho();
    ManipuladorDeArquivo labirinto;

    public Caminho()
    {
        try
        {
            this.caminho = new Pilha<Coordenada>(capacidade);
            this.possibilidades = new Pilha<Fila<Coordenada>>(45);
            this.fila = new Fila<Coordenada>(3);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public String acharEntrada()
    {
        int ultimaLinha = labirinto.getNumLinhas();
        int ultimaColuna = labirinto.getNumColunas();

        for(int i = 0; i < labirinto.getLabirintoLength(); i++)
        {

        }

        return "a";
    }
}
