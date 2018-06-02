package vista;

import controlador.ResetListener;
import modelo.Modelo;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    int ancho=10,alto=10;
    int tamBoton = 40;
    VistaTablero vistaTablero = new VistaTablero(ancho,alto,tamBoton);
    JLabel remanente = new JLabel("",SwingConstants.CENTER);
    JButton reset = new JButton("Iniciar");


    public Ventana(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(ancho*tamBoton,alto*(tamBoton+5));
        agregarLabel();
        agregarBotonReset();
        agregarTablero();
        setResizable(false);

        setLocationRelativeTo(null);
    }

    private void agregarTablero() {
        //this.vistaTablero.setDatosTablero(datosTablero);
//        this.vistaTablero.crearTablero();

    }

    private void agregarBotonReset() {
        add(reset,BorderLayout.SOUTH);
    }

    private void agregarLabel() {
        remanente.setOpaque(true);
        remanente.setBackground(Color.WHITE);
        add(remanente,BorderLayout.NORTH);
    }

    public void inicio() {
        setVisible(true);
    }

    public void setVistaTablero(int[][] datosTablero) {
        remove(vistaTablero);
        vistaTablero = new VistaTablero(ancho,alto,tamBoton);
        vistaTablero.setDatosTablero(datosTablero);
        vistaTablero.crearTablero();
        //vistaTablero.addBotonesListeners();
        add(vistaTablero);
    }

    public void setNMinas(String minas) {
        remanente.setText(minas);
    }


    public void addListeners(){
        reset.addActionListener(new ResetListener(reset));
        vistaTablero.addBotonesListeners();
    }

    public void resetBotones(int[][] datosTablero) {
        vistaTablero.setDatosTablero(datosTablero);
        vistaTablero.resetTablero();
        repaint();
    }
//
//    public void actualizaDatosVistaTablero(int[][] tablero) {
//        vistaTablero.setDatosTablero(tablero);
//    }

    public void resetTotalMinas() {
        setNMinas(String.valueOf(Modelo.nMinas));
    }
}
