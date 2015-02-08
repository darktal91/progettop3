package Puzzle;

public abstract class Tassello {
  private String id;
  private String id_nord, id_sud, id_est, id_ovest;
  
  public Tassello(String new_id, String idn, String ids, String ide, String ido) {
    id = new_id;
    id_nord = idn;
    id_sud = ids;
    id_est = ide;
    id_ovest = ido;
  }
  
  public abstract Object getInfo();
  
  public String getId() {
    return id;
  }
  
  public String getIdNord() {
    return id_nord;
  }
  
  public String getIdSud() {
    return id_sud;
  }
  
  public String getIdEst() {
    return id_est;
  }
  
  public String getIdOvest() {
    return id_ovest;
  }
  
  public void setId(String new_id) {
    id = new_id;
  }
  
  public void setIdNord(String idn) {
    id_nord = idn;
  }
  
  public void setIdSud(String ids) {
    id_sud = ids;
  }
  
  public void setIdEst(String ide) {
    id_est = ide;
  }
  
  public void setIdOvest(String ido) {
    id_ovest = ido;
  }
  
  public boolean maggioreDi(Tassello t) {
    int r = this.id.compareTo(t.getId());
    if(r > 0) {
      return true;
    }
    else {
      return false;
    }
  }
}