package modelo;

import controlador.BotonListener;
import controlador.RatonListener;
import controlador.RemanenteEventObject;
import controlador.RemanenteMinasListener;

public class Modelo{
    public static final int MINA = 9;
    int ancho = 10;
    int alto = 10;
    int[][] tablero = new int[ancho][alto];
    public static int nMinas = 25;
    private static int remanente = 25;
    private static RemanenteMinasListener listener;

    public Modelo() {
        ponerMinas();
        ponerAdyacentes();
    }

    private void ponerAdyacentes() {
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                compruebaEntorno(i,j);
            }
        }
    }

    /**
     * Getter de nMinas
     * @return nMinas
     */
    public int getnMinas() {
        return nMinas;
    }

    private void compruebaEntorno(int i, int j) {
        int n = 0;
        for (int k = i - 1; k < i + 2; k++) {
            for (int l = j - 1; l < j + 2; l++) {
                if (k >= 0 && k < ancho && l >= 0 && l < alto && tablero[i][j] != MINA){
                    if (k != i || l != j)
                        if (tablero[k][l] == MINA)
                            tablero[i][j] = ++n;
                }
            }

        }
    }

    private void ponerMinas(){
        int minas = 0;
        while (minas < nMinas){
            int x = generaNumeroAleatorio(0,ancho-1);
            int y = generaNumeroAleatorio(0,alto-1);
            if (tablero [x][y] == 0){
                tablero [x][y] = MINA;
                minas++;
            }
        }
    }

    private int generaNumeroAleatorio(int minimo,int maximo){
        int num=(int)Math.floor(Math.random()*(maximo-minimo+1)+(minimo));
        return num;
    }

    @Override
    public String toString() {
        String salida = "";
        for (int j = 0; j < alto; j++) {
            for (int i = 0; i < ancho; i++) {
                salida += tablero[i][j] + " ";
            }
            salida += "\n";
        }
        return salida;
    }

    public int[][] getTablero() {
        return tablero;
    }

    public void setRemanente(int nuevoRemanente){
        remanente = nuevoRemanente;
        listener.alCambiarRemanente(new RemanenteEventObject(this,remanente));
    }


    public void incrementarRemanente(){
        remanente++;
        listener.alCambiarRemanente(new RemanenteEventObject(this,remanente));
    }

    public void decrementarRemanente(){
        remanente--;
        listener.alCambiarRemanente(new RemanenteEventObject(this,remanente));
    }


    public void addRemanenteMinasListener(RemanenteMinasListener listener) {
        this.listener = listener;
    }

    public void resetRemanente() {
        setRemanente(nMinas);
    }
}

