import java.io.*;

public class ManipuladorDeArquivo
{
    public void AbrirArquivo(String arquivo) throws IOException {
        FileInputStream stream = new FileInputStream(arquivo);
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(reader);
        String linha1 = br.readLine();
        String linha2 = br.readLine();

        int linhasMatriz = Integer.parseInt(linha1);
        int colunasMatriz = Integer.parseInt(linha2);

        String matriz[][] = new  String[linhasMatriz][colunasMatriz];

        String [] vetorArquivo ={"1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45"};
        int cont = 0;
        for(int col=0; col<matriz.length; col++ )
        {
            for(int lin = 0; lin <matriz.length; lin++)
            {
                matriz[lin][col] = vetorArquivo[cont];
                cont++;
            }
        }

        /*
        //Exibindo Valores
        for (int col = 0; col < matriz.length; col++) {
            for (int lin = 0; lin < matriz.length; lin++) {
                System.out.print(matriz[lin][col] + "\t");
            }
            System.out.println("");
        }*/
    }
}
