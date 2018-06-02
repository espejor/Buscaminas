package controlador;

import java.util.EventListener;

public interface RemanenteMinasListener extends EventListener {
    void alCambiarRemanente(RemanenteEventObject evento);
}
