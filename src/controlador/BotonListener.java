package controlador;

import modelo.Modelo;
import vista.Boton;
import vista.VistaTablero;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonListener extends Controlador implements ActionListener {
    int value;
    VistaTablero vistaTablero;

    public BotonListener(int i, VistaTablero vistaTablero) {
       value = i;
       this.vistaTablero = vistaTablero;
    }

    /**
     * Invoked when an action occurs.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        ((JButton)e.getSource()).setVisible(false);
        if (value == Modelo.MINA)
            desactivarBotones();
    }

    private void desactivarBotones() {
        Boton[][] botones = vistaTablero.getBotones();
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                botones[i][j].setVisible(false);
            }
        }
    }
}
