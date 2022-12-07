package arvoresBinarias;

public class BST {
  
  private Node root;

  public boolean isEmpty() {
    return this.root == null;
  }

  public void add(int element) {

    if(isEmpty()) {
      this.root = new Node(element);
    }
    else {
      Node aux = this.root;

      while(aux!= null) {

        if(element < aux.value) {
          if(aux.left == null) {
            Node newNode = new Node(element);
            aux.left = newNode;
            newNode.parent = aux;
            return;
          }
          aux = aux.left;
        } else {
          if(aux.right == null) {
            Node newNode = new Node(element);
            aux.right = newNode;
            newNode.parent = aux;
            return;
          }
          aux = aux.right;
        }
      }
    }
  }

  // para recursivo: pior caso O(h)

  public void recursiveAdd(int element) {
    if(isEmpty()) {
      this.root = new Node(element);
    } else {
      recursiveAdd(this.root, element);
    }
  }

  private void recursiveAdd(Node node, int element) {
    
    if(element < node.value) {
      if(node.left == null) {
        Node newNode = new Node(element);
        node.left = newNode;
        newNode.parent = node;
        return;
      }
      recursiveAdd(node.left, element);
    } else {
      if(node.right == null) {
        Node newNode = new Node(element);
        node.right = newNode;
        newNode.parent = node;
        return;
      }
      recursiveAdd(node.right, element);
    }
  }
}
