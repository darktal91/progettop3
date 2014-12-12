package Puzzle;

public interface Solver {
  public void leggi(String input) throws InputInconsistente;
  public void scrivi(String output);
  public void risolvi();
}