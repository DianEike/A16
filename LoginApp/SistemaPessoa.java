import javax.swing.*;
import java.awt.*;


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

        usuariosItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Cadastrar Usuário"));
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SistemaPessoa());
    }
}
