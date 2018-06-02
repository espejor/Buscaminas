package controlador;

import modelo.Modelo;
import vista.Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetListener extends Controlador implements ActionListener {
    public ResetListener(JButton reset) {
    }

    /**
     * Invoked when an action occurs.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        super.setModelo(new Modelo());
        super.resetVista();
    }
}
