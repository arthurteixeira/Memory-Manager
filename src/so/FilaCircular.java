package so;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class FilaCircular {
    private Requisicao[] fila;          //Vetor de requisições p/ implementação da fila
    private int inicio;                 //Aponta p/ inicio da fila
    private int fim;                    //Aponta p/ o fim da filla
    private int numeroElementos;        //Num. de elementos na fila
    private int idReq = 0;              //ID das requisições, usado p/ gerar as requisições
    private int maximoReq;              //Valor máximo das requisições
    private int minimoReq;              //Valor mínimo das requisições
    private mapeamentoHeap mp;           //Cria objeto da heap
    private Principal atualiza;         //Cria objeto p/ atualização das tabelas na interface
    private Alocador alocador;
    
    public FilaCircular(int tamanho, int minimo, int maximo, mapeamentoHeap mp, Principal p){
        this.fila = new Requisicao[tamanho];
        this.inicio = 0;
        this.fim = 0;
        this.numeroElementos = 0;
        this.maximoReq = maximo;
        this.minimoReq = minimo;
        this.atualiza = p;
                                                         //Gera todas as requisições iniciais
        for(int i=0; i<tamanho; i++){
            addElemento(gerarRequisicao());
        }
        this.impressao();
        this.mp = mp;
        this.alocador = new Alocador(p, mp);
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
            System.out.println("Requisição entrou no vetor de requisições.");
            
        }else{
            System.out.println("Requisição NÃO entrou no vetor de requisições.");
        }
        System.out.println("\nImpressao vet req:");
        
    }
    
    public void removerElemento(){                      //Remove elementos da fila
        if(!filaVazia()){
            Requisicao requisicao = fila[inicio++];
            if(inicio == fila.length){
                inicio = 0; 
            }
            numeroElementos--;
            addElemento(gerarRequisicao());             //Quando remove uma requisição já gera outra na fila
            this.impressao();
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
        int tam = random.nextInt(getMaximoReq()) + getMinimoReq();
        Requisicao nova = new Requisicao(idReq, tam);
        idReq++;
        return nova;
    }

    public void impressao(){                            //Função que manda os parametros p/ atualizar as tabelas na classe principal
        String id, tam;
        for(int i = 0; i < fila.length; i++){
            id = "" + fila[i].getIdentificador();
            tam = "" + fila[i].getTamanho();
            atualiza.atualizarReq(id, tam, i);
        }
    }
}
