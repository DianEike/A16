import javax.swing.*;
import java.awt.*;

public class ListaUsuarios extends Operacao { // Garante que estende corretamente Operacao
    public ListaUsuarios(JFrame principal) {
        super(principal); // Chama o construtor da superclasse
    }

    @Override
    public void exibir() { // Implementa o método abstrato
        JDialog dialog = new JDialog(principal, "Lista de Usuários", true);
        dialog.setSize(750, 650);
        dialog.setLayout(new BorderLayout());

        dialog.add(new JLabel("Lista de Usuários", SwingConstants.CENTER), BorderLayout.NORTH);
        dialog.add(new JTextArea("Exemplo de lista de usuários..."), BorderLayout.CENTER);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dialog.setVisible(false)); // Adiciona o evento ao botão
        dialog.add(btnFechar, BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(principal); // Centraliza na tela
        dialog.setVisible(true); // Torna o dialog visível
    }
}

