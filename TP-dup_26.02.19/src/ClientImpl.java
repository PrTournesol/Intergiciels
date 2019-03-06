import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/** Programme client : deux activités Appli et Daemon, + invocable à distance par le Launcher. */
public class ClientImpl extends UnicastRemoteObject implements Client {

    private static final long serialVersionUID = 1L;

    private static final int registryPort = 5000;
    private static String registryHost = "localhost";

    public static Launcher launcher;
    public static final int nbData = 10;
    public static int data[] = new int[nbData];
	
    private Group group;
    private static int localPort;
    
    protected ClientImpl() throws RemoteException {
    }

    /** Appelé par le serveur pour donner le groupe. */
    public void setGroup(Group g) throws RemoteException {
        System.out.println("set group");
        group = g;
        group.init(localPort);
        Daemon d = new Daemon(g);
        d.start();
    }
	
    /** Appelé par le serveur pour activer le code applicatif. */
    public void start () throws RemoteException {
        System.out.println("start client");
        Appli a = new Appli(group);
        a.start();
    }
	
    /** Appelé par le serveur pour obtenir les données locales du client. */
    public int[] getData() throws RemoteException {
        return data;
    }
	
    public static void main(String args[]) {
        String localHost = null;
        try {
            if (args.length == 2) {
                registryHost = args[0];
                localPort = Integer.parseInt(args[1]);
            } else if (args.length == 1) {
                localPort = Integer.parseInt(args[0]);
            } else {
                System.err.println ("ClientImpl [<machine serveur de nom>] <numero de port du client>");
                System.exit(1);
            }
            localHost = InetAddress.getLocalHost().getHostName();
            for (int i=0;i<nbData;i++) data[i] = 0;
            launcher = (Launcher)Naming.lookup("//"+registryHost+":"+registryPort+"/Launcher");
            launcher.addClient(localHost, localPort, new ClientImpl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	

}
