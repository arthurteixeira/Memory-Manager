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
        this.tamRestante = nova.getTamanho(); //Tamanho restante das requisições (começa como o tamanho da req.)
        //Log da heap
        this.heapAloca +=   "Requisição " + nova.getIdentificador() + " com tamanho de " + nova.getTamanho() + 
                            " foi alocada nas seguintes posições da heap: \n";
        this.cont = mp.getUltimoId(); //Seta o contador
        while(this.tamRestante != 0){ //Enquanto o tam não é zero
                if(mp.tabHeap[cont][1] == 0){ //ve se o bit de val. é 0
                    this.tamRestante--; //Diminui o tam.restante
                    mp.setOcupacaoHeap(mp.getOcupacaoHeap() + 1); //aumentar o num de ocupação da heap
                    mp.tabHeap[cont][1] = 1; //Seta em 1 o bit de validade
                    mp.tabHeap[cont][0] = nova.getIdentificador(); //Coloca id da req, na tab da heap
                    mp.tabHeap[cont][2] = this.tamRestante; //Coloca o tam restante na tab da heap
                    //Log da heap
                    this.heapAloca += "Posição " + cont + "\n";
                    mp.heap[cont] = random.nextInt(99999999); //Preenche heap com valor random
                }
                cont++;
        }
        if(this.cont >= mp.getTamHeap()*mp.getLimiarMax())   this.cont = 0; //Se cont passou do limiar, seta o cont com 0
        if(mp.getOcupacaoHeap() >= (mp.getTamHeap() * mp.getLimiarMax())){ //ve se a heap passou do limiar   
            new Thread(desalocacao).start(); //cria thread de desalocacao
            System.out.println("limiar");
            this.setCont(0);
            mp.setUltimoId(0);
            mp.setOcupacaoHeap(0);
            //seta valores p zero
        }else{
            mp.setUltimoId(cont);  //Seta o ultimo id alocado, com o valor do cont
        }
    }
    
    private Runnable desalocacao = new Runnable() {   
        @Override
        public void run() {
            try {
                dh.desalocadorHeap(mp); //desaloca
            } catch (InterruptedException ex) {
                Logger.getLogger(Alocador.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("bugg thread");
            }
            Thread.interrupted();
        }
    };

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
