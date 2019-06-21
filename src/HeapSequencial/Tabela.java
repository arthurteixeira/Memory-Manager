package HeapSequencial;

public class Tabela {
    private int id;
    private int inicio;
    private int fim;
    private int tamanho;
    
    public Tabela(int id, int tamanho, int inicio, int fim){
        this.id = id;
        this.tamanho = tamanho;
        this.inicio = inicio;
        this.fim = fim;
    }

    public int getId() {
        return id;
    }

    public int getInicio() {
        return inicio;
    }

public int getFim() {
        return fim;
    }

    public int getTamanho() {
        return tamanho;
    }
    
}
