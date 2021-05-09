public class Caminho extends Coordenada
{
    private Pilha<Coordenada> caminho;
    private Pilha<Fila<Coordenada>> possibilidades;
    private Fila<Coordenada> fila;
    private  Pilha<Coordenada> inverso;
    private Coordenada atual;
    private boolean inicio = true;
    private ManipuladorDeArquivo arquivo;

    Matriz matriz;
    int capacidade = matriz.getTamanho();

    public Caminho(Coordenada coord)
    {
        try
        {
            this.atual = coord;
            this.caminho = new Pilha<Coordenada>(capacidade);
            this.possibilidades = new Pilha<Fila<Coordenada>>(capacidade);
            this.fila = new Fila<Coordenada>(3);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void progressivo()
    {
        try {
            do
            {
                if( matriz.getBaixo(atual) == ' ' || matriz.getBaixo(atual) == 'S')
                    fila = new Coordenada(matriz.getBaixo(atual)); //pegar coordenada

                /*if( matriz.getCima(atual) == ' ' || matriz.getCima(atual) == 'S')
                    fila = matriz.getCima(atual);

                if( matriz.getEsquerda(atual) == ' ' || matriz.getEsquerda(atual) == 'S')
                    fila = matriz.getEsquerda(atual);

                if( matriz.getDireita(atual) == ' ' || matriz.getDireita(atual) == 'S')
                    fila = matriz.getDireita(atual);*/

                atual = fila.recupereUmItem();

                matriz.marcar(atual.getX(), atual.getY());

                possibilidades.guardeUmItem(fila);
            }
            while(!fila.isVazia());

            if(matriz.getBaixo(atual) == 'S')
                    //fila = matriz.getBaixo(atual);

            if(matriz.getCima(atual) == 'S')
                    //fila = matriz.getCima(atual);

            if(matriz.getEsquerda(atual) == 'S')
                    //fila = matriz.getEsquerda(atual);

            if(matriz.getDireita(atual) == 'S')
                    //fila = matriz.getDireita(atual);
                possibilidades.guardeUmItem(fila);

        }
        catch (Exception erro)
        {}
    }

    public void regressivo() throws Exception {
        while(fila.isVazia())
        {
            try {
                this.atual = caminho.recupereUmItem();
                this.fila = possibilidades.recupereUmItem();
                matriz.desmarcar(atual.getX(), atual.getY());
            }
            catch(Exception erro){
                System.out.println("..."); // tratar excecao 
            }
        }
    }
}
