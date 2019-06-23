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

public final class FilaCircular implements Runnable {
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
    
    public FilaCircular(int tamanho, int minimo, int maximo, mapeamentoHeap mp, InterfaceParalela jan){
        this.fila = new Requisicao[100];
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
        //Gera todas as requisições iniciais
        //System.out.println(this.minimoReq + "," + this.maximoReq);
        
        Thread t = new Thread(this);     
        t.start();
    }
    
    @Override
    public void run(){
        while(this.contador >= 0){
            addElemento(gerarRequisicao());
            if(fila.length > 50 || filaCheia())  this.removerElemento();
        }
        this.jan.txtLogFila.setText(logFila);
        for(int i = 0; i < mp.getTamHeap(); i++){
            alocador.mtHeap.addRow(new Integer[]{i, this.mp.heap[i]});
            alocador.mtContHeap.addRow(new Integer[]{i,this.mp.tabHeap[i][0], this.mp.tabHeap[i][1], this.mp.tabHeap[i][2]});
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
            //System.out.println("Requisição entrou no vetor de requisições." + this.contador);
            
        }/*else{
            System.out.println("Requisição NÃO entrou no vetor de requisições.");
        }*/
        //System.out.println("\nImpressao vet req:");
        
    }
    
    public void removerElemento(){                      //Remove elementos da fila
        if(!filaVazia()){
            Requisicao requisicao = fila[inicio++];
            if(inicio == fila.length){
                inicio = 0; 
            }
            this.contador--;
            this.mtReq.addRow(new Integer[]{requisicao.getIdentificador(), requisicao.getTamanho()});
            //System.out.println("removeu eemento");
            numeroElementos--;
            //addElemento(gerarRequisicao());             //Quando remove uma requisição já gera outra na fila
            //this.impressao();
            alocador.alocaHeap(requisicao);         //Manda a requisicao requisição na heap
            //alocacao.start();
        }        
    }
    
    public int getMaximoReq() {
        return maximoReq;
    }

    public int getMinimoReq() {
        return minimoReq;
    }
    
    public Requisicao gerarRequisicao(){                //Função que gera as requisições
        Random random = new Random();
        int tReq = random.nextInt(this.maximoReq - this.minimoReq) + 1;
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
