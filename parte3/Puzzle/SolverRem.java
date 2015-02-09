package Puzzle;

import java.rmi.*;
import java.rmi.server.*;

public class SolverRem extends UnicastRemoteObject implements Solver {
  public SolverRem() throws RemoteException {}
  
  public Tassello[][] risolvi(Scatola s) throws RemoteException {
    SolverPR spr = new SolverPR();
    return spr.risolvi(s);
  }
}