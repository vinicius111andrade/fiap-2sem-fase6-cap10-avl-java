public class NoAVL {
    Cliente cliente;
    NoAVL esquerda, direita;
    int altura;

    public NoAVL(Cliente cliente) {
        this.cliente = cliente;
        this.altura = 1;
    }
}