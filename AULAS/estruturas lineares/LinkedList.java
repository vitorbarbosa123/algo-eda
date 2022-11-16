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

    // Metodos da adição de elemento

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

    // metodos de busca de elemento

    public Aluno get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node aux = this.head;

        for(int i = 0; i < index; i++) {
            aux = aux.next;
        }

        return aux.aluno;
    }

    public int indexOf(Aluno aluno) {
        Node aux = this.head;
        int index = 0;
        while(aux != null) {
            if(aux.aluno.getMatricula().equals(aluno.getMatricula())) {
                return index;
            }
            aux = aux.next;
            index += 1;
        }

        return -1;
    }

    public boolean contains(Aluno aluno) {
        return indexOf(aluno) != -1;
    }

    public Aluno getFirst() {
        if(this.isEmpty()) return null;
        return this.head.aluno;
    }

    public Aluno getLast() {
        if(this.isEmpty()) return null;
        return this.tail.aluno;
    }
}
