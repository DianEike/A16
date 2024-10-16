import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginApp extends JFrame {

    
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton btnConfirm, btnCancel;

    
    private final String validUser = "denys.silva";
    private final String validPassword = "Teste@2024";

    public LoginApp() {
        
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        
        setLayout(new GridLayout(3, 2));

        
        add(new JLabel("Usuário:"));
        userField = new JTextField();
        add(userField);

        add(new JLabel("Senha:"));
        passwordField = new JPasswordField();
        add(passwordField);

        
        btnConfirm = new JButton("Confirmar");
        btnConfirm.addActionListener(new ConfirmAction());
        add(btnConfirm);

        btnCancel = new JButton("Cancelar");
        btnCancel.addActionListener(new CancelAction());
        add(btnCancel);
    }

    
    private class ConfirmAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = userField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals(validUser) && password.equals(validPassword)) {
                JOptionPane.showMessageDialog(null, "Acesso confirmado!");
                dispose();  
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    
    private class CancelAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();  
        }
    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginApp loginApp = new LoginApp();
                loginApp.setVisible(true);
            }
        });
    }
}
