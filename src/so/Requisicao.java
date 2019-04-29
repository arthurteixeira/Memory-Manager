package so;

import java.util.Scanner;

public class Requisicao {
    private int identificador;
    private int tamanho;
    
    public Requisicao(int identificador, int tamanho){
        this.identificador = identificador;
        this.tamanho = tamanho;
        
    }
    
    public int getIdentificador() {
        return identificador;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    
}
