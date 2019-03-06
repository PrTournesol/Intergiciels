import java.rmi.Remote;
import java.rmi.RemoteException;

/** Interface distante du client. */
public interface Client extends Remote {

    /** Appelé par le serveur pour donner le groupe. */
    public void setGroup (Group g) throws RemoteException;
    
    /** Appelé par le serveur pour activer le code applicatif. */
    public void start() throws RemoteException;
    
    /** Appelé par le serveur pour obtenir les données locales du client. */
    public int[] getData() throws RemoteException;
}
