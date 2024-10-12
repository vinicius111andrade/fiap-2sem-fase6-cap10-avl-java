public class Cliente {
    private String nomeCompleto;
    private String dataNascimento;
    private String telefone;
    private String email;
    private String endereco;
    private String cpf;

    public Cliente(String nomeCompleto, String dataNascimento, String telefone, String email, String endereco, String cpf) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void exibirCliente() {
        System.out.println("Nome: " + nomeCompleto + ", CPF: " + cpf);
    }
}


