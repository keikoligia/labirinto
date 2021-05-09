import java.io.*;

public class Programa {

    public static void main(String args[]) throws Exception {

        System.out.println("Qual arquivo você deseja abrir? ");
        String arquivo = Teclado.getUmString();

        ManipuladorDeArquivo abriu = new ManipuladorDeArquivo();
        Matriz matriz = new Matriz(abriu.getLabirinto());
        //Caminho caminho = new Caminho(abriu.acharEntrada());

        abriu.AbrirArquivo(arquivo);
        abriu.displayArray();
        matriz.mark(2, 2);



    }
}