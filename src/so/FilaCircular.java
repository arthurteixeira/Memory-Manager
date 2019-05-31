package so;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilaCircular {
    private Requisicao[] fila;
    private int inicio;
    private int fim;
    private int numeroElementos;
    private int idReq = 0;
    private int maximoReq;
    private int minimoReq;
    private Heap h;
    
    public FilaCircular(int tamanho, int minimo, int maximo, Heap h){
        this.fila = new Requisicao[tamanho];
        this.inicio = 0;
        this.fim = 0;
        this.numeroElementos = 0;
        this.maximoReq = maximo;
        this.minimoReq = minimo;
        //Gera todas as requisições iniciais
        for(int i=0; i<tamanho; i++){
            addElemento(gerarRequisicao());
        }
        this.h = h;
    }
    
    private boolean filaCheia(){
        return numeroElementos == fila.length;
    }
    
    private boolean filaVazia(){
        return numeroElementos == 0;
    }
    
    public void addElemento(Requisicao objeto){
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
        this.impressao();
    }
    
    public void removerElemento(){ 
        if(!filaVazia()){
            Requisicao requisicao = fila[inicio++];
            if(inicio == fila.length){
                inicio = 0; 
            }
            numeroElementos--;
            addElemento(gerarRequisicao()); //Quando remove uma gera outra requisição
            h.alocar(requisicao);
        }        
    }
    
    public void impressao(){
        int i=0;
        while(i < numeroElementos){
            System.out.println("ID: " + fila[i].getIdentificador() + " TAMANHO: " + fila[i].getTamanho());
            i++;
        }
    }
    
    public int getMaximoReq() {
        return maximoReq;
    }

    public int getMinimoReq() {
        return minimoReq;
    }
    
    public Requisicao gerarRequisicao(){
        Random random = new Random();
        int tam = random.nextInt(getMaximoReq()) + getMinimoReq();
        Requisicao nova = new Requisicao(idReq, tam);
        idReq++;
        return nova;
    }

    public Requisicao[] getFila() {
        return fila;
    }
    
}
