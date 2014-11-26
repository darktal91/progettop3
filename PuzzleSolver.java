package Puzzle;

public class PuzzleSolver {
  Solver solver;
  
  PuzzleSolver(Solver sol) {
    solver = sol;
  }
  
  public static void main(String[] args) {
    String input = args[0];
    String output = args[1];
    
    
    Scatola scatola = new ScatolaBST();
    Solver solver = new SolverPR(scatola);
    
    PuzzleSolver risolutore = new PuzzleSolver(solver);
    risolutore.esegui(input, output);
  }
  
  private void esegui(String input, String output) {
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