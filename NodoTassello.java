public class NodoTassello {
  private Tassello data;
  private NodoTassello left, right;
  
  public NodoTassello(Tassello d) {
    data = d;
    left = null;
    right = null;
  }
  
  public NodoTassello() {
    data = null;
    left = null;
    right = null;
  }
  
  public Tassello getData() {
    return data;
  }
  
  public NodoTassello getLeftChild() {
    return left;
  }
  
  public NodoTassello getRightChild() {
    return right;
  }
  
  public void setData(Tassello t) {
    data = t;
  }
  
  public void setLeftChild(NodoTassello n) {
    left = n;
  }
  
  public void setRightChild(NodoTassello n) {
    right = n;
  }
  
  public boolean isLeaf() {
    return (left == null && right == null);
  }
}