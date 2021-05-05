public class Caminho <Coordenada>
{
    private Pilha<Coordenada> caminho;
    private Pilha<Fila<Coordenada>> possibilidades;
    private Fila<Coordenada> fila;

    ManipuladorDeArquivo labirinto = new ManipuladorDeArquivo();
    int capacidade = labirinto.getTamanho();
/*
    public Caminho()
    {
        this.caminho = new Pilha<Coordenada>(capacidade);
        this.possibilidades = new Pilha<Fila<Coordenada>>(45);
        this.fila = new Fila<Coordenada>(3);
    }
*/

}
