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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private Thread d;
 
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
        this.d = new Thread(desalocacao);
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
                //if(this.cont == mp.getTamHeap()*0.5)   this.cont = 0;
        }
      //  System.out.println("\n==============HEAP===============\n");
      //  for(int i=0; i<mp.getTamHeap(); i++){
          //  System.out.println("ID = " + i + " val = " + mp.heap[i]);
       // }
        
        if(this.cont >= mp.getTamHeap()*0.5)   this.cont = 0;
       // System.out.println("\nocp heap antes = " + mp.getOcupacaoHeap());
        if(mp.getOcupacaoHeap() >= (mp.getTamHeap() * 0.5)){         
            new Thread(desalocacao).start();
            this.setCont(0);
            mp.setUltimoId(0);
            mp.setOcupacaoHeap(0);
            System.out.println("\n========== CONDIÇÃO ============");
            System.out.println("ultimo id cont = " + mp.getUltimoId());
            System.out.println("ocupacao heap cont = " + mp.getOcupacaoHeap());
            System.out.println("cont = " + cont);
        }else{
            System.out.println("=================== ALOCAÇÃO =================");
            System.out.println("ocupação antiga = " + mp.getOcupacaoHeap());
            System.out.println("cont = " + cont);
            mp.setUltimoId(cont);
            System.out.println("novo ultimo id = " + mp.getUltimoId());
            System.out.println("\n\n");
        }
    }
    
    private Runnable desalocacao = new Runnable() {   
        @Override
        public void run() {
            try {
                dh.desalocadorHeap(mp);
            } catch (InterruptedException ex) {
                Logger.getLogger(Alocador.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("bugg thread");
            }
            Thread.interrupted();
        }
    };
    
    public void desalocar() {           
        if(mp.tabHeap[(int) (mp.getTamHeap()*0.5)][0] != 0){
            System.out.println("entrou alcançou limear");
            new Thread(desalocacao).start(); 
        }
    }

    public int getCont() {
        return cont;
    }

    public mapeamentoHeap getMp() {
        return mp;
    }

    public void setCont(int cont) {
        this.cont = cont;
    } 
    
}
