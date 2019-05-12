package so;

import java.util.Scanner;

public class SO {
    private static int id = 0;
    public static void main(String[] args) {
        int tamanho;
        int minimo;
        int maximo;
  
        Scanner input = new Scanner(System.in);
        
        System.out.println("Informe tamanho do vetor de requisições:");
        tamanho = input.nextInt();
        System.out.println("Informe valor mínimo:");
        minimo = input.nextInt();
        System.out.println("Informe valor máximo:");
        maximo = input.nextInt();
        
        FilaCircular fila = new FilaCircular(tamanho, minimo, maximo);  
        fila.impressao();
        Requisicao g = fila.removerElemento();
        fila.impressao();

    }
}
