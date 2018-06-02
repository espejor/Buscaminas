package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public interface IMouseAdapter extends MouseListener{
    /**
     * Invoked when a mouse button has been pressed on a component.
     * @param e
     */
    @Override
    default void mousePressed(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been released on a component.
     * @param e
     */
    @Override
    default void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     * @param e
     */
    @Override
    default void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     * @param e
     */
    @Override
    default void mouseExited(MouseEvent e) {

    }
}
