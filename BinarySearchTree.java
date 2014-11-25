package StruttureDati;

public abstract class BinarySearchTree {
  protected BTNode root;
  
  public BinarySearchTree() {
    root = null;
  }
  public abstract void insert(BTNode nuovo);
  public abstract Object search(Object o);
}