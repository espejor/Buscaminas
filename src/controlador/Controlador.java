package controlador;

import modelo.Modelo;
import vista.Ventana;

public class Controlador implements RemanenteMinasListener{
    protected static Ventana ventana;
    protected static Modelo modelo;

    public Controlador(Ventana vista, Modelo modelo) {
        setModelo(modelo);
        setVista(vista);
    }

    public Controlador() {
    }

    @Override
    public void alCambiarRemanente(RemanenteEventObject evento) {
        ventana.setNMinas(String.valueOf(evento.getRemanente()));
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
        modelo.addRemanenteMinasListener(this);
    }

    public void setVista(Ventana vista) {
        this.ventana = vista;

        ventana.setVistaTablero(modelo.getTablero());
        ventana.setNMinas(String.valueOf(modelo.getnMinas()));
        ventana.addListeners();
    }

    public void resetVista() {
        //ventana.actualizaDatosVistaTablero(modelo.getTablero());
        ventana.resetBotones(modelo.getTablero());
        modelo.resetRemanente();
//        ventana.addBotonesListeners();
    }
}
