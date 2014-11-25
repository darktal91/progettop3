package StruttureDati;

abstract public class BTNode {
  protected BTNode left, right;
 
  public BTNode(Object d, BTNode l, BTNode r) {
    left = l;
    right = r;
  }
  
  public Object getData() {
    return data;
  }
 
  public BTNode() {
    BTNode(null, null);
  }
  
  public BTNode getLeftChild() {
    return left;
  }
  
  public BTNode getRightChild() {
    return right;
  }
  
  public bool isLeaf() {
    return left == null && right == null;
  }
  
  public void setLeftChild(BTNode l) {
    left = l;
  }
  
  public void setRightChild(BTNode r) {
    right = r;
  }
  
  abstract public bool biggerThan(BTNode altro);
}