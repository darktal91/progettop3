package Puzzle;

import java.rmi.*;
import java.rmi.server.*;

public class SolverPR extends UnicastRemoteObject implements Solver {
  private Scatola scatola = null;
  private Tassello[][] soluzione = null;
  private Tassello angoloNO = null;
  private int righe = 0;
  private int colonne = 0;
  
  private class ThreadSolver implements Runnable {
    private int indice;
    private Counter c;
    
    ThreadSolver(int i, Counter x) {
      indice = i;
      c = x;
      c.increment();
    }
    
    public void run() {
      costruisciRiga(indice);
      c.decrement();
    }
  }
  
  public SolverPR() throws RemoteException {}
  
  private void costruisciBordoOvest() {
    soluzione[0][0] = angoloNO;
    for(int i=1; i<soluzione.length; i++) {
      soluzione[i][0] = scatola.cerca(soluzione[i-1][0].getIdSud());
    }
  }
  
  private void costruisciRiga(int r) {
    for(int i=1; i<soluzione[r].length; i++) {
      soluzione[r][i] = scatola.cerca(soluzione[r][i-1].getIdEst());
    }
  }
  
  public Tassello[][] risolvi(Scatola s) throws RemoteException {
    boolean check = false;
    scatola = s;
    angoloNO = ((ScatolaBST) scatola).getAngoloNO();
    righe = scatola.getRighe();
    colonne = scatola.getColonne();
    
//     ********************************************
      try{Thread.sleep(4000);} catch(InterruptedException i) {System.out.println("MERDA");}
// 	  for(int i=0; i<9999999999; i++) {}
//       *******************************************
    
    if(righe != 0 && scatola.getNumeroPezzi() != 0 && scatola.getColonne() != 0) { //controlla che i dati nel file siano presenti e consistenti
      check = true;
    }
    else {
      colonne = 0; 
      righe=0;
    }
    soluzione = new Tassello[righe][colonne];
    
    if(check) { //costruisce la soluzione se e solo se i dati sono presenti e consistenti
      costruisciBordoOvest();
      
      Counter c = new Counter(0);
      
      for(int i=0; i<soluzione.length; i++) {
	new Thread(new ThreadSolver(i, c)).start();
      }
      
      
      synchronized(c) {
	while(c.getCount() != 0) {
	  try {
	    c.wait();
	  }
	  catch (InterruptedException e) {
	    System.err.println(e);
	  }
	}
      }
    }
    return soluzione;
  }
}