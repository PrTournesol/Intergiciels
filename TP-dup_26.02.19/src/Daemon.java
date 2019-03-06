
/** Classe de réception des mises à jour. */
public class Daemon extends Thread {

    private Group group;

    public Daemon(Group g) {
        group = g;
    }
    
    /** Boucle de réception d'une mise à jour et de son application. */
    public void run() {
        while (true) {
            Update u = group.receiveUpdate();
            if (u.op == Update.ADD) ClientImpl.data[u.index] += u.val;
            if (u.op == Update.MUL) ClientImpl.data[u.index] *= u.val;
        }
    }
}
