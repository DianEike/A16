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
        pessoasItem.addActionListener(e -> abrirCadastroPessoas(frame));

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

    private void abrirCadastroPessoas(JFrame parentFrame) {
        JFrame cadastroFrame = new JFrame("Cadastro de Pessoas");
        cadastroFrame.setSize(400, 400);
        cadastroFrame.setLayout(new GridLayout(8, 2));

        cadastroFrame.add(new JLabel("Nome:"));
        JTextField nomeField = new JTextField();
        cadastroFrame.add(nomeField);

        cadastroFrame.add(new JLabel("Endereço:"));
        JTextField enderecoField = new JTextField();
        cadastroFrame.add(enderecoField);

        cadastroFrame.add(new JLabel("Cidade:"));
        JTextField cidadeField = new JTextField();
        cadastroFrame.add(cidadeField);

        cadastroFrame.add(new JLabel("UF:"));
        JTextField ufField = new JTextField();
        cadastroFrame.add(ufField);

        cadastroFrame.add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        cadastroFrame.add(emailField);

        cadastroFrame.add(new JLabel("Telefone:"));
        JTextField telefoneField = new JTextField();
        cadastroFrame.add(telefoneField);

        cadastroFrame.add(new JLabel("Sexo:"));
        String[] sexoOptions = {"Masculino", "Feminino", "Outro"};
        JComboBox<String> sexoComboBox = new JComboBox<>(sexoOptions);
        cadastroFrame.add(sexoComboBox);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton btnIncluir = new JButton("Incluir");
        JButton btnAlterar = new JButton("Alterar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnConsultar = new JButton("Consultar");
        JButton btnCancelar = new JButton("Cancelar");
        JButton btnSair = new JButton("Sair");

        buttonPanel.add(btnIncluir);
        buttonPanel.add(btnAlterar);
        buttonPanel.add(btnExcluir);
        buttonPanel.add(btnConsultar);
        buttonPanel.add(btnCancelar);
        buttonPanel.add(btnSair);

        cadastroFrame.add(new JLabel());  // Label vazia para preencher o espaço do grid
        cadastroFrame.add(buttonPanel);

        // Ações dos botões
        btnIncluir.addActionListener(e -> JOptionPane.showMessageDialog(cadastroFrame, "Pessoa Incluída"));
        btnAlterar.addActionListener(e -> JOptionPane.showMessageDialog(cadastroFrame, "Pessoa Alterada"));
        btnExcluir.addActionListener(e -> JOptionPane.showMessageDialog(cadastroFrame, "Pessoa Excluída"));
        btnConsultar.addActionListener(e -> JOptionPane.showMessageDialog(cadastroFrame, "Consulta realizada"));
        btnCancelar.addActionListener(e -> {
            nomeField.setText("");
            enderecoField.setText("");
            cidadeField.setText("");
            ufField.setText("");
            emailField.setText("");
            telefoneField.setText("");
            sexoComboBox.setSelectedIndex(0);
            JOptionPane.showMessageDialog(cadastroFrame, "Campos limpos");
        });
        btnSair.addActionListener(e -> cadastroFrame.dispose());

        cadastroFrame.setVisible(true);
    }

    private void abrirCadastroUsuarios(JFrame parentFrame) {
        // Você pode manter a implementação anterior para cadastro de usuários se necessário.
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SistemaPessoa::new);
    }
}
