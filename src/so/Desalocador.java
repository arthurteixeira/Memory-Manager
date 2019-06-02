/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

/**
 *
 * @author casa
 */
public class Desalocador {
    
    private int calcId;
    
    void desalocadorHeap(mapeamentoHeap mp){
        calcId = mp.getUltimoId() - mp.getConstDesalocacao();
        for(int i = 0; i < mp.getTamHeap(); i++){
            if(mp.tabHeap[i][1] == 1){
                if(mp.tabHeap[i][0] < calcId){
                    mp.tabHeap[i][1] = 0;
                    mp.setOcupacaoHeap(mp.getOcupacaoHeap() - 1);
                }
            }
        }   
    }
    
}
