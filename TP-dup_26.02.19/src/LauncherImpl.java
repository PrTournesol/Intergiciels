import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.Set;

/** Classe serveur. */
public class LauncherImpl extends UnicastRemoteObject implements Launcher {

    private static final long serialVersionUID = 1L;
	
    private static final int registryPort = 5000;
	
    private Group group = new Group();
    private Set<Client> clients = new HashSet<Client>();
	
    protected LauncherImpl() throws RemoteException {
    }

    /**** Remote methods ****/

    synchronized public void addClient(String host, int port, Client c) throws RemoteException {
        System.out.println("received "+host+" "+port);
        group.addClient(host, port);
        clients.add(c);
    }

    @Override
    public int getTicket() {
        //TODO
        return 0;
    }

    /**** Local methods ****/
    
    public void go() {
        try {
            for (Client c : clients) {
                c.setGroup(group);
            }
            for (Client c : clients) {
                c.start();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
	
    public void print() {
    	int numcl = 1;
        for (Client c : clients) {
            System.out.print("Client "+numcl+" : ");
            numcl++;
            try {
                int d[] = c.getData();
                for (int i=0;i<ClientImpl.nbData;i++) System.out.print(d[i]+" ");
                System.out.println();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /**** Main ****/
    
    public static void main(String args[]) {
        try {
            LauncherImpl launcher = new LauncherImpl();
            LocateRegistry.createRegistry(registryPort);
            Naming.bind("//localhost:"+registryPort+"/Launcher", launcher);
            new Control(launcher);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
