class Node {

    Aluno aluno;
    Node next; 
    Node prev;

    public Node(Aluno aluno) {
        this.aluno = aluno;
        this.prev = null;
        this.next = null;
    }
}