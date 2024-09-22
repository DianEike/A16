import java.util.Scanner; 

public class Main { 
    public static void main(String[] args) { 
        // Declaração de variável
        int opcao;
        // Cria objeto para entrada da opção do cardápio
        Scanner leitorOpcao = new Scanner(System.in);
        // Apresenta o cardápio
        System.out.println("1 – Pastel de carne \n");
        System.out.println("2 – Coxinha de frango \n");
        System.out.println("3 – Kibe com queijo \n");
        // Entrada da opção do cardápio
        System.out.print("Escolha uma opção: ");
        opcao = leitorOpcao.nextInt();
        // Seleção da opção
        switch (opcao) {
            case 1:
                System.out.println("Pastel de carne escolhido.");
                break;
            case 2:
                System.out.println("Coxinha de frango escolhida.");
                break;
            case 3:
                System.out.println("Kibe com queijo escolhido.");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }
}
