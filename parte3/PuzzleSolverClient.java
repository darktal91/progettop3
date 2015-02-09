import Puzzle.*;
import java.rmi.*;

public class PuzzleSolverClient {
  public static final String HOST = "localhost";
  
  public static void main(String[] args) throws Exception {
    if(args.length < 3) {
      System.err.println("Errore. Numero parametri errato.");
      System.err.println("Corretta invocazione: java PuzzleSolverClient file_input file_output nome_del_server");
    }
    else {
      String input = args[0];
      String output = args[1];
      
      IOManager io = new IOManager();
      
      try {
	Scatola scatola = io.leggi(input);
	Solver sol = (Solver) Naming.lookup("rmi://" + HOST + "/" + args[2]);
	Tassello[][] soluzione = sol.risolvi(scatola);
	io.scrivi(output, soluzione);
      }
      catch(ConnectException e) {
	System.out.println("Problemi di connessione al server");
      }
      catch(InputInconsistente ic) {
	System.out.println(ic);
      }
      catch(RemoteException r) {
	System.out.println("Connessione al server persa.");
      }
      catch(Exception exc) {
	exc.printStackTrace();
      }
    }
  }
}