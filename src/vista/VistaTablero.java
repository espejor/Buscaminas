package vista;

import controlador.BotonListener;
import controlador.RatonListener;

import modelo.Modelo;

import javax.swing.*;
import java.awt.*;

public class VistaTablero extends JPanel {
    Modelo modelo;
    int tamX = 10;
    int tamY = 10;
    int tamBoton;
    int[][] datosTablero = new int[tamX][tamY];
    Boton[][] botones;
    Celda[][] celda;
    private static int minasRemanente = Modelo.nMinas;


    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public VistaTablero(int ancho, int alto, int tamBoton) {
        tamX = ancho;
        tamY = alto;
        this.tamBoton = tamBoton;
        setSize(ancho*tamBoton,alto*tamBoton);
        setLayout(new GridLayout(tamX, tamY));
    }


    public void crearTablero() {
        botones = new Boton[tamX][tamY];
        celda = new Celda[tamX][tamY];

        for (int i = 0; i < tamX; i++) {
            for (int j = 0; j < tamY; j++) {
                celda[i][j] = new Celda(new BorderLayout());
                celda[i][j].add(agregaBoton(i,j));
                celda[i][j].add(agregaValoresTablero(i,j));
                add(celda[i][j]);
            }
        }
    }

    private JLabel agregaValoresTablero(int i, int j) {
        if (datosTablero[i][j] == 0)
            return (new JLabel(""));
        else if (datosTablero[i][j] == Modelo.MINA) {
            Image imagen = new ImageIcon("src/imagenes/explosion.png").getImage().getScaledInstance(tamBoton, tamBoton, Image.SCALE_SMOOTH);
            return (new JLabel(new ImageIcon(imagen)));
        } else
            return (new JLabel(String.valueOf(datosTablero[i][j]), SwingConstants.CENTER));
    }

    private Boton agregaBoton(int i, int j) {
        botones[i][j] = new Boton(datosTablero[i][j]);
        botones[i][j].setSize(tamBoton, tamBoton);
        return botones[i][j];
    }

    public void addBotonesListeners(){
        for (int i = 0; i < tamX; i++) {
            for (int j = 0; j < tamY; j++) {
                botones[i][j].eliminaListener();
                botones[i][j].addActionListener(new BotonListener(datosTablero[i][j], this));
                botones[i][j].addMouseListener(new RatonListener(botones[i][j]));
            }
        }
    }

    public void setDatosTablero(int[][] datosTablero) {
        this.datosTablero = datosTablero;
//        crearTablero();
    }

    public Boton[][] getBotones() {
        return botones;
    }

    public void resetTablero() {
        for (int i = 0; i < tamX; i++) {
            for (int j = 0; j < tamY; j++) {
                celda[i][j].removeAll();
//                celda[i][j].remove(1);
                celda[i][j].add(agregaBoton(i,j));
                celda[i][j].add(agregaValoresTablero(i,j));

//                ((Boton)celda[i][j].getComponent(0)).setIcon(null);
//                celda[i][j].getComponent(0).setVisible(true);

            }
        }
        addBotonesListeners();
    }
}

