/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paralelo;

import HeapSequencial.*;
import Interface.Interface;
import Interface.InterfaceParalela;
import java.util.Random;
import java.util.concurrent.Semaphore;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author casa
 */
public class Alocador {
    
    private int tamRestante;
    private InterfaceParalela jan;
    private mapeamentoHeap mp;
    public  Desalocador dh;
    private String  heapAloca;
    private int     cont;
    public  DefaultTableModel mtHeap;
    public  DefaultTableModel mtContHeap;
    private Semaphore mutex;
    
    
    public Alocador(InterfaceParalela jan, mapeamentoHeap mp){
        this.mp = mp;
        this.jan = jan;
        this.heapAloca = "";
        this.dh = new Desalocador(jan);
        this.jan.tHeap.removeAll();
        this.jan.tContHeap.removeAll();
        this.mtContHeap = (DefaultTableModel) this.jan.tContHeap.getModel();
        this.mtHeap = (DefaultTableModel) this.jan.tHeap.getModel();
        this.cont = 0;
        this.mutex = new Semaphore(1);
    }

    public String getHeapAloca() {
        return heapAloca;
    }
    
    void alocaHeap(Requisicao nova) throws InterruptedException{
        Random random = new Random();
        this.tamRestante = nova.getTamanho();
        this.heapAloca +=   "Requisição " + nova.getIdentificador() + " com tamanho de " + nova.getTamanho() + 
                            " foi alocada nas seguintes posições da heap: \n";
        //System.out.println(" foi alocada nas seguintes posições da heap: \n" + 
        //        "Requisição " + nova.getIdentificador() + " com tamanho de " + nova.getTamanho());
        this.cont = mp.getUltimoId();
        while(this.tamRestante != 0){
                if(mp.tabHeap[cont][1] == 0){
                    this.tamRestante--;
                    mp.setOcupacaoHeap(mp.getOcupacaoHeap() + 1);
                    mp.tabHeap[cont][1] = 1;
                    mp.tabHeap[cont][0] = nova.getIdentificador();
                    mp.tabHeap[cont][2] = this.tamRestante;
                    this.heapAloca += "Posição " + cont + "\n";
                    mp.heap[cont] = random.nextInt(99999999);
                }
                cont++;

                if(this.cont == mp.getTamHeap())   this.cont = 0;
                if(this.cont == mp.getUltimoId())   dh.desalocadorHeap(mp);
        }
        //System.out.println("\n\n=====================HEAP==================\n");
        //System.out.println(heapAloca);
        
        new Thread(desalocacao).start();
  
    }
    
    private Runnable desalocacao = new Runnable() {   
        @Override
        public void run() {
            mp.setUltimoId(cont);
            if(mp.getOcupacaoHeap() >= (mp.getTamHeap() * mp.getLimiarMax())){
                dh.desalocadorHeap(mp);
            }
            mp.setOcupacaoHeap(mp.getOcupacaoHeap() + 1);
            
        }
    };
    
}
