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

    public DoublyLinkedList(){
        header = new Node<>(null,null,null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        }
        return header.getNext().getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return trailer.getPrev().getElement();
    }
    //update methods
    public void addBetween(E e, Node<E> predecessor, Node<E> successor){
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
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

        System.out.println("Enter a character. Press 'Enter' to finish.");
        String input = sc.nextLine();

        if (input == ""){
            System.out.println("List created!");
        } else {
            addBetween((E)input, trailer.getPrev(), trailer);
            createList();
        }
        return this;
    }
}
