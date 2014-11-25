package Puzzle;

import StruttureDati.*;

public class ProvaScatolaBST extends BinarySearchTree implements Scatola {
  ProvaScatolaBST() {
    super.BinarySearchTree();
  }
  
  public void insert(BTNode nuovo) {
    if(root == null) {
      root = nuovo;
    }
    else {
      recursiveInsert(root, nuovo);
    }
  }
  
  private void recursiveInsert(BTNode ref, BTNode nuovo) {
    if(nuovo.getData().MaggioreDi(ref.getData())) {
      
    }
  }
  
}