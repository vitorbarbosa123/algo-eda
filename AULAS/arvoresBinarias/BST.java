package arvoresBinarias;

public class BST {
  
  private Node root;

  public boolean isEmpty() {
    return this.root == null;
  }

  // o novo elemento é adicionado como folha, devido a isso, é necessário que em uma nova
  // adição, seja percorrido toda a árvore para adicionar o elemento.
  // para ambos os tipos de adição: O(h), sendo h o maior caminho entre a raiz a todas as folhas
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

  // o algoritmo depende da altura da árvore, em seu pior caso ele percorre um ramo da árvore
  //até o seu final. 
  // para ambos os casos de busca: O(h), sendo h a altura do ramo
  public Node search(int element) {
    
    Node aux = this.root;

    while(aux != null) {
      if(aux.value == element) return aux;
      if(element < aux.value) aux = aux.left;
      if(element > aux.value) aux = aux.right;
    }

    return null;
  }

  public Node recursiveSearch(int element) {
    return recursiveSearch(this.root, element);
  }

  private Node recursiveSearch(Node node, int element) {

    if(node == null) return null;
    if(element == node.value) return node;
    if(element < node.value) return recursiveSearch(node.left, element);
    else return recursiveSearch(node.right, element);
  }

  public Node min() {
    if(isEmpty()) return null;
    return min(this.root);
  }

  private Node min(Node node) {
    if(node.left == null) return node;
    else return min(node.left);
  }
  
  public Node max(Node node) {
    
    while(node.right != null) {
      node = node.right;
    }
    return node;
  }

  public Node sucessor(Node node) {
    if(node == null) return null;

    if(node.right != null) {
      return min(node.right);
    } else {
      Node aux = node.parent;

      while(aux != null && aux.value < node.value) {
        aux = aux.parent;
      }

      return aux;
    }
  }

  public Node predecessor(Node node) {
    if(node == null) return null;

    if(node.left != null) {
      return max(node.left);
    } else {
      Node aux = node.parent;

      while(aux != null && aux.value > node.value) {
        aux = aux.parent;
      }

      return aux;
    }
  }
}
