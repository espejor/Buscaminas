package vista;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.EventListener;

public class Boton extends JButton{
    int valor;
    public Boton(int i) {
        valor = i;
    }

    public void eliminaListener() {
        for (EventListener el : this.getActionListeners()) {
            if (el instanceof ActionListener)
                this.removeActionListener((ActionListener) el);
            if (el instanceof MouseListener)
                this.removeMouseListener((MouseListener) el);
        }
    }
}
