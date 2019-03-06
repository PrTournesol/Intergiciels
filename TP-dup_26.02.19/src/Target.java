import java.io.Serializable;

/** Destinataire d'un message UDP : une machine + un numéro de port. */
public class Target implements Serializable {
    private static final long serialVersionUID = 1L;

    public String host;
    public int port;

    public Target(String host, int port) {
        this.host = host;
        this.port = port;
    }
}
