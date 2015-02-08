package Puzzle;

import java.rmi.*;

public interface Solver extends Remote {
  public Tassello[][] risolvi(Scatola s) throws RemoteException;
}