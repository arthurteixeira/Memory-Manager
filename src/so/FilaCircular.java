package so;

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
    
    public FilaCircular(int tamanho){
        this.fila = new Requisicao[tamanho];
        this.inicio = 0;
        this.fim = 0;
        this.numeroElementos = 0;
        this.empty = new Semaphore(tamanho);
        this.full = new Semaphore(0);
        this.mutex = new Semaphore(1);
    }
    
    private boolean filaCheia(){
        return numeroElementos == fila.length;
    }
    
    private boolean filaVazia(){
        return numeroElementos == 0;
    }
    
    public void addElemento(int id){
        int tamanho;
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Informe tamanho da variavel:");
        tamanho = input.nextInt();
        
        Requisicao objeto = new Requisicao(id, tamanho);
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
}
