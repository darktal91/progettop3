package Puzzle;

public class ScatolaBST implements Scatola {
  private NodoTassello root;
  private int pezzi;
  private int righe;
  private NodoTassello angoloNO;
  
  public ScatolaBST() {
    root = null;
    pezzi = 0;
    righe = 0;
    angoloNO = null;
  }
  
  //funzione privata di utilità che implementa l'inserimento di un nodo in modo ricorsivo
  private void inserisciRicorsiva(NodoTassello ref, NodoTassello nuovo) {
    if(nuovo.getData().maggioreDi(ref.getData())) { 
      // il nuovo nodo è maggiore del nodo attualmente considerato, quindi va inserito nel sottoalbero destro
      if(ref.getRightChild() == null) { // non esiste sottoalbero destro, il nuovo nodo va inserito come foglia destra
	ref.setRightChild(nuovo);
	pezzi++;
      }
      else { //esiste un sottoalbero destro, richiamo l'inserimento ricorsivo
	inserisciRicorsiva(ref.getRightChild(), nuovo);
      }
    }
    else {
      //il nuovo nodo è minore del nodo attualmente considerato, quindi va inserito nel sottoalbero sinistro
      if(ref.getLeftChild() == null) { //non esiste sottoalbero sinistro, il nuovo nodo va inserito come foglia sinistra
	ref.setLeftChild(nuovo);
	pezzi++;
      }
      else { //esiste un sottoalbero sinistro, richiamo l'inserimento ricorsivo
	inserisciRicorsiva(ref.getLeftChild(), nuovo);
      }
    }
  }
  
  public void inserisci(Tassello t) {
    NodoTassello nuovo = new NodoTassello(t);
    
    if(t.getIdOvest().equals("VUOTO")) {
      righe++;
      if(t.getIdNord().equals("VUOTO"))
	angoloNO = nuovo;
    }
    
    if(root == null) {
      root = nuovo;
      pezzi++;
    }
    else {
      inserisciRicorsiva(root, nuovo);
    }
  }
  
  public Tassello cerca(String id) {
    NodoTassello p = root;
    boolean found = false;
    
    while(!found) {
      if(id.equals(p.getData().getId())) {
	found = true;
      }
      else {
	if(id.compareTo(p.getData().getId()) > 0) { //l'id che sto cercando è più grando di quello del nodo analizzato, proseguo nel sottoalbero destro
	  p = p.getRightChild();
	}
	else { //l'id che sto cercando è più piccolo di quello del nodo analizzato, proseguo nel sottoalbero sinistro
	  p = p.getLeftChild();
	}
      }
    }
    
    if(found) {
      return p.getData();
    }
    else {
      return null;
    }
  }
  
  public int getNumeroPezzi() {
    return pezzi;
  }
  
  public int getRighe() {
    return righe;
  }
  
  public int getColonne() {
    if(righe != 0)
      return pezzi/righe;
    else
      return 0;
  }
  
  public Tassello getAngoloNO() {
    return angoloNO.getData();
  }  
}