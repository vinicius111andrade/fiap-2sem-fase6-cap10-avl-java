import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SistemaCadastro {
    private AVL avl = new AVL();
    private List<Cliente> clientes = new ArrayList<>();
    
    public void cadastrarCliente(Cliente cliente) {
        avl.inserir(cliente);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public Cliente buscarClientePorCpf(String cpf) {
        Cliente encontrado = avl.buscar(cpf);
        if (encontrado != null) {
            System.out.println("Cliente encontrado:");
            encontrado.exibirCliente();
        } else {
            System.out.println("Cliente não encontrado.");
        }
        return encontrado;
    }

    public void ordenarClientesPorNome() {
        clientes.sort(Comparator.comparing(Cliente::getNomeCompleto));
        System.out.println("Clientes ordenados por nome:");
        for (Cliente cliente : clientes) {
            cliente.exibirCliente();
        }
    }
    
    public void exibirClientesPorCpf() {
        System.out.println("Clientes em ordem de CPF:");
        avl.exibirEmOrdem();
    }
}
