package carnet;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.*;

/** Implémentation basique d'un Carnet accessible à distance.
 *  Utilise une List(e) pour ranger les Individu(s).
 */
public class CarnetImpl extends UnicastRemoteObject implements Carnet {
    
    private List<Individu> contenu = new ArrayList<Individu>();


    public CarnetImpl() throws RemoteException {}

    @Override
    public void inserer(Individu x) throws RemoteException {
        
    }

    @Override
    public Individu chercher(String nom) throws RemoteException, IndividuInexistant {
        return null;
    }

    @Override
    public Individu get(int n) throws RemoteException, IndividuInexistant {
        return null;
    }

    @Override
    public Individu[] getAll() throws RemoteException {
        return new Individu[0];
    }

    @Override
    public void addCallbackOnCreation(CallbackOnCreation cb) throws RemoteException {

    }

    @Override
    public void removeCallbackOnCreation(CallbackOnCreation cb) throws RemoteException {

    }

    /**** A COMPLETER ****/
}
