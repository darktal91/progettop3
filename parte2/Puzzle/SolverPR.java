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
  private int righe;
  private int colonne;
  private Tassello angoloNO;
  private Tassello[][] soluzione;
  
  private class ThreadSolver implements Runnable {
    private int indice;
    private Counter c;
    
    ThreadSolver(int i, Counter x) {
      indice = i;
      c = x;
      c.increment();
    }
    
    public void run() {
      costruisciRiga(indice);
      c.decrement();
    }
  }
  
  public SolverPR(Scatola s) {
    scatola = s;
    righe = 0;
    angoloNO = null;
  }
  
  public void leggi(String input) throws InputInconsistente {
    Path inputPath = Paths.get(input);
   
    try (BufferedReader reader = Files.newBufferedReader(inputPath, charset)) {
      String line = null;
      String[] temp = null;
      Tassello_str t = null;
      while ((line = reader.readLine()) != null) {
	temp = line.split("\t");
	
	if(temp.length < 6) {
	  throw new InputInconsistente();
	}
	
	t = new Tassello_str(temp[0].trim(), temp[2].trim(), temp[4].trim(), temp[3].trim(), temp[5].trim(), temp[1]);
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
    boolean check = false;
    if(righe != 0 && scatola.getNumeroPezzi() != 0 && scatola.getNumeroPezzi()%righe == 0) { //controlla che i dati nel file siano presenti e consistenti
      colonne = scatola.getNumeroPezzi() / righe;
      check = true;
    }
    else {
      colonne = 0;
    }
    soluzione = new Tassello[righe][colonne];
    
    if(check) { //costruisce la soluzione se e solo se i dati sono presenti e consistenti
      costruisciBordoOvest();
      
      Counter c = new Counter(0);
      
      for(int i=0; i<soluzione.length; i++) {
	new Thread(new ThreadSolver(i, c)).start();
      }
      
      
      synchronized(c) {
	while(c.getCount() != 0) {
	  try {
	    c.wait();
	  }
	  catch (InterruptedException e) {
	    System.err.println(e);
	  }
	}
      }
    }
  }
  
  public void scrivi(String output) {
    Path outputPath = Paths.get(output);
    
    try (BufferedWriter writer = Files.newBufferedWriter(outputPath, charset)) {
      StringBuilder builder = new StringBuilder();
      
      for(int i=0; i<soluzione.length; i++) {
	for(int j=0; j<soluzione[i].length; j++) {
	  builder.append(soluzione[i][j].getInfo());
	}
      }
      
      builder.append("\n");
      builder.append("\n");
      
      for(int i=0; i<soluzione.length; i++) {
	for(int j=0; j<soluzione[i].length; j++) {
	  builder.append(soluzione[i][j].getInfo());
	  builder.append("\t");
	}
	builder.append("\n");
      }
      
      builder.append("\n");
      
      builder.append(righe + " " + colonne);
      
      writer.write(builder.toString());
    }
    catch(IOException e) {
      System.err.println(e);
    }
  }
}