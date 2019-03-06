import java.rmi.Remote;
import java.rmi.RemoteException;

/** Interface distante du serveur. */
public interface Launcher extends Remote {
    public void addClient(String host, int port, Client c) throws RemoteException;

    public int getTicket();

}
