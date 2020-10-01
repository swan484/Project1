import java.util.Scanner;

public class DoublyLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;
    private String temp = "";
    int num = 0;
    String input;

    public DoublyLinkedList(){
        header = new Node<>(null,null,null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    //update methods
    public void addBetween(E e, Node<E> predecessor, Node<E> successor){
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    public E remove(Node<E> node){
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    public void print(){
        Node<E> current = header.getNext();
        while (current.getNext()!= null){
            System.out.print(current.getElement() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public void printRemove(){
        Node<E> current = header.getNext();
        while (current.getNext()!= null){
            System.out.print(remove(current) + " ");
            current = header.getNext();
        }
        System.out.println();
    }

    public void printReverse(){
        Node<E> current = trailer.getPrev();
        while (current.getPrev()!= null){
            System.out.print(current.getElement() + " ");
            current = current.getPrev();
        }
        System.out.println();
    }

    public void printReverseRemove(){
        Node<E> current = trailer.getPrev();
        while (current.getPrev()!= null){
            System.out.print(remove(current) + " ");
            current = trailer.getPrev();
        }
        System.out.println();
    }

    // This creates an arbitrary sized double linked list based on user input.
    public DoublyLinkedList createList(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a character. Type \"/DONE\" to finish.");
        temp = sc.nextLine();
        input += temp + " ";

        if (temp.equals("/DONE")){
            System.out.println("List created!");
        } else {
            addLast((E)temp);
            createList();
            num ++;
        }
        return this;
    }

    //This takes previously stored user input and recreates list
    public void repopulate(){
        int j = 3;
        String[] sArray = new String[num];
        for(int i = 0; i < num; i++){
            j++;
            sArray[i] = "";
            while(input.charAt(j) != ' '){
                sArray[i] += input.charAt(j);
                j++;
            }
        }

        for(int i = 0; i < num; i ++){
            addLast((E) sArray[i]);
        }
    }
}
