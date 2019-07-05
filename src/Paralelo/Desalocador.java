/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paralelo;

import HeapSequencial.*;
import Interface.Interface;
import Interface.InterfaceParalela;
import java.util.concurrent.Semaphore;

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
    
    void desalocadorHeap(mapeamentoHeap mp) throws InterruptedException{      
    this.logDesaloca += "Foram desalocados:\n";
        for(int i = 0; i < mp.getTamHeap(); i++){ 
            this.logDesaloca += "ID " + mp.tabHeap[i][0] + " desalocado da posição " + i + "\n";
            mp.tabHeap[i][1] = 0;
            mp.tabHeap[i][0] = 0;
            //desaloca td a heap
        }
    }

    public String getLogDesaloca() {
        return logDesaloca;
    }
    
}
