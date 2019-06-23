/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paralelo;

import HeapSequencial.*;
import Interface.Interface;
import Interface.InterfaceParalela;

/**
 *
 * @author casa
 */
public class Desalocador {
    
    private float calcId;
    private InterfaceParalela jan;
    private String  logDesaloca;
    
    public Desalocador(InterfaceParalela jan){
        this.jan = jan;
        this.logDesaloca = "";
    }
    
    void desalocadorHeap(mapeamentoHeap mp){
        calcId = (float) (mp.getUltimoId() * 0.4);
        this.logDesaloca += "Foram desalocados:\n";
        for(int i = 0; i < mp.getTamHeap(); i++){
            if(mp.tabHeap[i][0] < calcId){
                if(mp.tabHeap[i][1] == 1){
                    mp.tabHeap[i][1] = 0;
                    this.logDesaloca += "ID " + mp.tabHeap[i][0] + " desalocado da posição " + i + "\n";
                    mp.setOcupacaoHeap(mp.getOcupacaoHeap() - 1);
                }
            }
        }
    }

    public String getLogDesaloca() {
        return logDesaloca;
    }
    
}
