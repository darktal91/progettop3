package Puzzle;

public class InputInconsistente extends Exception {
  public String toString() {
    return "Dati contenuti nel file di input inconsistenti o formattati in modo non corretto";
  }
}