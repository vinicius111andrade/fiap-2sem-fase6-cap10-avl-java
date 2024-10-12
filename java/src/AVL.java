public class AVL {
    private NoAVL raiz;

    public void inserir(Cliente cliente) {
        raiz = inserir(raiz, cliente);
    }

    private NoAVL inserir(NoAVL no, Cliente cliente) {
        if (no == null) {
            return new NoAVL(cliente);
        }

        if (cliente.getCpf().compareTo(no.cliente.getCpf()) < 0) {
            no.esquerda = inserir(no.esquerda, cliente);
        } else if (cliente.getCpf().compareTo(no.cliente.getCpf()) > 0) {
            no.direita = inserir(no.direita, cliente);
        } else {
            return no;
        }

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
        int balanceamento = getBalanceamento(no);

        if (balanceamento > 1 && cliente.getCpf().compareTo(no.esquerda.cliente.getCpf()) < 0) {
            return rotacaoDireita(no);
        }
        if (balanceamento < -1 && cliente.getCpf().compareTo(no.direita.cliente.getCpf()) > 0) {
            return rotacaoEsquerda(no);
        }
        if (balanceamento > 1 && cliente.getCpf().compareTo(no.esquerda.cliente.getCpf()) > 0) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }
        if (balanceamento < -1 && cliente.getCpf().compareTo(no.direita.cliente.getCpf()) < 0) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    public Cliente buscar(String cpf) {
        return buscar(raiz, cpf);
    }

    private Cliente buscar(NoAVL no, String cpf) {
        if (no == null) return null;
        if (cpf.equals(no.cliente.getCpf())) return no.cliente;
        if (cpf.compareTo(no.cliente.getCpf()) < 0) return buscar(no.esquerda, cpf);
        return buscar(no.direita, cpf);
    }

    private int altura(NoAVL no) {
        return (no == null) ? 0 : no.altura;
    }

    private int getBalanceamento(NoAVL no) {
        return (no == null) ? 0 : altura(no.esquerda) - altura(no.direita);
    }

    private NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.esquerda;
        NoAVL T2 = x.direita;
        x.direita = y;
        y.esquerda = T2;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        return x;
    }

    private NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.direita;
        NoAVL T2 = y.esquerda;
        y.esquerda = x;
        x.direita = T2;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        return y;
    }

    public void exibirEmOrdem() {
        exibirEmOrdem(raiz);
    }

    private void exibirEmOrdem(NoAVL no) {
        if (no != null) {
            exibirEmOrdem(no.esquerda);
            no.cliente.exibirCliente();
            exibirEmOrdem(no.direita);
        }
    }
}

