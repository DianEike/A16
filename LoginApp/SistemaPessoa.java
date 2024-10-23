import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaPessoa {

    public SistemaPessoa() {
        JFrame frame = new JFrame("Sistema Pessoa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel footerPanel = new JPanel();
        footerPanel.add(new JLabel("Rodapé do Sistema Pessoa"));
        frame.add(footerPanel, BorderLayout.SOUTH);

        JMenuBar menuBar = new JMenuBar();
        
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenuItem usuariosItem = new JMenuItem("Usuários");
        JMenuItem pessoasItem = new JMenuItem("Pessoas");

        usuariosItem.addActionListener(e -> abrirCadastroUsuarios(frame));
        pessoasItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Cadastrar Pessoa"));

        menuCadastro.add(usuariosItem);
        menuCadastro.add(pessoasItem);
        menuBar.add(menuCadastro);

        JMenu menuVisualizacoes = new JMenu("Visualizações");
        JMenuItem listaUsuariosItem = new JMenuItem("Lista de Usuários");
        JMenuItem listaPessoasItem = new JMenuItem("Lista de Pessoas");
        JMenuItem exitItem = new JMenuItem("Sair");

        listaUsuariosItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Lista de Usuários"));
        listaPessoasItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Lista de Pessoas"));
        exitItem.addActionListener(e -> System.exit(0));

        menuVisualizacoes.add(listaUsuariosItem);
        menuVisualizacoes.add(listaPessoasItem);
        menuBar.add(menuVisualizacoes);
        menuBar.add(exitItem);

        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }

    private void abrirCadastroUsuarios(JFrame parentFrame) {
        JFrame cadastroFrame = new JFrame("Cadastro de Usuários");
        cadastroFrame.setSize(300, 200);
        cadastroFrame.setLayout(new GridLayout(5, 2));

        cadastroFrame.add(new JLabel("Nome:"));
        JTextField nomeField = new JTextField();
        cadastroFrame.add(nomeField);

        cadastroFrame.add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        cadastroFrame.add(emailField);

        cadastroFrame.add(new JLabel("Telefone:"));
        JTextField telefoneField = new JTextField();
        cadastroFrame.add(telefoneField);

        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnLimpar = new JButton("Limpar");
        JButton btnSair = new JButton("Sair");

        cadastroFrame.add(btnCadastrar);
        cadastroFrame.add(btnLimpar);
        cadastroFrame.add(btnSair);

        btnCadastrar.addActionListener(e -> {
            JOptionPane.showMessageDialog(cadastroFrame, "Botão clicado! Cadastrar");
        });

        btnLimpar.addActionListener(e -> {
            nomeField.setText("");
            emailField.setText("");
            telefoneField.setText("");
            JOptionPane.showMessageDialog(cadastroFrame, "Botão clicado! Limpar");
        });

        btnSair.addActionListener(e -> cadastroFrame.dispose());

        cadastroFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SistemaPessoa::new);
    }
}
