package so;

import java.util.Scanner;

public class SO {
    private static int id = 0;
    public static void main(String[] args) {
        int tamanho;
  
        Scanner input = new Scanner(System.in);
        
        System.out.println("Informe tamanho do vetor de requisições:");
        tamanho = input.nextInt();
        
        FilaCircular fila = new FilaCircular(tamanho);   
        adicionarRequisicao(fila);
        adicionarRequisicao(fila);
        adicionarRequisicao(fila);
        
        Requisicao sair = fila.removerElemento();
        System.out.println("Removido. \nID: " + sair.getIdentificador() + "TAMANHO: " + sair.getTamanho());
        Requisicao sair2 = fila.removerElemento();
        System.out.println("Removido. \nID: " + sair2.getIdentificador() + "TAMANHO: " + sair2.getTamanho());
        
        adicionarRequisicao(fila);
        
        Requisicao sair3 = fila.removerElemento();
        System.out.println("Removido. \nID: " + sair3.getIdentificador() + "TAMANHO: " + sair3.getTamanho());
    }
    
    public static void adicionarRequisicao(FilaCircular fila){
        id++;
        fila.addElemento(id); 
    }    
}
