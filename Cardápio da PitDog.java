import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class GestorDeProdutos {
    static List<String> listaNomes = new ArrayList<>();
    static List<String> listaDescricao = new ArrayList<>();
    static List<Boolean> listaAtivo = new ArrayList<>();
    static List<Double> listaPreco = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        mostrarMenu();
        while (true) {
            System.out.print("Digite a operação: ");
            int op = sc.nextInt();
            executarOperacao(op, sc);

            if (op == 6) {
                System.out.println("Operação finalizada!");
                break;
            }
        }
        sc.close();
    }

    public static void mostrarMenu() {
        System.out.println("Digite 1 para cadastrar um novo produto.");
        System.out.println("Digite 2 para ver todos os produtos.");
        System.out.println("Digite 3 para editar um produto.");
        System.out.println("Digite 4 para remover um produto.");
        System.out.println("Digite 5 para rever o menu.");
        System.out.println("Digite 6 para finalizar o processo.");
    }

    public static void executarOperacao(int op, Scanner sc) {
        switch (op) {
            case 1:
                cadastrarProduto(sc);
                break;
            case 2:
                listarProdutos();
                break;
            case 3:
                editarProduto(sc);
                break;
            case 4:
                removerProduto(sc);
                break;
            case 5:
                mostrarMenu();
                break;
            case 6:
                break;
            default:
                System.out.println("Opção inválida...");
                break;
        }
    }

    public static void cadastrarProduto(Scanner sc) {
        sc.nextLine();  // Limpar o buffer
        System.out.println("Digite o nome do produto: ");
        String nome = sc.nextLine();
        listaNomes.add(nome);

        System.out.println("Digite a descrição do produto: ");
        String descricao = sc.nextLine();
        listaDescricao.add(descricao);

        System.out.println("O produto está disponível? 1 para sim, 2 para não");
        int disponibilidade = sc.nextInt();
        listaAtivo.add(disponibilidade == 1);

        System.out.println("Digite o preço do produto: ");
        Double preco = sc.nextDouble();
        listaPreco.add(preco);

        System.out.println("Produto adicionado!");
    }

    public static void listarProdutos() {
        if (listaNomes.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (int i = 0; i < listaNomes.size(); i++) {
                if (!listaAtivo.get(i)) {
                    continue;
                }
                System.out.println("Nome: " + listaNomes.get(i));
                System.out.println("Descrição do produto: " + listaDescricao.get(i));
                System.out.println("Produto disponível? " + (listaAtivo.get(i) ? "Sim" : "Não"));
                System.out.printf("Preço do produto: R$%.2f\n", listaPreco.get(i));
                System.out.println("Índice do produto: " + i);
                System.out.println();
            }
        }
    }

    public static void editarProduto(Scanner sc) {
        System.out.println("Digite o índice do produto para editar: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index < 0 || index >= listaNomes.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        System.out.println("Digite o novo nome: ");
        String nome = sc.nextLine();
        listaNomes.set(index, nome);

        System.out.println("Digite a nova descrição: ");
        String descricao = sc.nextLine();
        listaDescricao.set(index, descricao);

        System.out.println("O produto está disponível? 1 para sim, 2 para não");
        int disponibilidade = sc.nextInt();
        listaAtivo.set(index, disponibilidade == 1);

        System.out.println("Digite o novo preço: ");
        Double preco = sc.nextDouble();
        listaPreco.set(index, preco);

        System.out.println("Produto editado com sucesso!");
    }

    public static void removerProduto(Scanner sc) {
        System.out.print("Digite o índice do produto a ser excluído: ");
        int index = sc.nextInt();

        if (index < 0 || index >= listaNomes.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        listaNomes.remove(index);
        listaDescricao.remove(index);
        listaAtivo.remove(index);
        listaPreco.remove(index);
        System.out.println("Produto removido com sucesso!");
    }
}
