import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SistemaPessoa extends JPanel {
    private static final String VERSAO_SISTEMA = "12.1.2024";
    private String nomeUsuario = "denys.silva";
    private String dataAcesso;

    public SistemaPessoa() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
        this.dataAcesso = dateFormat.format(new Date());

        // Cria o frame principal
        JFrame principal = new JFrame("Sistema Pessoa");
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setSize(800, 800);
        
        // Adiciona componentes ao frame
        principal.setJMenuBar(new MenuPrincipal(this));
        principal.getContentPane().add(BorderLayout.CENTER, new JTextArea());
        principal.getContentPane().add(BorderLayout.SOUTH, new Rodape(VERSAO_SISTEMA, nomeUsuario, dataAcesso));

        principal.setLocationRelativeTo(null); // Centraliza a janela
        principal.setVisible(true); // Torna a janela visível
    }

    public static void main(String[] args) {
        new SistemaPessoa();
    }
}

class MenuPrincipal extends JMenuBar {
    public MenuPrincipal(SistemaPessoa sistema) {
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenu menuVisualizacao = new JMenu("Visualização");
        
        // Cria a opção de "Sair" no menu principal
        JMenu menuSair = new JMenu("Sair");
        menuSair.addMenuListener(new javax.swing.event.MenuListener() {
            @Override
            public void menuSelected(javax.swing.event.MenuEvent e) {
                System.exit(0); // Sai do sistema
            }

            @Override
            public void menuDeselected(javax.swing.event.MenuEvent e) { }

            @Override
            public void menuCanceled(javax.swing.event.MenuEvent e) { }
        });

        // Adiciona os itens de menu
        JMenuItem itemMenuCadastroUsuarios = new JMenuItem("Usuários");
        JMenuItem itemMenuCadastroPessoas = new JMenuItem("Pessoas");
        menuCadastro.add(itemMenuCadastroUsuarios);
        menuCadastro.add(itemMenuCadastroPessoas);
        
        JMenuItem itemMenuVisualizacaoListaUsuarios = new JMenuItem("Lista de usuários");
        JMenuItem itemMenuVisualizacaoListaPessoas = new JMenuItem("Lista de pessoas");
        menuVisualizacao.add(itemMenuVisualizacaoListaUsuarios);
        menuVisualizacao.add(itemMenuVisualizacaoListaPessoas);
        
        // Adiciona os menus à barra de menu
        this.add(menuCadastro);
        this.add(menuVisualizacao);
        this.add(menuSair);
    }
}

class Rodape extends JPanel {
    public Rodape(String versaoSistema, String nomeUsuario, String dataAcesso) {
        JLabel labelRodape = new JLabel("Versão: " + versaoSistema + "               Usuário: " + nomeUsuario + "               Data de acesso: " + dataAcesso);
        this.add(labelRodape); // Components Added using Flow Layout
    }
}
