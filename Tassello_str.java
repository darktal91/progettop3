public class Tassello_str extends Tassello {
  private String info;
  
  public Tassello_str(String new_id, String idn, String ids, String ide, String ido, String informazione) {
    info = informazione;
    super(new_id, idn, ids, ide, ido);
  }
  
  public Tassello_str(String informazione) {
    Tassello_str(null, null, null, null, null, informazione);
  }
  
  public Tassello_str() {
    Tassello_str(null);
  }
  
  public String getInfo() {
    return info;
  }
  
  public void setInfo(String informazione) {
    info = informazione;
  }
}