package so;

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
    private Semaphore empty;
    private Semaphore full;
    private Semaphore mutex;
    private int idReq = 0;
    private int maximoReq;
    private int minimoReq;
    
    public FilaCircular(int tamanho, int minimo, int maximo){
        this.fila = new Requisicao[tamanho];
        this.inicio = 0;
        this.fim = 0;
        this.numeroElementos = 0;
        this.empty = new Semaphore(tamanho);
        this.full = new Semaphore(0);
        this.mutex = new Semaphore(1);
        this.maximoReq = maximo;
        this.minimoReq = minimo;
        for(int i=0; i<tamanho; i++){
            addElemento(gerarRequisicao());
        }
    }
    
    private boolean filaCheia(){
        return numeroElementos == fila.length;
    }
    
    private boolean filaVazia(){
        return numeroElementos == 0;
    }
    
    public void addElemento(Requisicao objeto){
        if(!filaCheia()){
            
            try {
                empty.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(FilaCircular.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            fila[fim++] = objeto;
            
            try {
                mutex.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(FilaCircular.class.getName()).log(Level.SEVERE, null, ex);
            }
            numeroElementos++;
            mutex.release();
            
            if(fim == fila.length)
                fim = 0;
            
            full.release();
            
            System.out.println("Requisição entrou no vetor de requisições.");
        }else{
            System.out.println("Requisição NÃO entrou no vetor de requisições.");
        }
    }
    
    public Requisicao removerElemento(){
        if(!filaVazia()){
            try {
                full.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(FilaCircular.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Requisicao requisicao = fila[inicio++];
            if(inicio == fila.length){
               inicio = 0; 
            }
            
            try {
                mutex.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(FilaCircular.class.getName()).log(Level.SEVERE, null, ex);
            }
            numeroElementos--;
            mutex.release();
            
            empty.release();
            
            return requisicao;
        }else{
            return null;
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
}
