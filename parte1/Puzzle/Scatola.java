package Puzzle;

public interface Scatola {
  public void inserisci(Tassello t);
  public Tassello cerca(String id);
  public int getNumeroPezzi();
}