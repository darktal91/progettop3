import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SolverPR implements Solver {
  private Scatola scatola;
  private static Charset charset = StandardCharsets.UTF_8;
  private int righe;
  private int colonne;
  private Tassello angoloNO;
  private Tassello[][] soluzione;
  
  public SolverPR(Scatola s) {
    scatola = s;
    righe = 0;
    Tassello = null;
  }
  
  public void leggi(String input) {
    Path inputPath = Paths.get(input);
   
    try (BufferedReader reader = Files.newBufferedReader(inputPath, charset)) {
      String line = null;
      String[] temp = null;
      Tassello_str t = null;
      while ((line = reader.readLine()) != null) {
	temp = line.split("\t");
	
	t = new Tassello_str(temp[0], temp[2], temp[4], temp[3], temp[5], temp[1]);
	if(temp[5].equals("VUOTO")) {
	  righe++;
	  if(temp[2].equals("VUOTO")) {
	    angoloNO = t;
	  }
	}
	scatola.inserisci(t);
      }
    } 
    catch (IOException e) {
      System.err.println(e);
    }
 
  }
  
  private void costruisciBordoOvest() {
    soluzione[0][0] = angoloNO;
    for(int i=1; i<soluzione.length; i++) {
      soluzione[i][0] = scatola.cerca(soluzione[i-1][0].getIdSud());
    }
  }
  
  private void costruisciRiga(int r) {
    for(int i=1; i<soluzione[r].length; i++) {
      soluzione[r][i] = scatola.cerca(soluzione[r][i-1].getIdEst());
    }
  }
  
  public void risolvi() {
    colonne = scatola.getPezzi() / righe;
    soluzione = new Tassello[righe][colonne];
    costruisciBordoOvest();
    for(int i=0; i<soluzione.length; i++) {
      costruisciRiga(i);
    }
  }
  
  public void scrivi(String output) {
    Path outputPath = Paths.get(output);
    
    try (BufferedWriter writer = new newBufferedWriter(outputPath, charset)) {
      StringBuilder builder = new StringBuilder();
      for(int i=0; i<soluzione.length; i++) {
	for(int j=0; j<soluzione[i].length; j++) {
	  builder.append(soluzione[i][j].getInfo());
	}
      }
      
      builder.newLine();
      builder.newLine();
      
      for(int i=0; i<soluzione.length; i++) {
	for(int j=0; j<soluzione[i].length; j++) {
	  builder.append(soluzione[i][j].getInfo());
	  builder.append("\t");
	}
	builder.newLine();
      }
      
      builder.newLine();
      
      builder.append(righe + " " + colonne);
      
      writer.write(builder);
    }
  }
}