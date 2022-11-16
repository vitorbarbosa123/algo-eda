public class LinkedList {
    
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void addLast(Aluno aluno) {
        Node newNode = new Node(aluno);

        if(isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = tail;
            this.tail = newNode;
        }
        this.size += 1;
    }

    public void addFirst(Aluno aluno) {
        Node newNode = new Node(aluno);

        if(isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.size += 1;
    }

    public void add(int index, Aluno aluno) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node newNode = new Node(aluno);

        if(index == 0) {
            this.addFirst(aluno);
        } 
        else if (index == size - 1) {
            this.addLast(aluno);
        }
        else {
            Node aux = this.head;

            for(int i = 0; i < index - 1; i++) {
                aux = aux.next;
            }

            newNode.next = aux.next;
            aux.next = newNode;
            newNode.next.prev = newNode;
            newNode.prev = aux;

            size += 1;
        }
    }
}
