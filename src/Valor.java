/**
 * Classe que encapsula o valor e o tipo de uma expressão avaliada.
 * Isso é fundamental para a análise de tipos em tempo de compilação/execução.
 */
public class Valor {
    private Tipo tipo;
    private Object valor; // Usamos Object para armazenar INTEIRO, REAL ou TEXTO

    // Construtor
    public Valor(Tipo tipo, Object valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    // --- Getters ---
    
    public Tipo getTipo() {
        return tipo;
    }

    public Object getValor() {
        return valor;
    }

    // --- Métodos de Conversão (Facilitam o uso) ---
    
    // Retorna o valor como um Integer (com casting seguro)
    public Integer asInteger() {
        if (tipo == Tipo.INTEIRO && valor instanceof Integer) {
            return (Integer) valor;
        }
        // Em um compilador real, aqui seria lançado um erro de casting
        return null; 
    }

    // Retorna o valor como um Double (com casting seguro)
    public Double asDouble() {
        if (tipo == Tipo.REAL && valor instanceof Double) {
            return (Double) valor;
        }
        // Trata a conversão implícita (promove INTEIRO para REAL para cálculos)
        if (tipo == Tipo.INTEIRO && valor instanceof Integer) {
            return ((Integer) valor).doubleValue();
        }
        return null;
    }
    
    // Retorna o valor como uma String
    public String asString() {
        if (tipo == Tipo.TEXTO && valor instanceof String) {
            return (String) valor;
        }
        // Conversão para imprimir
        return String.valueOf(valor); 
    }
}