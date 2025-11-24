public class Simbolo {
    private String nome;
    private Tipo tipo;
    private Object valor; // Adicionado para armazenar o valor

    public Simbolo(String nome, Tipo tipo) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = null; // Inicializa
    }

    public String getNome() { return nome; }
    public Tipo getTipo() { return tipo; }

    public Object getValor() { 
        return valor; 
    }
    
    public void setValor(Object valor) {
        this.valor = valor;
    }
}