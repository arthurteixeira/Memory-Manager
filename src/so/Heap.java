package so;

import java.util.Random;

public class Heap {
    private int[] Heap;
    private int limiarMax;
    private Tabela[] tabela;
    private int idTabela;
    private Principal atualiza;
    
    public Heap(int tamanho, int limiarMax, Principal p){
        this.Heap = new int[tamanho];
        this.limiarMax = limiarMax;
        for(int i = 0; i < tamanho; i++)
            Heap[i] = 0;
        this.tabela = new Tabela[Heap.length];
        this.idTabela = 0;
        this.atualiza = p;
    }
        public void alocar(Requisicao nova){
        int tam = nova.getTamanho();
        int i = 0, inicio = 0;
        Random random = new Random();
        do{
            if(Heap[i] == 0 && tam > 0){
                Heap[i] = random.nextInt(1000) + 1;
                if(tam == nova.getTamanho())
                    inicio = i;
                tam--;
                if(tam == 0){
                    this.tabela[idTabela] = new Tabela(nova.getIdentificador(), nova.getTamanho(), inicio, i);
                    idTabela++;
                }
            }
            i++;
        }while(tam > 0 && i < Heap.length);
        System.out.println("\nImpressao heap:");
        this.impressao();
        System.out.println("\nImpressao tabela:");
        this.impressaoTab();
    }
    
    public void impressao(){
        String val;
        for(int i = 0; i < Heap.length; i++){
            val = "" + Heap[i];
            atualiza.atualizarHeap(val, i);
        }
    }
    
    public void impressaoTab(){
        for(int i = 0; i < idTabela; i++){
            System.out.println("Id: " + tabela[i].getId() + " Tamanho: " + tabela[i].getTamanho() + " Inicio: " + tabela[i].getInicio() + " Fim: " + tabela[i].getFim());
        }
    }
}
