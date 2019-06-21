/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HeapSequencial;

/**
 *
 * @author casa
 */
public class mapeamentoHeap {
    
    public  int[][] tabHeap;
    public  int[]   heap;
    private int     ultimoId;
    private int     constDesalocacao;
    private int     ocupacaoHeap;
    private float   limiarMax;
    private int     tamHeap;
    public  String  logAlocacao;
    public  String  logDesalocacao;

    public mapeamentoHeap(float limiarMax, int tamHeap) {
        this.limiarMax = limiarMax;
        this.tamHeap = tamHeap;
        this.ultimoId = this.ocupacaoHeap = 0;
        this.heap = new int[this.tamHeap];
        this.tabHeap = new int[this.tamHeap][3];
        for(int i = 0; i < this.tamHeap; i++){
            for(int j = 0; j < 3; j++){
                this.tabHeap[i][j] = 0;
            }
            this.heap[i] = 0;
        }
        this.logAlocacao = "";
        this.logDesalocacao = "";
    }

    public int getUltimoId() {
        return ultimoId;
    }

    public void setUltimoId(int ultimoId) {
        this.ultimoId = ultimoId;
    }

    public int getOcupacaoHeap() {
        return ocupacaoHeap;
    }

    public void setOcupacaoHeap(int ocupacaoHeap) {
        this.ocupacaoHeap = ocupacaoHeap;
    }

    public float getLimiarMax() {
        return limiarMax;
    }

    public void setLimiarMax(float limiarMax) {
        this.limiarMax = limiarMax;
    }

    public int getTamHeap() {
        return tamHeap;
    }
        
}
