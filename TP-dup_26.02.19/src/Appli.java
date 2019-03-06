import java.util.Random;

/** Code applicatif : génération de mises à jour. */
public class Appli extends Thread {

    private Group group;

    public Appli(Group g) {
        group = g;
    }

    public void run() {
        Random rand = new Random();
        for (int i = 0; i < 200; i++) {
            int index = rand.nextInt(ClientImpl.nbData);
            int op = rand.nextInt(2);
            int val = rand.nextInt(3)+1;

            group.sendUpdate(new Update(index, op, val));
        }
        System.out.println("Application completed");
    }

}
