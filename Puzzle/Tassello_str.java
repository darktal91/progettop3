package Puzzle;

public class Tassello_str extends Tassello {
  private String info;
  
  public Tassello_str(String new_id, String idn, String ids, String ide, String ido, String informazione) {
    super(new_id, idn, ids, ide, ido);
    info = informazione;    
  }
  
  public String getInfo() {
    return info;
  }
  
  public void setInfo(String informazione) {
    info = informazione;
  }
}