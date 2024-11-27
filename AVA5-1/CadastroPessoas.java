import javax.swing.*;
import java.awt.*;

public class CadastroPessoas extends Operacao {
    public CadastroPessoas(JFrame principal) {
        super(principal); // Chama o construtor da superclasse
    }

    @Override
    public void exibir() {
        JDialog dialog = new JDialog(principal, "Cadastro de Pessoas", true);
        dialog.setSize(600, 300);
        dialog.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Cadastro de Pessoas", SwingConstants.CENTER);
        dialog.add(titulo, BorderLayout.NORTH);

        JPanel painelCampos = new JPanel(new GridLayout(7, 2, 5, 5));
        painelCampos.add(new JLabel("Nome:"));
        painelCampos.add(new JTextField(40));
        painelCampos.add(new JLabel("Endereço:"));
        painelCampos.add(new JTextField(60));
        painelCampos.add(new JLabel("Cidade:"));
        painelCampos.add(new JTextField(40));
        painelCampos.add(new JLabel("UF:"));
        painelCampos.add(new JTextField(2));
        painelCampos.add(new JLabel("Email:"));
        painelCampos.add(new JTextField(30));
        painelCampos.add(new JLabel("Telefone:"));
        painelCampos.add(new JTextField(20));
        painelCampos.add(new JLabel("Sexo:"));
        painelCampos.add(new JComboBox<>(new String[]{"Masculino", "Feminino"}));

        dialog.add(painelCampos, BorderLayout.CENTER);
        JButton salvar = new JButton("Salvar");
        salvar.addActionListener(e -> JOptionPane.showMessageDialog(dialog, "Pessoa salva!")); // Exemplo de ação
        dialog.add(salvar, BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(principal);
