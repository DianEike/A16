import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginApp extends JFrame {

    // Componentes da interface
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton btnConfirm, btnCancel;

    // Usuário e senha válidos
    private final String validUser = "denys.silva";
    private final String validPassword = "Teste@2024";

    public LoginApp() {
        // Configurações da janela
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        // Layout da janela
        setLayout(new GridLayout(3, 2));

        // Adicionando os componentes
        add(new JLabel("Usuário:"));
        userField = new JTextField();
        add(userField);

        add(new JLabel("Senha:"));
        passwordField = new JPasswordField();
        add(passwordField);

        // Botões
        btnConfirm = new JButton("Confirmar");
        btnConfirm.addActionListener(new ConfirmAction());
        add(btnConfirm);

        btnCancel = new JButton("Cancelar");
        btnCancel.addActionListener(new CancelAction());
        add(btnCancel);
    }

    // Ação do botão Confirmar
    private class ConfirmAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = userField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals(validUser) && password.equals(validPassword)) {
                JOptionPane.showMessageDialog(null, "Acesso confirmado!");
                dispose();  // Fecha a janela
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Ação do botão Cancelar
    private class CancelAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();  // Fecha a janela
        }
    }

    public static void main(String[] args) {
        // Criação e exibição da janela de login
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginApp loginApp = new LoginApp();
                loginApp.setVisible(true);
            }
        });
    }
}
