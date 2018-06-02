package controlador;

import java.util.EventObject;

public class RemanenteEventObject extends EventObject{
    private int remanente;

    /**
     * Constructs a prototypical Event.
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public RemanenteEventObject(Object source,int remanente) {
        super(source);
        this.remanente = remanente;
    }

    /**
     * Getter de remanente
     * @return remanente
     */
    public int getRemanente() {
        return remanente;
    }
}
