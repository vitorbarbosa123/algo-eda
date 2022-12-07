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

  public int height() {
    return height(this.root);
  }

  private int height(Node node) {
    if(node == null) return -1;
    else return 1 + Math.max(height(node.left), height(node.right));
  }

  // metodo 1: remove uma folha ou raiz; a folha a ser removida é repassada; 
  public void removeLeaf(Node node) {

    if(node.value == this.root.value) {
      this.root = null;

    } else {
      if(node.value < node.parent.value) {
        node.parent.left = null;

      } else {
        node.parent.right = null;
      }
    }
  }

  // metodo 2: remover um nó que possuí um filho
  public void removeNodeSingleChild(Node node) {

      // verificar se possuí um único filho na esquerda
      if(node.value == this.root.value) {
        this.root = node.left;
        this.root.parent = null;
  
      } else {
        node.left.parent = node.parent;
        if(node.value < node.parent.value) {
          node.parent.left = node.left;
  
        } else {
          node.parent.right = node.left;
        }
      }
      
      // verificar se possuí um único filho na direita
      if(node.value == this.root.value) {
        this.root = node.right;
        this.root.parent = null;
      } else {
        node.right.parent = node.parent;
        if(node.value < node.parent.value) {
          node.parent.left = node.right;
  
        } else {
          node.parent.right = node.right;
        }
      }
  }

  public void removeNodeWithTwoChilds(Node node) {

    Node sucessor = sucessor(node);
    node.value = sucessor.value;
    removeLeaf(sucessor);
  }

  public void preOrder() {
    preOrder(this.root);
  }

  private void preOrder(Node node) {
    if(node != null) {
      System.out.println(node.value);
      preOrder(node.left);
      preOrder(node.right);
    }
  }
  
  public void inOrder() {
    inOrder(this.root);
  }

  private void inOrder(Node node) {
    
    if(node != null) {
      inOrder(node.left);
      System.out.println(node.value);
      inOrder(node.right);
    }
  }

  public void posOrder() {
    posOrder(this.root);
  }

  private void posOrder(Node node) {
    if(node != null) {
      posOrder(node.left);
      posOrder(node.right);
      System.out.println(node.value);
    }
  }

}
