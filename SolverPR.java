package Puzzle;

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
  
  public SolverPR(Scatola s) {
    scatola = s;
  }
  
  public void leggi(String input) {
    Path inputPath = Paths.get(input);
   
    try (BufferedReader reader = Files.newBufferedReader(inputPath, charset)) {
      String line = null;
      Tassello
      while ((line = reader.readLine()) != null) {
	
      }
    } 
    catch (IOException x) {
      System.err.format("IOException: %s%n", x);
    }
 
  }
  
  public void risolvi() {
    
  }
}