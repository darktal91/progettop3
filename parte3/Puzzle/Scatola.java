package Puzzle;

import java.io.Serializable;

public interface Scatola extends Serializable {
  public void inserisci(Tassello t);
  public Tassello cerca(String id);
  public int getNumeroPezzi();
  public int getRighe();
  public int getColonne();
}