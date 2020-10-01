
public class Main {
    public static <E> void main(String[] args){
        DoublyLinkedList list = new DoublyLinkedList();
        list = list.createList();

        System.out.println("Your list:");
        list.print();

        System.out.println("Your list in reverse:");
        list.printReverse();

        System.out.println("Your list, but the elements have been removed:");
        list.printRemove();

        System.out.println("Repopulate your list");
        list = list.createList();

        System.out.println("Your list in reverse, but the elements have been removed:");
        list.printReverseRemove();
    }
}
