package Paralelo;

import HeapSequencial.*;
import Interface.Interface;
import Interface.InterfaceParalela;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public final class FilaCircular{
    private Requisicao[] fila;          //Vetor de requisições p/ implementação da fila
    private int inicio;                 //Aponta p/ inicio da fila
    private int fim;                    //Aponta p/ o fim da filla
    private int numeroElementos;        //Num. de elementos na fila
    private int idReq = 0;              //ID das requisições, usado p/ gerar as requisições
    private int maximoReq;              //Valor máximo das requisições
    private int minimoReq;              //Valor mínimo das requisições
    private mapeamentoHeap mp;           //Cria objeto da heap
    private InterfaceParalela jan;         //Cria objeto p/ atualização das tabelas na interface
    private Alocador alocador;
    private int tam;
    private int contador;
    public  String logFila = "";  
    DefaultTableModel mtReq; 
    private Semaphore mutex;
    private int estado;
    private long tempInicial;
    private long tempFinal;
    
    public FilaCircular(int tamanho, int minimo, int maximo, mapeamentoHeap mp, InterfaceParalela jan){
        this.fila = new Requisicao[tamanho];
        this.tam = this.contador = tamanho;
        this.inicio = 0;
        this.fim = 0;
        this.numeroElementos = 0;
        this.maximoReq = maximo;
        this.minimoReq = minimo;
        this.jan = jan;
        this.mp = mp;
        this.jan.tReq.removeAll();
        this.mtReq = (DefaultTableModel) this.jan.tReq.getModel();
        this.logFila = "";      
        this.alocador = new Alocador(jan, mp);
        this.tempInicial = System.currentTimeMillis();
        new Thread(t1).start();
        this.mutex = new Semaphore(1);
        this.estado = 0;      
    }
    
    private Runnable t1 = new Runnable() {   
        @Override
        public void run() {
            for(int i = 0; i < fila.length; i++){   
                addElemento(gerarRequisicao());
            }
            new Thread(removerElemento).start();
            //new Thread(removerElemento).start();
            //new Thread(desalocar).start();
        }
    };
    
    private Runnable removerElemento = new Runnable() {   
        @Override
        public void run() {
            while(!filaVazia()){
                Requisicao requisicao = fila[inicio++];
                if(inicio == fila.length){
                    inicio = 0; 
                }
                try {
                    mutex.acquire();
                } catch (InterruptedException ex) {
                    Logger.getLogger(FilaCircular.class.getName()).log(Level.SEVERE, null, ex);
                }
                contador--;
                numeroElementos--;       
                try {
                    alocador.alocaHeap(requisicao);         //Manda a requisicao requisição na heap               
                } catch (InterruptedException ex) {
                    Logger.getLogger(FilaCircular.class.getName()).log(Level.SEVERE, null, ex);   
                }
                mutex.release();
            }
            try {
                mutex.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(FilaCircular.class.getName()).log(Level.SEVERE, null, ex);
            }
            atualizarTables();
            tempFinal = System.currentTimeMillis();
            long dif = (tempFinal - tempInicial);
            System.out.println(String.format("%d em Minutos | %d em Segundos | %d em Milisegundos", dif/60000, dif/1000, dif));
            mutex.release();      
            Thread.interrupted();
        }
    };
    
    public void atualizarTables(){
        this.jan.txtLogFila.setText(logFila);
        for(int i = 0; i < mp.tabHeap.length; i++){
            alocador.mtHeap.addRow(new Integer[]{i, mp.heap[i]});
            alocador.mtContHeap.addRow(new Integer[]{i, mp.tabHeap[i][0], mp.tabHeap[i][1], mp.tabHeap[i][2]});
        }
        for(int i = 0; i < fila.length; i++){
            mtReq.addRow(new Integer[]{fila[i].getIdentificador(), fila[i].getTamanho()});
        }
        jan.txtLogHeapAloca.setText(alocador.getHeapAloca());
        jan.txtLogHeapDesaloca.setText(alocador.dh.getLogDesaloca());
    }
    private boolean filaCheia(){
        return numeroElementos == fila.length;           //Verifica se a fila está cheia;
    }
    
    private boolean filaVazia(){
        return numeroElementos == 0;                     //Verifica se a fila está vazia.
    }
    
    public void addElemento(Requisicao objeto){          //Adiciona elementos na fila
        if(!filaCheia()){
            fila[fim++] = objeto;
            numeroElementos++;
            if(fim == fila.length)
                fim = 0;
            this.logFila += "Requisição Criada, ID: " + objeto.getIdentificador() + ", Tamanho: " + objeto.getTamanho() + "\n";    
        }        
    }
    
    public int getMaximoReq() {
        return maximoReq;
    }

    public int getMinimoReq() {
        return minimoReq;
    }
    
    public Requisicao gerarRequisicao() {                //Função que gera as requisições
        Random random = new Random();
        int tReq = 0;
        do{
            tReq = random.nextInt(this.maximoReq - this.minimoReq);
        }while(tReq == 0);
        tReq += this.minimoReq;
        Requisicao nova = new Requisicao(idReq, tReq);
        idReq++;
        return nova;
    }

    public void impressao(){                            //Função que manda os parametros p/ atualizar as tabelas na classe principal
        String id, tam;
        for(int i = 0; i < fila.length; i++){
            id = "" + fila[i].getIdentificador();
            tam = "" + fila[i].getTamanho();
            //atualiza.atualizarReq(id, tam, i);
        }
    }
}
