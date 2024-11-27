import javax.swing.*;

public abstract class Operacao {
    protected final JFrame principal;

    public Operacao(JFrame principal) {
        this.principal = principal;
    }

    public abstract void exibir();
}
