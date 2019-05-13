/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

/**
 *
 * @author anderson
 */
public class Heap {
    
    private Requisicao[] heap;
    private int tamanho;
    private int nelementos;
    private int maximoReq;
    private int minimoReq;

    public Heap(int tamanho, int maximoReq, int minimoReq) {
        this.tamanho = tamanho;
        this.maximoReq = maximoReq;
        this.minimoReq = minimoReq;
        this.heap = new Requisicao[tamanho];
        this.nelementos = 0;
    }
    
    private boolean heapVazia(){
        return this.nelementos == 0;
    }
    
    private boolean heapCheia(){
        return this.nelementos == this.maximoReq;
    }
    
    public void build_heap(Requisicao objeto){
        if(!heapCheia()){
            heap[this.nelementos] = objeto;
            this.nelementos++;
            percolate( this.nelementos - 1, heap);
        }
        else{
            
        }
    }
    
    private void percolate(int pos, Requisicao[] h){
	if(pos == 0)	return;
	int pai = busca_pai(pos);
        Requisicao aux;
	if(h[pos].getIdentificador() < h[pai].getIdentificador()){
		aux = h[pos];
		h[pos] = h[pai];
		h[pai] = aux;
	}
	percolate( pai, h);
    }
    
    private int busca_filho(int i){
	i++;
	i = i * 2-1;
	return(i);
    }   

    private int busca_pai(int i){
	i = i + 1;
	int aux = i/2-1;
	return(aux);
    }
    
}
