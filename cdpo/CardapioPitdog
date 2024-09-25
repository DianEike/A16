
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Produto {
    String id;
    String descricao;
    boolean ativo;
    double preco;

    public Produto(String id, String descricao, boolean ativo, double preco) {
        this.id = id.toUpperCase();
        this.descricao = descricao.toUpperCase();
        this.ativo = ativo;
        this.preco = preco;
    }
}

class Cliente {
    String nome;
    String endereco;
    String sexo;
    String telefone;
    Date nascimento;
    boolean autorizado;

    public Cliente(String nome, String endereco, String sexo, String telefone, Date nascimento, boolean autorizado) {
        this.nome = nome.toUpperCase();
        this.endereco = endereco;
        this.sexo = sexo.toUpperCase();
        this.telefone = telefone;
        this.nascimento = nascimento;
        this.autorizado = autorizado;
    }
}

public class CardapioPitdog {
    static List<Produto> produtos = new ArrayList<>();
    static List<Cliente> clientes = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            int op = sc.nextInt();
            sc.nextLine(); // Limpar buffer

            switch (op) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    editarProduto();
                    break;
                case 4:
                    removerProduto();
                    break;
                case 5:
                    cadastrarCliente();
                    break;
                case 6:
                    listarClientes();
                    break;
                case 7:
                    System.out.println("Sistema encerrado.");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("\nMenu do Cardápio PitDog");
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2 - Listar Produtos");
        System.out.println("3 - Editar Produto");
        System.out.println("4 - Remover Produto");
        System.out.println("5 - Cadastrar Cliente");
        System.out.println("6 - Listar Clientes");
        System.out.println("7 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void cadastrarProduto() {
        System.out.print("Digite o código do produto (6 caracteres): ");
        String id = sc.nextLine();

        if (id.length() != 6) {
            System.out.println("Código deve ter exatamente 6 caracteres.");
            return;
        }

        System.out.print("Digite a descrição do produto (3 a 60 caracteres): ");
        String descricao = sc.nextLine();

        if (descricao.length() < 3 || descricao.length() > 60) {
            System.out.println("Descrição deve ter entre 3 e 60 caracteres.");
            return;
        }

        System.out.print("O produto está ativo? (1 para sim, 2 para não): ");
        boolean ativo = sc.nextInt() == 1;

        System.out.print("Digite o preço do produto (deve ser positivo): ");
        double preco = sc.nextDouble();
        if (preco < 0) {
            System.out.println("Preço deve ser um valor positivo.");
            return;
        }

        produtos.add(new Produto(id, descricao, ativo, preco));
        System.out.println("Produto cadastrado com sucesso!");
    }

    public static void listarProdutos() {
        System.out.println("\nCardápio:");
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        for (Produto p : produtos) {
            if (!p.ativo) continue;
            System.out.printf("Código: %s | Produto: %s | Preço: R$ %.2f\n", p.id, p.descricao, p.preco);
        }
    }

    public static void editarProduto() {
        System.out.print("Digite o código do produto para editar: ");
        String id = sc.nextLine();

        for (Produto p : produtos) {
            if (p.id.equals(id)) {
                System.out.print("Digite a nova descrição do produto: ");
                String novaDescricao = sc.nextLine();
                System.out.print("O produto está ativo? (1 para sim, 2 para não): ");
                boolean novaAtivo = sc.nextInt() == 1;
                System.out.print("Digite o novo preço: ");
                double novoPreco = sc.nextDouble();

                p.descricao = novaDescricao.toUpperCase();
                p.ativo = novaAtivo;
                p.preco = novoPreco;

                System.out.println("Produto editado com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    public static void removerProduto() {
        System.out.print("Digite o código do produto a ser excluído: ");
        String id = sc.nextLine();

        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).id.equals(id)) {
                produtos.remove(i);
                System.out.println("Produto removido com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    public static void cadastrarCliente() {
        System.out.print("Digite o nome do cliente (mínimo 6 caracteres): ");
        String nome = sc.nextLine();

        if (nome.length() < 6) {
            System.out.println("Nome deve ter no mínimo 6 caracteres.");
            return;
        }

        System.out.print("Digite o endereço do cliente: ");
        String endereco = sc.nextLine();

        System.out.print("Digite o sexo do cliente (M ou F): ");
        String sexo = sc.nextLine().toUpperCase();
        if (!sexo.equals("M") && !sexo.equals("F")) {
            System.out.println("Sexo inválido. Deve ser M ou F.");
            return;
        }

        System.out.print("Digite o telefone do cliente: ");
        String telefone = sc.nextLine();

        System.out.print("Digite a data de nascimento (dd/mm/aaaa): ");
        String dataStr = sc.nextLine();
        Date nascimento = null;

        // Tentar converter a data
        try {
            String[] data = dataStr.split("/");
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(data[0]));
            cal.set(Calendar.MONTH, Integer.parseInt(data[1]) - 1);
            cal.set(Calendar.YEAR, Integer.parseInt(data[2]));
            nascimento = cal.getTime();

            System.out.print("O cliente autoriza o recebimento de mensagens? (1 para sim, 2 para não): ");
            boolean autorizado = sc.nextInt() == 1;

            clientes.add(new Cliente(nome, endereco, sexo, telefone, nascimento, autorizado));
            System.out.println("Cliente cadastrado com sucesso!");

        } catch (Exception e) {
            System.out.println("Data inválida. Tente novamente.");
        }
    }

    public static void listarClientes() {
        System.out.println("\nClientes Cadastrados:");
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (Cliente c : clientes) {
            System.out.printf("Nome: %s | Endereço: %s | Sexo: %s | Telefone: %s\n", c.nome, c.endereco, c.sexo, c.telefone);
        }
    }
}
