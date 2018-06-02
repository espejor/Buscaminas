package controlador;


import vista.Boton;

import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseEvent;


public class RatonListener extends Controlador implements IMouseAdapter {
    Boton boton;
    private final int LIBRE = 0;
    private final int MARCADO = 1;
    private final int INTERROGACION = 2;
    private int estado = LIBRE;




    public RatonListener(Boton boton) {
        this.boton = boton;
    }


    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        Boton b = (Boton) e.getSource();
        int tamBoton = b.getSize().width;
        if (e.getButton() == MouseEvent.BUTTON3) {
            if (estado == LIBRE) {
                b.setIcon(new ImageIcon(new ImageIcon("src/imagenes/banderin.png")
                        .getImage().getScaledInstance(tamBoton, tamBoton, Image.SCALE_SMOOTH)));
                estado = MARCADO;
                modelo.decrementarRemanente();
            }else if (estado == MARCADO) {
                b.setIcon(new ImageIcon(new ImageIcon("src/imagenes/interroga.png")
                        .getImage().getScaledInstance(tamBoton, tamBoton, Image.SCALE_SMOOTH)));
                estado = INTERROGACION;
                modelo.incrementarRemanente();
            }else{
                estado = LIBRE;
                b.setIcon(null);
            }
        }
    }
}
