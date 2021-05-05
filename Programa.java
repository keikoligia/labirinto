import java.io.*;

public class Programa {

    public static void main(String args[]) throws IOException {

        System.out.println("Qual arquivo você deseja abrir? ");
        String arquivo = Teclado.getUmString();

        ManipuladorDeArquivo abriu = new ManipuladorDeArquivo();

        Matriz matriz = new Matriz();

        abriu.AbrirArquivo(arquivo);
        abriu.displayArray();

        System.out.println(abriu.getNumLinhas());
        System.out.println(matriz.getBaixo());
        
    }
}