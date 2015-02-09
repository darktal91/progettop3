package Puzzle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOManager {
  private static Charset charset = StandardCharsets.UTF_8;
  
  public Scatola leggi(String input) throws InputInconsistente {
    Path inputPath = Paths.get(input);
    ScatolaBST scatola = new ScatolaBST();
    
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
	
	scatola.inserisci(t);
      }
    } 
    catch (IOException e) {
      System.err.println(e);
    }
    
    return scatola;
  }

  public void scrivi(String output, Tassello[][] soluzione){
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
      
      builder.append(soluzione.length + " " + soluzione[0].length);
      
      writer.write(builder.toString());
    }
    catch(IOException e) {
      System.err.println(e);
    }
  }
}