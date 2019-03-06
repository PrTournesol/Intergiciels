import java.io.Serializable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class Group implements java.io.Serializable {
	
    private static final long serialVersionUID = 1L;
	
    private Set<Target> targets = new HashSet<Target>();
    private DatagramSocket sock = null;

    /** Initialise cette instance pour envoyer/recevoir sur le port spécifié. */
    public void init(int localPort) {
        try {
            sock = new DatagramSocket(localPort);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Random rand = new Random();

    /** Envoie le paquet p avec un retard de 0 à 20 ms (pour simuler le désordre d'UDP) */
    private void delayedSend(DatagramPacket p) {
        final DatagramPacket pp = p;
        new Thread(() -> {
                    try {
                        Thread.sleep(rand.nextInt(20));
                        sock.send(pp);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }).start();
    }
    
    /** Diffuse la mise à jour <code>u</code> à tous les membres du groupe. */
    public void sendUpdate(Update u) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(u);
            byte[] buff = baos.toByteArray();
            for (Target t : targets) {
                DatagramPacket p = new DatagramPacket(buff, buff.length, InetAddress.getByName(t.host), t.port);
                //sock.send(p);
                delayedSend(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Réception bloquante d'une mise à jour. */
    public Update receiveUpdate() {
        try {
            byte buff[] = new byte[1000];
            DatagramPacket p = new DatagramPacket(buff, buff.length);
            sock.receive(p);
            ByteArrayInputStream bais = new ByteArrayInputStream(buff);
            ObjectInputStream ois = new ObjectInputStream(bais);
            Update u = (Update)ois.readObject();
            return u;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
    /** Ajout d'un client au groupe. */
    public void addClient(String host, int port) {
        targets.add(new Target(host,port));
    }

}


 
