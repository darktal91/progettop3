public class ScatolaBST implements Scatola {
  private NodoTassello root;
  private int pezzi;
  
  public ScatolaBST() {
    root = null;
    pezzi = 0;
  }
  
  public int getPezzi() {
    return pezzi;
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
      if(id.equals(p.getInfo().getId())) {
	found = true;
      }
      else {
	if(id.compareTo(p.getInfo().getId()) > 0) { //l'id che sto cercando è più grando di quello del nodo analizzato, proseguo nel sottoalbero destro
	  p = p.getRightChild();
	}
	else { //l'id che sto cercando è più piccolo di quello del nodo analizzato, proseguo nel sottoalbero sinistro
	  p = p.getLeftChild();
	}
      }
    }
    
    if(found) {
      return p.getInfo();
    }
//     else {
//       ERRORE!!! ECCEZIONE! MERDA!
//     }
  }
  
}