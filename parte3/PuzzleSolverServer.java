import Puzzle.*;
import java.rmi.*;

public class PuzzleSolverServer {
  public static final String HOST = "localhost";
  
  public static void main(String[] args) throws Exception {
    if(args.length < 1) {
      System.err.println("Errore. Numero parametri errato.");
      System.err.println("Corretta invocazione: java PuzzleSolverServer nome_del_server");
    }
    else {
      Solver sol = new SolverRem();
      String rmiObjName = "rmi://" + HOST + "/" + args[0];
      Naming.rebind(rmiObjName, sol);
      System.out.println("Server pronto");
    }
  }
}