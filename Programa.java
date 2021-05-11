import java.io.*;

public class Programa {

    public static void main(String args[]) throws Exception
    {
        ManipuladorDeArquivo tratador = new ManipuladorDeArquivo();

        System.out.println("Qual arquivo você deseja abrir? ");
        String arquivo = Teclado.getUmString();
        tratador.AbrirArquivo(arquivo);

        Matriz matriz = new Matriz(tratador.getLabirinto());
        Caminho caminho = new Caminho(tratador.acharEntrada(), matriz, tratador);

        tratador.conferirLabirinto();
        caminho.progressivo();
        caminho.inverter();
    }
}