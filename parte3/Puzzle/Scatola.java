package Puzzle;

public interface Scatola implements Serializable {
  public void inserisci(Tassello t);
  public Tassello cerca(String id);
  public int getNumeroPezzi();
  public int getRighe();
  public int getColonne();
}