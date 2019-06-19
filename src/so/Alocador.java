/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import java.util.Random;

/**
 *
 * @author casa
 */
public class Alocador {
    
    private int tamRestante;
    private Interface jan;
    private mapeamentoHeap mp;
    private Desalocador dh;
    private String  heapAloca;
    
    public Alocador(Interface jan, mapeamentoHeap mp){
        this.mp = mp;
        this.jan = jan;
        //this.dh = new Desalocador(jan);
    }
    
    void alocaHeap(Requisicao nova){
        Random random = new Random();
        this.tamRestante = nova.getTamanho();
        this.heapAloca = "";
        this.heapAloca +=   "Requisição " + nova.getIdentificador() + " com tamanho de " + nova.getTamanho() + 
                            " foi alocada nas seguintes posições da heap: \n";
        while(this.tamRestante != 0){
            for(int i = 0; i < mp.getTamHeap(); i++){
                if(mp.tabHeap[i][1] == 0){
                    this.tamRestante--;
                    mp.tabHeap[i][1] = 1;
                    mp.tabHeap[i][0] = nova.getIdentificador();
                    mp.tabHeap[i][2] = this.tamRestante;
                    this.heapAloca += "Posição " + i + "\n";
                    mp.heap[i] = random.nextInt(100000000);
                }
                if(this.tamRestante == 0)   break;
            }
            if(this.tamRestante != 0)   dh.desalocadorHeap(mp);
        }
        
        if(mp.getOcupacaoHeap() >= (mp.getTamHeap() * (mp.getLimiarMax() / 100))){
            dh.desalocadorHeap(mp);
        }
        mp.setOcupacaoHeap(mp.getOcupacaoHeap() + 1);
        
        //impressao
        String val;
        for(int i = 0; i < mp.heap.length; i++){
            val = "" + mp.heap[i];
            atualiza.atualizarHeap(val, i);
        }
        String info1, info2, info3;
        for(int i = 0; i < mp.tabHeap.length; i++){
            info1 = "" + mp.tabHeap[i][0];
            info2 = "" + mp.tabHeap[i][1];
            info3 = "" + mp.tabHeap[i][2];
            atualiza.atualizarTab(info1, info2, info3, i);
        }
        
    }
    
}
