public class Tassello_str extends Tassello {
  private String info;
  
  public Tassello_str(String new_id, String idn, String ids, String ide, String ido, String informazione) {
    super(new_id, idn, ids, ide, ido);
    info = informazione;    
  }
  
  public Tassello_str(String informazione) {
    String newid = null;
    String idn = null;
    String ids = null;
    String ide = null;
    String ido = null;
    Tassello_str(newid, idn, ids, ide, ido, informazione);
  }
  
  public Tassello_str() {
    String informazione = null;
    Tassello_str(informazione);
  }
  
  public String getInfo() {
    return info;
  }
  
  public void setInfo(String informazione) {
    info = informazione;
  }
}