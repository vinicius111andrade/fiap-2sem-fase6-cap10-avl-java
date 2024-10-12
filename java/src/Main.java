public class Main {

	public static void main(String[] args) {
		SistemaCadastro sistema = new SistemaCadastro();

        // Cadastrando clientes
        sistema.cadastrarCliente(new Cliente("Ana", "12/05/2003", "123456789", "ana@example.com", "Rua A", "11111111111"));
        sistema.cadastrarCliente(new Cliente("Henrique", "15/09/2003", "987654321", "henrique@example.com", "Rua B", "22222222222"));
        sistema.cadastrarCliente(new Cliente("Rodrigo", "02/05/2002", "123459876", "rodrigo@example.com", "Rua C", "33333333333"));
        sistema.cadastrarCliente(new Cliente("Vinicius", "23/02/2000", "678912345", "vinicius@example.com", "Rua D", "44444444444"));

        // Buscando cliente por CPF
        sistema.buscarClientePorCpf("11111111111");

        // Ordenando clientes por nome
        sistema.ordenarClientesPorNome();

        // Exibindo clientes em ordem de CPF
        sistema.exibirClientesPorCpf();
    }
}