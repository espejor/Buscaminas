package principal;

import controlador.Controlador;
import modelo.Modelo;
import vista.Ventana;

public class Main {
    public static void main(String args[]) {
        Modelo modelo = new Modelo();
        Ventana vista = new Ventana();
        new Controlador(vista,modelo);

        vista.inicio();
    }
}
