import Puzzle.*;

public class PuzzleSolver {
  private Solver solver;
  
  PuzzleSolver(Solver sol) {
    solver = sol;
  }
  
  public static void main(String[] args) {
    // controllo sui parametri, se sono meno di 2 (input e output) il programma termina con messaggio di errore
    if(args.length < 2) {
      System.err.println("Errore. Numero parametri errato.");
      System.err.println("Corretta invocazione: java PuzzleSolver <file_input> <file_output>");
    }
    else {
      String input = args[0];
      String output = args[1];
      
      
      Scatola scatola = new ScatolaBST();
      Solver sol = new SolverPR(scatola);
      
      PuzzleSolver risolutore = new PuzzleSolver(sol);
      risolutore.esegui(input, output);
    }
  }
  
  public void esegui(String input, String output) {
    solver.leggi(input);
    solver.risolvi();
    solver.scrivi(output);
  }
  
  public Solver getSolver() {
    return solver;
  }
  
  public void setSolver(Solver s) {
    solver = s;
  }
}