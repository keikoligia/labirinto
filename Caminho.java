public class Caminho extends Coordenada
{
    private Pilha<Coordenada> caminho;
    private Pilha<Fila<Coordenada>> possibilidades;
    private Fila<Coordenada> fila;
    private Pilha<Coordenada> inverso;
    private Coordenada atual;

    private boolean inicio = true;
    private ManipuladorDeArquivo arquivo = new ManipuladorDeArquivo();
    private Matriz matriz;

    int capacidade;

    public Caminho(Coordenada coord, Matriz labirinto, ManipuladorDeArquivo arq)
    {
        try
        {
            this.arquivo = arq;
            capacidade = arquivo.getTamanho();
            this.atual = coord;
            this.caminho = new Pilha<Coordenada>(capacidade);
            this.possibilidades = new Pilha<Fila<Coordenada>>(capacidade);
            this.fila = new Fila<Coordenada>(3);
            this.inverso = new Pilha<Coordenada>(capacidade);
            this.matriz = labirinto;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void inverter() throws Exception
    {
        while(!caminho.isVazia())
        {
            inverso.guardeUmItem(caminho.recupereUmItem());
            caminho.removaUmItem();
        }
        while (!inverso.isVazia())
        {
            System.out.print(inverso + ", ");
            inverso.removaUmItem();
        }
    }

    public void progressivo()
    {
        try {
            for(;;)
            {
                if( matriz.getBaixo(atual) == ' ' || matriz.getBaixo(atual) == 'S' )
                    fila.guardeUmItem(new Coordenada(atual.getX() + 1, atual.getY()));

                if(atual.getX() > 0)
                {
                    if( matriz.getCima(atual) == ' ' || matriz.getCima(atual) == 'S')
                        fila.guardeUmItem(new Coordenada(atual.getX() - 1, atual.getY()));
                }

                if(atual.getY() > 0)
                {
                    if( matriz.getEsquerda(atual) == ' ' || matriz.getEsquerda(atual) == 'S')
                        fila.guardeUmItem(new Coordenada(atual.getX(), atual.getY() - 1));
                }

                if( atual.getY() < arquivo.getNumColunas())
                {
                    if( matriz.getDireita(atual) == ' ' || matriz.getDireita(atual) == 'S'  )
                        fila.guardeUmItem(new Coordenada(atual.getX(), atual.getY() + 1));
                }

                if(fila.isVazia())
                    regressivo();

                atual = fila.recupereUmItem();
                fila.removaUmItem();
                matriz.marcar(atual.getX(), atual.getY());
                caminho.guardeUmItem(atual);
                possibilidades.guardeUmItem(fila);
                fila = new Fila<Coordenada>(capacidade);

                if( matriz.getBaixo(atual) ==    'S'||
                    matriz.getCima(atual) ==     'S'||
                    matriz.getDireita(atual) ==  'S'||
                    matriz.getEsquerda(atual) == 'S'
                )
                    break;
            }
            inverter();
        }
        catch (Exception erro)
        {
            System.out.println("Sem solução");
        }
    }

    public void regressivo() throws Exception {
        while(fila.isVazia())
        {
            try
            {
                this.atual = caminho.recupereUmItem();
                caminho.removaUmItem();
                this.fila = possibilidades.recupereUmItem();
                possibilidades.removaUmItem();
                matriz.desmarcar(atual.getX(), atual.getY());
            }
            catch(Exception erro)
            {
                System.out.println("Impossível utilizar o modo regressivo.");
            }
        }
    }
    
    public boolean equals(Object obj)
    {
        if(this==obj)
            return true;

        if(obj==null)
            return false;

        if(this.getClass()!=obj.getClass())
            return false;

        Caminho cam = (Caminho) obj;

        if(this.atual!=cam.atual)
            return false;

        if(this.fila!=cam.fila)
            return false;

        if(this.possibilidades!=cam.possibilidades)
            return false;

        if(this.caminho!=cam.caminho)
            return false;

        if(this.inverso!=cam.inverso)
            return false;

        return true;
    }

    public int hashCode()
    {
        int ret = 6;

        try
        {
            ret = ret * 7 + new Coordenada(this.atual).hashCode();
            ret = ret * 7 + new Pilha<Fila<Coordenada>>(this.possibilidades).hashCode();
            ret = ret * 7 + new Pilha<Coordenada>(this.caminho).hashCode();
            ret = ret * 7 + new Fila<Coordenada>(this.fila).hashCode();
            ret = ret * 7 + new Pilha<Coordenada>(this.inverso).hashCode();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        if (ret<0) ret =- ret;

        return ret;
    }

    public Caminho (Caminho modelo) throws Exception
    {
        if(modelo == null)
            throw new Exception("Modelo ausente");

        this.atual = modelo.atual;
        this.fila = modelo.fila;
        this.caminho = modelo.caminho;
        this.possibilidades = modelo.possibilidades;
    }

    public Object clone ()
    {
        Caminho ret = null;

        try
        {
            ret = new Caminho(this);
        }
        catch(Exception erro)
        {}

        return ret;
    }
}
