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
    
    void alocaHeap(Requisicao nova, mapeamentoHeap mp){
        Random random = new Random();
        Desalocador dh = new Desalocador();
        this.tamRestante = nova.getTamanho();
        while(this.tamRestante != 0){
            for(int i = 0; i < mp.getTamHeap(); i++){
                if(mp.tabHeap[i][1] == 0){
                    this.tamRestante--;
                    mp.tabHeap[i][1] = 1;
                    mp.tabHeap[i][0] = nova.getIdentificador();
                    mp.tabHeap[i][2] = this.tamRestante;
                    mp.heap[i] = random.nextInt();
                }
                if(this.tamRestante == 0)   break;
            }
            if(this.tamRestante != 0)   dh.desalocadorHeap(mp);
        }
        if(mp.getOcupacaoHeap() >= (mp.getTamHeap() * (mp.getLimiarMax() / 100))){
            dh.desalocadorHeap(mp);
        }
        mp.setOcupacaoHeap(mp.getOcupacaoHeap() + 1);
    }
}
