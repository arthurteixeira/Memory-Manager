package HeapSequencial;

import Interface.Interface;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public final class FilaCircular {
    private Requisicao[] fila;          //Vetor de requisições p/ implementação da fila
    private int inicio;                 //Aponta p/ inicio da fila
    private int fim;                    //Aponta p/ o fim da filla
    private int numeroElementos;        //Num. de elementos na fila
    private int idReq = 0;              //ID das requisições, usado p/ gerar as requisições
    private int maximoReq;              //Valor máximo das requisições
    private int minimoReq;              //Valor mínimo das requisições
    private mapeamentoHeap mp;           //Cria objeto da heap
    private Interface jan;         //Cria objeto p/ atualização das tabelas na interface
    private Alocador alocador;
    private int tam;
    private int contador;
    public  String logFila = "";  
    DefaultTableModel mtReq;
    private long tempInicial;
    private long tempFinal;
    
    public FilaCircular(int tamanho, int minimo, int maximo, mapeamentoHeap mp, Interface jan){
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
        this.tempInicial = System.currentTimeMillis();
        while(this.contador >= 0){
            addElemento(gerarRequisicao());
            if(fila.length > 50 || filaCheia())  this.removerElemento(); //Remove todas req. da fila
        }
        
        //Atualiza as tabelas
        this.jan.txtLogFila.setText(logFila);
        for(int i = 0; i < mp.getTamHeap(); i++){
            alocador.mtHeap.addRow(new Integer[]{i, this.mp.heap[i]});
            alocador.mtContHeap.addRow(new Integer[]{i,this.mp.tabHeap[i][0], this.mp.tabHeap[i][1], this.mp.tabHeap[i][2]});
        }
        jan.txtLogHeapAloca.setText(alocador.getHeapAloca());
        jan.txtLogHeapDesaloca.setText(alocador.dh.getLogDesaloca());
        tempFinal = System.currentTimeMillis();
        long dif = (tempFinal - tempInicial);
        System.out.println(String.format("%d em Minutos | %d em Segundos | %d em Milisegundos", dif/60000, dif/1000, dif));
    }
    
    private boolean filaCheia(){
        return numeroElementos == fila.length;           //Verifica se a fila está cheia;
    }
    
    private boolean filaVazia(){
        return numeroElementos == 0;                     //Verifica se a fila está vazia.
    }
    
    public void addElemento(Requisicao objeto){ //Adiciona elementos no vetor de req.         
        if(!filaCheia()){
            fila[fim++] = objeto;
            numeroElementos++;
            if(fim == fila.length)
                fim = 0;
            this.logFila += "Requisição Criada, ID: " + 
                    objeto.getIdentificador() + ", Tamanho: " +
                    objeto.getTamanho() + "\n";           
        }        
    }
    
    public void removerElemento(){                      //Remove elementos da fila
        if(!filaVazia()){
            Requisicao requisicao = fila[inicio++];
            if(inicio == fila.length){
                inicio = 0; 
            }
            this.contador--;
            this.mtReq.addRow(new Integer[]{
                requisicao.getIdentificador(), 
                requisicao.getTamanho()
            });
            numeroElementos--;
            alocador.alocaHeap(requisicao);         //Aloca requisição na heap
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
        int tReq = 0;
        do{
            tReq = random.nextInt(this.maximoReq - this.minimoReq);
        }while(tReq == 0);
        tReq += this.minimoReq;
        Requisicao nova = new Requisicao(idReq, tReq);
        idReq++;
        return nova;
    }
}
